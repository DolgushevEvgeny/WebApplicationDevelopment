<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <div align="center">
            <h1><a href="/newBook">Добавить книгу</a></h1>
            <table border="1">
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Название книги</th>
                <th>Год издания (гггг-мм-дд)</th>
                <th>Страницы</th>
                <h2>${status}</h2>
                <c:forEach var="book" items="${listBook}" varStatus="status">
                    <tr>
                        <td>${book.authorSurname}</td>
                        <td>${book.authorName}</td>
                        <td>${book.title}</td>
                        <td>${book.publishYear}</td>
                        <td>${book.pages}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>