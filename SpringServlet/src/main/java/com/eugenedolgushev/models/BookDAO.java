package com.eugenedolgushev.models;

import java.util.List;

public interface BookDAO {

    void save(Book book);

    Book get(int bookId);

    List<Book> list();

    String getStatus();
}
