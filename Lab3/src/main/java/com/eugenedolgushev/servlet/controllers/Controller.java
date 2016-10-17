package com.eugenedolgushev.servlet.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.ResultSet;
import java.sql.Statement;

import com.eugenedolgushev.servlet.models.Books;

public class Controller {

    private String status = "";
    private static String url = "jdbc:mysql://localhost:3306/lab2.db";
    private static String user = "root";
    private static String password = "svenSPS678";

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;

    public Controller() {

    }

    public Books execute(String authorSurname, String authorName, String title, String publishYear, String pages, Books books) {
        String surname, name, title1;
        Date year;
        Integer pages1;
        String query = "insert into books (surname, name, title, releaseDate, pages) values (";

        try {
            surname = authorSurname.trim();
            name = authorName.trim();
            title1 = title.trim();
            year = new SimpleDateFormat("yyyy-MM-dd").parse(publishYear.trim());
            pages1 = Integer.parseInt(pages.trim());

            System.out.println(year);

            if (!surname.isEmpty() && !name.isEmpty() && !title1.isEmpty()) {
                if (pages1 > 1) {
                    query = query + "'" + surname + "', '" + name + "', '" + title + "', '" + publishYear.trim() + "', '" + pages + "');";
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(url, user, password);
                    stmt = connection.createStatement();
                    stmt.executeUpdate(query);

                    books.addBook(surname, name, title1, year, pages1);
                    status = "Книга успешно добавлена.";
                } else {
                    status = "Ошибка: неверное кол-во страниц.";
                }
            } else {
                status = "Ошибка: не удалось добавить книгу.";
            }
        } catch (ParseException e) {
            status = "Ошибка: неверный формат даты.";
        } catch (NumberFormatException e) {
            status = "Ошибка: неверный параметр кол-ва страниц.";
        } catch (SQLException e) {
            status = "Ошибка: неверный формат даты.";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Books getFromDB() {
        String query = "select id, surname, name, title, releaseDate, pages from books";
        Books books = new Books();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt(1);
                String authorSurname = rs.getString(2);
                String authorName = rs.getString(3);
                String title = rs.getString(4);
                Date publishYear = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(5));
                Integer pages = rs.getInt(6);

                books.addBook(authorSurname, authorName, title, publishYear, pages);
                System.out.println(id + authorSurname + authorName + title + publishYear + pages);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("нет подключения");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public String getStatus() {
        return this.status;
    }
}
