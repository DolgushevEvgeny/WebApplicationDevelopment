package com.eugenedolgushev.servlet.models;

import java.util.ArrayList;
import java.util.Date;

public class Books {
    private ArrayList<Book> books = null;

    public Books(){
        if (this.books == null){
            this.books = new ArrayList<Book>();
        }
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addBook(String authorSurname, String authorName, String title, Date publishYear, Integer pages){
        Book newBook = new Book(authorSurname, authorName, title, publishYear, pages);
        this.books.add(newBook);
    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public Integer getLength() {
        return this.books.size();
    }
}