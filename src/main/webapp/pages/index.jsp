<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
    <title>Кинотеатры</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<div align="center">
    <sec:authorize access="!isAuthenticated()">
        <div style="width: 200px; padding: 10px;" class="simple-little-table">
            <h4><a href="/login">Войти</a></h4>
            <h4><a href="/registration">Зарегистрироваться</a></h4>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div style="position: absolute; padding: 10px;" class="simple-little-table">
            <h3>Привет, <sec:authentication property="name"/></h3>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <h4><a href="/users">Пользователи (только админ)</a></h4>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">

            </sec:authorize>
            <h4><a href="/logout">Выйти</a></h4>
        </div>
        <h2>Кинотеатры</h2>
        <table class="simple-little-table">
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Адресс</th>
                <th>Телефон</th>
                <th>
                    <form class="searchForm" method="get" action="search">
                        <input class="searchInput" type="search" name="keyword">
                        <i class="fa fa-search"></i>
                    </form>
                </th>
            </tr>
            <c:forEach items="${cinemaList}" var="cin">
                <tr>
                    <td>${cin.cinemaCode}</td>
                    <td>${cin.name}</td>
                    <td>${cin.address}</td>
                    <td>${cin.phoneNumber}</td>
                    <td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <form style="float: left; margin-left: 15px;" action="#edit" method="GET">
                                <input type="hidden" name="id" value="${cin.cinemaCode}"/>
                                <button type="submit">Изменить</button>
                            </form>
                            <form action="/delete" method="POST">
                                <input type="hidden" name="Id" value="${cin.cinemaCode}"/>
                                <input type="hidden" name="action" value="delete"/>
                                <button type="submit">Удалить</button>
                            </form>
                        </sec:authorize>
                    </td>
                </tr>
            </c:forEach>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form style="float: left; margin-left: 15px;" action="#edit" method="GET">
                            <button style="padding: 10px 15px; margin: 0 10px -10px 15px;" type="submit">
                                Добавить новый
                            </button>
                        </form>
                    </td>
                </tr>
            </sec:authorize>
        </table>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div id="edit">
                <div align="center" class="window">
                    <a href="#" class="close"><label style="font-size: 22px">X</label></a>
                    <h2 style="padding-top: 10px; margin-bottom: 5px;">Кинотеатр</h2>
                    <form:form action="#edit" method="POST" modelAttribute="cinema">
                        <table style="border-spacing: 10px 10px;">
                            <tr>
                                <td colspan=2><p style="color:#ff0000; font-size: 80%;">${errID}</p></td>
                            </tr>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <c:if test="${id != null}">
                                        ${cinema.cinemaCode}
                                        <form:hidden path="cinemaCode"/>
                                    </c:if>
                                    <c:if test="${id == null}">
                                        <form:input path="cinemaCode"/>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td colspan=2><p style="color:#ff0000; font-size: 80%;">${errName}</p></td>
                            </tr>
                            <tr>
                                <td>Название:</td>
                                <td><form:input path="name"/></td>
                            </tr>
                            <tr>
                                <td colspan=2><p style="color:#ff0000; font-size: 80%;">${errAddress}</p></td>
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
                                <td colspan="2" align="center"><input class="save" type="submit" value="Сохранить"></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
        </sec:authorize>
    </sec:authorize>
</div>
</body>
</html>