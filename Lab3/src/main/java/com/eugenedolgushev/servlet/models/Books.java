package com.eugenedolgushev.servlet.models;

import com.eugenedolgushev.servlet.controllers.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class Books {
    private Connection connection;
    private static Logger log = Logger.getLogger(Books.class.getName());
    private static final Integer SURNAMEINDEX = 2;
    private static final Integer NAMEINDEX = 3;
    private static final Integer TITLEINDEX = 4;
    private static final Integer DATEINDEX = 5;
    private static final Integer PAGESINDEX = 6;
    private static final String ERROR_INVALIDINPUT = "Invalid input";
    private static final String ERROR_UNCORRECTDATA = "Некорректные данные!";
    private static final String SUCCESS_MESSAGE = "Книга успешно добавлена.";

    public Books() throws IOException {
        connection = DBConnection.getConnection();
    }

    public final void addBookToDB(Book book) {
        String query = "insert into books (surname, name, title, releaseDate, pages) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(SURNAMEINDEX-1, book.getAuthorSurname());
            preparedStatement.setString(NAMEINDEX-1, book.getAuthorName());
            preparedStatement.setString(TITLEINDEX-1, book.getTitle());
            preparedStatement.setString(DATEINDEX-1, new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishYear()));
            preparedStatement.setInt(PAGESINDEX-1, book.getPages());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            log.severe(e.getMessage());
        }
    }

    public final String addBook(final String authorSurname, final String authorName,
                        final String bookTitle, final String publishYear, final String pagesCount){
        String surname = authorSurname.trim();
        String name = authorName.trim();
        String title = bookTitle.trim();
        String year = publishYear.trim();
        String pages = pagesCount.trim();
        if (surname.isEmpty() || name.isEmpty() || title.isEmpty()) {
            log.warning(ERROR_INVALIDINPUT);
            return ERROR_UNCORRECTDATA;
        }
        if (year.isEmpty() || pages.isEmpty()) {
            log.warning(ERROR_INVALIDINPUT);
            return ERROR_UNCORRECTDATA;
        }

        Integer bookPages;
        try {
            bookPages = Integer.parseInt(pages);
        } catch(Exception e) {
            log.warning(ERROR_INVALIDINPUT);
            return ERROR_UNCORRECTDATA;
        }

        Date bookYear;
        try {
            bookYear = new SimpleDateFormat("yyyy-MM-dd").parse(year);
        } catch(ParseException e) {
            log.warning(ERROR_INVALIDINPUT);
            return ERROR_UNCORRECTDATA;
        }

        Book newBook = new Book(surname, name, title, bookYear, bookPages);
        addBookToDB(newBook);
        return SUCCESS_MESSAGE;
    }

    public final ArrayList<Book> getBooks(){
        String query = "select id, surname, name, title, releaseDate, pages from books";
        ArrayList<Book> books = new ArrayList<Book>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String authorSurname = resultSet.getString(SURNAMEINDEX);
                String authorName = resultSet.getString(NAMEINDEX);
                String title = resultSet.getString(TITLEINDEX);
                Date publishYear = resultSet.getDate(DATEINDEX);
                Integer pages = resultSet.getInt(PAGESINDEX);
                Book newBook = new Book(authorSurname, authorName, title, publishYear, pages);
                books.add(newBook);
            }

        } catch (SQLException e) {
            log.severe(e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.severe(e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.severe(e.getMessage());
                }
            }
        }

        return books;
    }
}