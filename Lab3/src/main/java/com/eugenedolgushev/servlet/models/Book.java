package com.eugenedolgushev.servlet.models;

import java.util.Date;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private Date publishYear = null;
    private Integer pages = 0;

    public Book(final String theAuthorSurname, final String theAuthorName, final String theTitle,
                final Date thePublishYear, final Integer thePages) {
        this.authorSurname = theAuthorSurname;
        this.authorName = theAuthorName;
        this.title = theTitle;
        this.publishYear = thePublishYear;
        this.pages = thePages;
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