<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Результат поиска</title>
</head>
<body>
<a href="/">Главная</a>
<div align="center">
    <h2>Результат поиска</h2>
    <table class="simple-little-table">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Адресс</th>
            <th>Телефон</th>
        </tr>
        <c:forEach items="${result}" var="cinema">
            <tr>
                <td>${cinema.cinemaCode}</td>
                <td>${cinema.name}</td>
                <td>${cinema.address}</td>
                <td>${cinema.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>