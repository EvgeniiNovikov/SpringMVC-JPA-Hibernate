<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
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

    label {
        width: 150px;
        display: inline-block;
    }

    form {
        width: 500px;
        margin-top: 20px;
    }
</style>
<body>
<div align="center">
    <form>
        <fieldset>
            <label>
                <h2><spring:message code="messages.start.hello"/></h2><br>
                <%! Date date = new Date(); %>
                <spring:message code="messages.today"/><br>
                <%= date.toLocaleString() %>
                <br><br>
            </label>
        </fieldset>
    </form>
    <form action="/login1">
        <input type="submit" value="<spring:message code="messages.start"/>"/>
    </form>
</div>
</body>
</html>