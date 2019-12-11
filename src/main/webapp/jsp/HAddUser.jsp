<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Add User</title>
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
    <form action="/addUser" method="post">
        <fieldset>
            <legend><spring:message code="messages.registration"/></legend>
            <p>
                <label for="login"><spring:message code="message.form.login"/></label><br>
                <input id="login" title="<spring:message code="message.enter.login"/>" required type="text" name="login" placeholder="${message}">
            </p>
            <p>
                <label for="pass"><spring:message code="message.form.password"/></label><br>
                <input id="pass" title="<spring:message code="message.enter.password"/>" required type="password" name="password" placeholder="<spring:message code="message.enter.password"/>">
            </p>
            <p>
                <label for="fName"><spring:message code="message.form.name"/></label><br>
                <input id="fName" title="<spring:message code="message.enter.name"/>" required type="text" name="first_name" pattern="^[a-zA-Z\s]+$"
                       placeholder="<spring:message code="message.enter.name"/>">
            </p>
            <p>
                <label for="lName"><spring:message code="message.form.lastName"/></label><br>
                <input id="lName" title="<spring:message code="message.enter.lastName"/>" required type="text" name="last_name"
                       pattern="^[a-zA-Z\s]+$" placeholder="<spring:message code="message.enter.lastName"/>">
            </p>
            <p>
                <label for="country"><spring:message code="message.form.country"/></label><br>
                <input id="country" title="<spring:message code="message.enter.country"/>" required type="text" name="country" pattern="^[a-zA-Z\s]+$"
                       placeholder="<spring:message code="message.enter.country"/>">
            </p>
            <p>
                <label for="address"><spring:message code="message.form.address"/></label><br>
                <input id="address" title="<spring:message code="message.enter.address"/>" required type="text" size="50" name="userAddress"
                       placeholder="<spring:message code="message.enter.address"/>">
            </p>
            <input hidden type="radio" name="role" value="user" checked placeholder="Title">
            <input type="submit" value="<spring:message code="message.button.save"/>"> <input type="reset" value="<spring:message code="message.button.reset"/>"> <br><br>
        </fieldset>
    </form>
    <form action="/login1">
        <input type="submit" value="<spring:message code="message.button.back"/>"/>
        <form action="HLogin.jsp"></form>
    </form>
</div>
</body>
</html>