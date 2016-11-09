package com.eugenedolgushev.servlet;

import com.eugenedolgushev.servlet.models.Book;
import com.eugenedolgushev.servlet.models.Books;
import com.eugenedolgushev.servlet.template.Templator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Books books = null;

    private static final String SERVLETSTATE = "state";

    public MainServlet() throws IOException {
        books = new Books();
    }

    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String templatePath = getServletContext().getRealPath("/WEB-INF/template.html");
        
        response.setContentType("text/html;charset=utf-8");
        List<Book> receivedBooks = this.books.getBooks();

        Templator templator = new Templator(templatePath);
        templator.setBooksByTag("myBooks", receivedBooks);
        if (request.getAttribute(SERVLETSTATE) != null) {
            templator.setValueByTag(SERVLETSTATE, (String)request.getAttribute(SERVLETSTATE));
        } else {
            templator.setValueByTag(SERVLETSTATE, "");
        }

        PrintWriter writer = response.getWriter();
        writer.println(templator.getHTML());
        writer.close();
    }

    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String authorSurname = request.getParameter("surname");
        String authorName = request.getParameter("name");
        String title = request.getParameter("bookTitle");
        String publishYear = request.getParameter("publishYear");
        String pages = request.getParameter("pages");

        String state = books.addBook(authorSurname, authorName, title, publishYear, pages);

        request.setAttribute(SERVLETSTATE, state);
        doGet(request, response);
    }
}
