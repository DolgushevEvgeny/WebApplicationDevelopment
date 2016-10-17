package com.eugenedolgushev.servlet;

import com.eugenedolgushev.servlet.controllers.Controller;
import com.eugenedolgushev.servlet.models.Books;
import com.eugenedolgushev.servlet.view.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Books books = null;
    private Controller controller = null;
    private View view = null;

    public MainServlet() throws IOException {
        System.out.println("servlet create");
        books = new Books();
        controller = new Controller();
        view = new View();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        books = controller.getFromDB();
        request.setAttribute("myBooks", books.getBooks());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String authorSurname = request.getParameter("surname");
        String authorName = request.getParameter("name");
        String title = request.getParameter("bookTitle");
        String publishYear = request.getParameter("publishYear");
        String pages = request.getParameter("pages");

        books = controller.execute(authorSurname, authorName, title, publishYear, pages, books);

        doGet(request, response);
    }
}
