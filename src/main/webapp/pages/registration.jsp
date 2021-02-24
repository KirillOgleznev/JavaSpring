<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>Регистрация</title>
</head>
<body>
<a href="/">Главная</a>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div align="center" style="width: 200px; padding: 10px; margin: auto;" class="simple-little-table">
    <form:form method="POST" modelAttribute="userForm">
        <h2>Регистрация</h2>
        <div>
            <form:input type="text" path="username" placeholder="Имя"
                        autofocus="true"/>
        </div>
        <div>
            <form:errors path="username"/>
                ${usernameError}
        </div>
        <div style="margin: 10px;">
            <form:input type="password" path="password" placeholder="Пароль"/>
        </div>
        <div>
            <form:errors path="password"/>
                ${passwordError}
        </div>
        <button type="submit">Зарегистрироваться</button>
        <h4><a href="/login">Войти</a></h4>
    </form:form>
</div>
</body>
</html>
