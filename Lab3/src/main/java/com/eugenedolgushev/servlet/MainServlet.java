package com.eugenedolgushev.servlet;

import com.eugenedolgushev.servlet.models.Book;
import com.eugenedolgushev.servlet.models.Books;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Books books = null;

    public MainServlet() throws IOException {
        System.out.println("servlet create");
        books = new Books();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        ArrayList<Book> receivedBooks = this.books.getBooks();
        request.setAttribute("myBooks", receivedBooks);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String authorSurname = request.getParameter("surname");
        String authorName = request.getParameter("name");
        String title = request.getParameter("bookTitle");
        String publishYear = request.getParameter("publishYear");
        String pages = request.getParameter("pages");

        String state = books.addBook(authorSurname, authorName, title, publishYear, pages);
        request.setAttribute("state", state);
        doGet(request, response);
    }
}
