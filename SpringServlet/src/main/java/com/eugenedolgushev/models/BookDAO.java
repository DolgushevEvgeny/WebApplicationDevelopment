package com.eugenedolgushev.models;

import java.util.List;

public interface BookDAO {

    public void save(Book book);

    public Book get(int bookId);

    public List<Book> list();

    public String getStatus();
}
