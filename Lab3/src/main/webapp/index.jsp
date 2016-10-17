<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
    <head>
        <title>Lab3</title>
    </head>
    <body>
    <form method="post" action="Main">
        <label>Фамилия</label><input name="surname" type="text"><br>
        <label>Имя</label><input name="name" type="text"><br>
        <label>Название книги</label><input name="bookTitle" type="text"><br>
        <label>Год издания (гггг-мм-дд)</label><input name="publishYear" type="text"><br>
        <label>Страницы</label><input name="pages" type="text"><br>
        <input value="Отправить" type="submit">
    </form>
    <div id="status">
    </div>
    <table>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Название книги</th>
            <th>Год издания</th>
            <th>Страницы</th>
        </tr>
        <h1>${state}</h1>
        <c:forEach items="${myBooks}" var="book">
            <tr>
                <td><c:out value="${book.authorSurname}"/></td>
                <td><c:out value="${book.authorName}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.publishYear}"/></td>
                <td><c:out value="${book.pages}"/></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>