<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><spring:message code="label.remoteTitle"/></title>
    </head>
    <body>
        <h1><a href="/"><spring:message code="label.returnToMain"/></a></h1>
        <div>${remoteContent}</div>
    </body>
</html>
