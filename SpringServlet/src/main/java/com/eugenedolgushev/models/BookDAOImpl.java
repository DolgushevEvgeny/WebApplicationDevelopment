package com.eugenedolgushev.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
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

    private static final String ERROR_UNCORRECTDATA = "Ошибка: Некорректные данные!";
    private static final String ERROR_UNCORRECTDATEDATA = "Ошибка: Некорректные данные при вводе даты!";
    private static final String ERROR_UNCORRECTINTEGERDATA = "Ошибка: Некорректные данные при вводе числа!";
    private static final String SUCCESS_MESSAGE = "Книга успешно добавлена.";

    private static Logger log = Logger.getLogger(BookDAOImpl.class.getName());

    public BookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public final void save(Book book) {
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
            log.severe(ERROR_UNCORRECTDATA);
            return false;
        }
        if (book.getPublishYear() == null) {
            status = ERROR_UNCORRECTDATEDATA;
            log.severe(ERROR_UNCORRECTDATEDATA);
            return false;
        }
        if (book.getPages() < 2) {
            status = ERROR_UNCORRECTINTEGERDATA;
            log.severe(ERROR_UNCORRECTINTEGERDATA);
            return false;
        }

        status = SUCCESS_MESSAGE;
        log.severe(SUCCESS_MESSAGE);
        return true;
    }

    public final Book get(int bookId) {
        return null;
    }

    public final String getStatus() {
        return this.status;
    }

    public final List<Book> list() {
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
