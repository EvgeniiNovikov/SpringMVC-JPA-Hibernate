<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>All Users</title>
</head>
<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>
<body>
<div align="center">
    <fieldset>
        <legend><spring:message code="message.adminInfo"/></legend>
    <table border="1">
        <thead>
        <tr>
            <th><spring:message code="message.id"/></th>
            <th><spring:message code="message.login"/></th>
            <th><spring:message code="message.password"/></th>
            <th><spring:message code="message.name"/></th>
            <th><spring:message code="message.lastName"/></th>
            <th><spring:message code="message.country"/></th>
            <th><spring:message code="message.address"/></th>
            <th><spring:message code="message.role"/></th>
            <th><spring:message code="message.actions"/></th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.fName}</td>
                <td>${user.lName}</td>
                <td>${user.address.getCountry()}</td>
                <td>${user.address.getUserAddress()}</td>
                <td>${user.role.getTitle()}</td>
                <td>
                    <form action="/adminUpdate" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="login" value="${user.login}">
                        <input type="hidden" name="password" value="${user.password}">
                        <input type="hidden" name="firstName" value="${user.fName}">
                        <input type="hidden" name="lastName" value="${user.lName}">
                        <input type="hidden" name="address_id" value="${user.address.getId()}">
                        <input type="hidden" name="country" value="${user.address.country}">
                        <input type="hidden" name="address" value="${user.address.userAddress}">
                        <input type="hidden" name="role_id" value="${user.role.getId()}">
                        <input type="hidden" name="role" value="${user.role}">
                        <input type="submit" value="<spring:message code="message.button.update"/>">
                    </form>
                    <form action="/delete1" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="submit" value="<spring:message code="message.button.delete"/>">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tr>
    </table>
<br><br>
    <form action="/addUser1">
        <input type="submit" value="<spring:message code="message.button.add"/>">
    </form>
    <form action="/login1">
        <input type="submit" value="<spring:message code="message.button.back"/>"/>
        <form action="jsp/HLogin.jsp"></form>
    </form>
    </fieldset>
</div>
</body>
</html>