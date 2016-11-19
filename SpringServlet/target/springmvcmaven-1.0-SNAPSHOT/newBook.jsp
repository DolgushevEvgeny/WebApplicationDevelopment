<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Book</title>
    </head>
    <body>
        <div align="center">
            <h1>New Book</h1>
            <form:form action="saveBook" method="post" modelAttribute="book">
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td>Фамилия:</td>
                        <td><form:input path="authorSurname" /></td>
                    </tr>
                    <tr>
                        <td>Имя:</td>
                        <td><form:input path="authorName" /></td>
                    </tr>
                    <tr>
                        <td>Название книги:</td>
                        <td><form:input path="title" /></td>
                    </tr>
                    <tr>
                        <td>Год издания (гггг-мм-дд):</td>
                        <td><form:input path="publishYear" /></td>
                    </tr>
                    <tr>
                        <td>Страницы:</td>
                        <td><form:input path="pages" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>