package First.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Book;
import Data.Books;

@WebServlet("/basicServlet")
public class basicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Books books = null;
	private String status = "";
	
    public basicServlet() {
        books = new Books();
        System.out.println("servlet create");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("books", books);
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Lab 1</title>");
		out.println("</head>");
		out.println("<body><form method=\"post\" action=\"basicServlet\">");
		out.println("Фамилия  <input name=\"surname\" type=\"text\"><br>");
		out.println("Имя  <input name=\"name\" type=\"text\"><br>");
		out.println("Название книги  <input name=\"bookTitle\" type=\"text\"><br>");
		out.println("Год издания (гггг-мм-дд)  <input name=\"publishYear\" type=\"text\"><br>");
		out.println("Страницы  <input name=\"pages\" type=\"text\"><br>");
		out.println("<input value=\"Отправить\" type=\"submit\">");
		out.println("</form>");
		out.println("<div id=\"status\">" + status + "</div>");
		
		books = (Books) servletContext.getAttribute("books");
		
		for (Book book : books.getBooks()) {
			out.println(book.getAuthorSurname() + "<br>" + book.getAuthorName() + "<br>"
						+ book.getBookTitle() + "<br>" + book.getPublishYear() + "<br>"
						+ book.getPages() + "<br>");
		}
		
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getServletContext();
		
		String authorSurname, authorName, title;
		Date publishYear;
		Integer pages;
		
		try {
			authorSurname = request.getParameter("surname").trim();
			authorName = request.getParameter("name").trim();
			title = request.getParameter("bookTitle").trim();
			publishYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("publishYear").trim());
			pages = Integer.parseInt(request.getParameter("pages").trim());
			
			if (!authorSurname.isEmpty() && !authorName.isEmpty() && !title.isEmpty()) {
				if (pages > 1) {
					books = (Books) servletContext.getAttribute("books");
					books.addBook(new Book(authorSurname, authorName, title, publishYear, pages));
					servletContext.setAttribute("books", books);
					status = "Книга успешно добавлена.";
				} else {
					status = "Ошибка: неверное кол-во страниц.";
				}
			} else {
				status = "Ошибка: не удалось добавить книгу.";
			}
		} catch (ParseException e) {
			status = "Ошибка: неверный формат даты.";
		} catch (NumberFormatException e) {
			status = "Ошибка: неверный параметр кол-ва страниц.";
		}
		
		for (Book book : books.getBooks()) {
			System.out.println(book.getAuthorSurname());
			System.out.println(book.getAuthorName());
			System.out.println(book.getBookTitle());
			System.out.println(book.getPublishYear());
			System.out.println(book.getPages());
		}
		 
		doGet(request, response);
	}
}  
