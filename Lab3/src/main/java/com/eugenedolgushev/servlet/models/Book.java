package com.eugenedolgushev.servlet.models;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class Book {
    private String authorSurname = "";
    private String authorName = "";
    private String title = "";
    private Date publishYear = null;
    private Integer pages = 0;

    private static final String TABLEROWOPEN = "<tr>";
    private static final String TABLEROWCLOSE = "</tr>";
    private static final String TABLEDATAOPEN = "<td>";
    private static final String TABLEDATACLOSE = "</td>";

    public Book(final String theAuthorSurname, final String theAuthorName, final String theTitle,
                final Date thePublishYear, final Integer thePages) {
        this.authorSurname = theAuthorSurname;
        this.authorName = theAuthorName;
        this.title = theTitle;
        this.publishYear = new Date(thePublishYear.getTime());
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
        return (Date)this.publishYear.clone();
    }

    public final Integer getPages(){
        return this.pages;
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
        result.append(this.pages);
        result.append(TABLEDATACLOSE);
        result.append(TABLEROWCLOSE);
        return result.toString();
    }
}