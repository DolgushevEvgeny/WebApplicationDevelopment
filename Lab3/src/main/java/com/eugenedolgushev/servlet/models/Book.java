package com.eugenedolgushev.servlet.models;

import java.util.Date;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private Date publishYear = null;
    private Integer pages = 0;

    public Book(final String authorSurname, final String authorName, final String title,
                final Date publishYear, final Integer pages) {
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.title = title;
        this.publishYear = publishYear;
        this.pages = pages;
    }

    public final String getAuthorSurname(){
        return this.authorSurname;
    }

    public final String getAuthorName(){
        return this.authorName;
    }

    public final String getTitle(){
        return this.title;
    }

    public final Date getPublishYear(){
        return this.publishYear;
    }

    public final Integer getPages(){
        return this.pages;
    }
}