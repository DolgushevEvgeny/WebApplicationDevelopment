<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.pageTitle"/></title>
    </head>
    <body>
        <span style="float: right">
            <a href="?lang=en">en</a>
            |
            <a href="?lang=ru">ru</a>
        </span>
        <div align="center">
            <h1><a href="/newBook"><spring:message code="label.newBook"/></a></h1>
            <h2><a href="/example"><spring:message code="label.downloadRemoteContent"/></a></h2>
            <table border="1">
                <th><spring:message code="label.surname"/></th>
                <th><spring:message code="label.name"/></th>
                <th><spring:message code="label.bookTitle"/></th>
                <th><spring:message code="label.publishYear"/></th>
                <th><spring:message code="label.pages"/></th>
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