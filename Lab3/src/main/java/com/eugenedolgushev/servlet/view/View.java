package com.eugenedolgushev.servlet.view;

import java.text.SimpleDateFormat;

import com.eugenedolgushev.servlet.controllers.Controller;
import com.eugenedolgushev.servlet.models.Book;
import com.eugenedolgushev.servlet.models.Books;

public class View {

    public View() {

    }

    public StringBuilder display(Controller controller, Books books) {
        StringBuilder out = new StringBuilder();

        out.append("<html><head>");
        out.append("<meta charset=\"UTF-8\">");
        out.append("<title>Lab 1</title>");
        out.append("</head>");
        out.append("<body><form method=\"post\" action=\"MainServlet\">");
        out.append("Фамилия  <input name=\"surname\" type=\"text\"><br>");
        out.append("Имя  <input name=\"name\" type=\"text\"><br>");
        out.append("Название книги  <input name=\"bookTitle\" type=\"text\"><br>");
        out.append("Год издания (гггг-мм-дд)  <input name=\"publishYear\" type=\"text\"><br>");
        out.append("Страницы  <input name=\"pages\" type=\"text\"><br>");
        out.append("<input value=\"Отправить\" type=\"submit\">");
        out.append("</form>");
        out.append("<div id=\"status\">");
        out.append(controller.getStatus());
        out.append("</div>");

        if (books != null) {
            for (Book book : books.getBooks()) {
                out.append(book.getAuthorSurname() + "<br>" + book.getAuthorName() + "<br>"
                        + book.getTitle() + "<br>" + new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishYear()) + "<br>"
                        + book.getPages() + "<br>");
            }
        }

        out.append("</body></html>");
        return out;
    }
}