<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
    <title>Изменить</title>
</head>
<body>
<div align="center">
    <h2>Изменить</h2>
    <form:form action="edit" method="POST" modelAttribute="cinema">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${cinema.cinemaCode}
                    <form:hidden path="cinemaCode"/>
                </td>
            </tr>
            <tr>
                <td>Название:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Адрес:</td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td colspan=2><p style="color:#ff0000; font-size: 80%;">${errNumber}</p></td>
            </tr>
            <tr>
                <td>Телефон:</td>
                <td><form:input path="phoneNumber"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>