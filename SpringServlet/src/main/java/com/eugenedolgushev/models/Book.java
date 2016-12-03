package com.eugenedolgushev.models;

import com.sun.istack.internal.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private String publishYear = "";
    private Integer bookPages = 0;

    private static Logger log = Logger.getLogger(Book.class.getName());

    public Book(){
    }

    public Book(final String theAuthorSurname, final String theAuthorName, final String theTitle,
                final String thePublishYear, final Integer thePages) {
        this.authorSurname = theAuthorSurname;
        this.authorName = theAuthorName;
        this.title = theTitle;
        this.publishYear = thePublishYear;
        this.bookPages = thePages;
    }

    public final String getAuthorSurname(){
        return this.authorSurname;
    }

    public final void setAuthorSurname(final String theAuthorSurname){
        this.authorSurname = theAuthorSurname;
    }

    public final String getAuthorName(){
        return this.authorName;
    }

    public final void setAuthorName(final String theAuthorName){
        this.authorName = theAuthorName;
    }

    public final String getTitle(){
        return this.title;
    }

    public final void setTitle(final String theTitle){
        this.title = theTitle;
    }

    @NotNull
    public final Date getPublishYear(){
        try {
            return (new SimpleDateFormat("yyyy-MM-dd").parse(this.publishYear));
        } catch(ParseException e) {
            log.severe(e.getMessage());
        }

        return null;
    }

    public final void setPublishYear(final String thePublishYear){
        this.publishYear = thePublishYear;
    }

    @NotNull
    public final Integer getPages(){
        try {
            return Integer.parseInt(this.bookPages.toString());
        } catch(NumberFormatException e) {
            log.severe(e.getMessage());
            return 0;
        } catch (NullPointerException e) {
            log.severe(e.getMessage());
            return 0;
        }
    }

    public final void setPages(final Integer thePages){
        this.bookPages = thePages;
    }
}