package com.eugenedolgushev.models;

import com.sun.istack.internal.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private String publishYear = "";
    //private String bookPages = "";
    private Integer bookPages = 0;

    private static final String TABLEROWOPEN = "<tr>";
    private static final String TABLEROWCLOSE = "</tr>";
    private static final String TABLEDATAOPEN = "<td>";
    private static final String TABLEDATACLOSE = "</td>";

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
        }

        return null;
    }

    public final void setPublishYear(final String thePublishYear){
        this.publishYear = thePublishYear;
    }

    @NotNull
    public final Integer getPages(){
//        try {
//            return Integer.parseInt(this.bookPages);
//        } catch(NumberFormatException e) {
//        }
        return this.bookPages;
    }

    public final void setPages(final Integer thePages){
        this.bookPages = thePages;
    }

    @NotNull
    public final String toHTML() {
        StringBuilder result = new StringBuilder();
        result.append(TABLEROWOPEN);
        result.append(TABLEDATAOPEN);
        result.append(this.authorSurname);
        result.append(TABLEDATACLOSE);
        result.append(TABLEDATAOPEN);
        result.append(this.authorName);
        result.append(TABLEDATACLOSE);
        result.append(TABLEDATAOPEN);
        result.append(this.title);
        result.append(TABLEDATACLOSE);
        result.append(TABLEDATAOPEN);
        result.append(getPublishYear());
        result.append(TABLEDATACLOSE);
        result.append(TABLEDATAOPEN);
        result.append(this.bookPages);
        result.append(TABLEDATACLOSE);
        result.append(TABLEROWCLOSE);
        return result.toString();
    }
}