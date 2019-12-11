<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Update User</title>
</head>
<style>
    label {
        width: 150px;
        display: inline-block;
        cursor: pointer;
    }

    form {
        width: 500px;
        margin: 20px auto;
    }

    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>
<body>
<div align="center">
    <form action="/update" method="post">
        <fieldset>
            <legend><spring:message code="message.update"/></legend>
            <input type="hidden" name="id" value="${param.id}">
            <p>
                <label for="login"><spring:message code="message.form.login"/></label><br><br>
                ${param.login}
                <input hidden id="login" type="text" name="login" value="${param.login}" placeholder=${param.login}><br>
            </p>
            <p>
                <label for="pass"><spring:message code="message.form.password"/></label><br>
                <input id="pass" type="text" name="password" value="${param.password}"
                       placeholder=${param.password}><br><br>
            </p>
            <p>
                <label for="name"><spring:message code="message.form.name"/></label><br>
                <input id="name" type="text" name="firstName" value="${param.firstName}" pattern="^[a-zA-Z\s]+$"
                       placeholder=${param.firstName}><br><br>
            </p>
            <p>
                <label for="lName"><spring:message code="message.form.lastName"/></label><br>
                <input id="lName" type="text" name="lastName" value="${param.lastName}" pattern="^[a-zA-Z\s]+$"
                       placeholder=${param.lastName}><br><br>
            </p>
            <p>
                <label for="country"><spring:message code="message.form.country"/></label><br>
                <input id="country" type="text" name="country" value="${param.country}" pattern="^[a-zA-Z\s]+$"
                       placeholder=${param.country}><br><br>
            </p>
            <p>
                <label for="address"><spring:message code="message.form.address"/></label><br>
                <input id="address" type="text" name="address" size="50" value="${param.address}"
                       placeholder=${param.address}><br><br>
            </p>
            <p>
                Role:
                <input required type="radio" name="role" value="user" checked placeholder="${param.role}"> User
                <input required type="radio" name="role" value="admin" placeholder="${param.role}"> Admin<br><br>
            </p>
            <input type="hidden" name="_method" value="put">
            <input type="submit" value="<spring:message code="message.button.update"/>"/>
        </fieldset>
    </form>
    <form action="/login1">
        <input type="submit" value="<spring:message code="message.button.back"/>"/>
        <form action="HLogin.jsp"></form>
    </form>
</div>
</body>
</html>
