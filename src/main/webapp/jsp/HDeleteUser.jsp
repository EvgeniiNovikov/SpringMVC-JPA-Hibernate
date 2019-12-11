<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Delete User</title>
</head>
<style>
    fieldset{
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
    label{
        width: 150px;
        display: inline-block;
    }
    form{
        width: 500px;
        margin: 20px auto;
    }
</style>
<body>
<div align="center">
<form action="/delete" method="post">
    <fieldset>
        <legend><spring:message code="message.delete"/></legend>
        <spring:message code="message.deleteUser"/> ${param.id}?<br><br>
    <label>
    <input type="hidden" name="id" value="${param.id}">
<%--    <input type="hidden" name="_method" value="delete">--%>
    <input type="submit" value="<spring:message code="message.button.delete"/>"/>
    </label>
</form>
<form action="/login1">
    <input type="submit" value="<spring:message code="message.button.back"/>"/>
    <form action="HLogin.jsp"></form>
</form>
    </fieldset>
</div>
</body>
</html>
