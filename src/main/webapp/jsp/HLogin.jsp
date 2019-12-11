<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login</title>
</head>
<span style="float: right">
    <a href="?lang=en">EN</a>
    |
    <a href="?lang=ru">RU</a>
</span>
<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }

    form {
        width: 500px;
        margin: 20px auto;
    }
</style>
<body>
<div align="center">
    <form action="/login" method="get">
        <fieldset>
            <legend><spring:message code="message.enter"/> </legend>
            <form>
                <spring:message code="message.form.login"/> <br>
                <input required type="text" title="<spring:message code="message.enter.login"/>" size="30" name="login" placeholder="${message}"><br>
                <spring:message code="message.form.password"/><br>
                <input required type="text" title="<spring:message code="message.enter.password"/>" size="30" name="password" placeholder="${message}"><br><br>
                <form action="/userInfo">
                    <input type="submit" value="<spring:message code="messages.start"/>">
                </form>
                <form action="/addUser1">
                    <input type="submit" value="<spring:message code="messages.registration"/>">
                </form>
            </form>
        </fieldset>
    </form>
</div>
</body>
</html>
