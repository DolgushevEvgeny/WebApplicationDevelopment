<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.newBook"/></title>
    </head>
    <body>
        <div align="center">
            <form:form action="/saveBook" method="POST" modelAttribute="book">
                <table>
                    <tr>
                        <td><spring:message code="label.surname"/>:</td>
                        <td><form:input path="authorSurname" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="label.name"/>:</td>
                        <td><form:input path="authorName" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="label.bookTitle"/>:</td>
                        <td><form:input path="title" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="label.publishYear"/>:</td>
                        <td><form:input path="publishYear" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="label.pages"/>:</td>
                        <td><form:input path="pages" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value=<spring:message code="label.save"/> />
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>