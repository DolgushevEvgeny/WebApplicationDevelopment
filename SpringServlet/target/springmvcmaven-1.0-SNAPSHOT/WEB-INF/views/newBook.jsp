<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая книга</title>
    </head>
    <body>
        <div align="center">
            <spring:form action="/saveBook" method="POST" modelAttribute="book">
                <table>
                    <tr>
                        <td>Фамилия:</td>
                        <td><spring:input path="authorSurname" /></td>
                    </tr>
                    <tr>
                        <td>Имя:</td>
                        <td><spring:input path="authorName" /></td>
                    </tr>
                    <tr>
                        <td>Название книги:</td>
                        <td><spring:input path="title" /></td>
                    </tr>
                    <tr>
                        <td>Год издания (гггг-мм-дд):</td>
                        <td><spring:input path="publishYear" /></td>
                    </tr>
                    <tr>
                        <td>Страницы:</td>
                        <td><spring:input path="pages" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </spring:form>
        </div>
    </body>
</html>