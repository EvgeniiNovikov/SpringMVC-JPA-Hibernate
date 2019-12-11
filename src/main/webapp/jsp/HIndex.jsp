<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<span style="float: right">
    <a href="?lang=en">EN </a>
    |
    <a href="?lang=ru">RU </a>
</span>
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
    <form>
        <fieldset>
    <label>
    <h2>Welcome!</h2><br>
    <%! Date date = new Date(); %>
    Сегодня:
        <spring:message code="messages.today"/>
    <%= date.toString() %>
    <br><br>
    </label>
        </fieldset>
    </form>
    <form action="jsp/HLogin.jsp">
        <input type="submit" value="Войти"/>
    </form>
</div>
</div>
</body>
</html>