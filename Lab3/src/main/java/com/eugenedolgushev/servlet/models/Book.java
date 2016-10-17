package com.eugenedolgushev.servlet.models;

import java.util.Date;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private Date publishYear = null;
    private Integer pages = 0;

    public Book(String authorSurname, String authorName, String title, Date publishYear, Integer pages) {
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.title = title;
        this.publishYear = publishYear;
        this.pages = pages;
    }

    public String getAuthorSurname(){
        return this.authorSurname;
    }

    public String getAuthorName(){
        return this.authorName;
    }

    public String getTitle(){
        return this.title;
    }

    public Date getPublishYear(){
        return this.publishYear;
    }

    public Integer getPages(){
        return this.pages;
    }
}