package com.eugenedolgushev.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;
    private String status = "";
    private static final Integer SURNAMEINDEX = 2;
    private static final Integer NAMEINDEX = 3;
    private static final Integer TITLEINDEX = 4;
    private static final Integer DATEINDEX = 5;
    private static final Integer PAGESINDEX = 6;

    private static final String ERROR_UNCORRECTDATA = "Некорректные данные!";
    private static final String SUCCESS_MESSAGE = "Книга успешно добавлена.";

    public BookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public BookDAOImpl() {}

    public void save(Book book) {
        if (validate(book)){
            String sql = "INSERT INTO books (surname, name, title, releaseDate, pages)"
                    + " VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, book.getAuthorSurname(), book.getAuthorName(),
                    book.getTitle(), book.getPublishYear(), book.getPages());
        }
    }

    private boolean validate(Book book) {
        if (book.getAuthorSurname().trim().equals("") || book.getAuthorName().trim().equals("")
                || book.getTitle().trim().equals("")) {
            status = ERROR_UNCORRECTDATA;
            return false;
        }
        if (book.getPublishYear() == null) {
            status = ERROR_UNCORRECTDATA;
            return false;
        }
        if (book.getPages() < 2) {
            status = ERROR_UNCORRECTDATA;
            return false;
        }

        status = SUCCESS_MESSAGE;
        return true;
    }

    public Book get(int bookId) {
        return null;
    }

    public String getStatus() {
        return this.status;
    }

    public List<Book> list() {
        String sql = "SELECT * FROM books";
        List<Book> listBook = jdbcTemplate.query(sql, new RowMapper<Book>() {

            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book aBook = new Book(rs.getString(SURNAMEINDEX), rs.getString(NAMEINDEX),
                                    rs.getString(TITLEINDEX), rs.getString(DATEINDEX),
                                    rs.getInt(PAGESINDEX));

                return aBook;
            }
        });

        return listBook;
    }
}
