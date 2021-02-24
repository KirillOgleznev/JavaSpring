<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Log in with your account</title>
</head>
<body>
<a href="/">Главная</a>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div align="center" style="width: 200px; padding: 10px; margin: auto;" class="simple-little-table">
    <form method="POST" action="/login">
        <h2>Вход в систему</h2>
        <div>
            <input name="username" type="text" placeholder="Имя"
                   autofocus="true"/>
        </div>
        <div style="margin: 10px;">
            <input name="password" type="password" placeholder="Пароль"/>
        </div>
        <button type="submit">Войти</button>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </form>
</div>


</body>
</html>
