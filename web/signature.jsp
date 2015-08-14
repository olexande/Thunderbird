<%-- 
    Document   : signature
    Created on : 15.09.2014, 23:14:51
    Author     : syadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<h1>Це генератор підпису до поштової програми</h1>

        <form action="SignatureGenerator" method="GET">
            <table border="0" cellspacing="0" cellpadding="0">
			
            <tr><td>Введіть login: </td><td><input type="text" name="login" /></td></tr>
            <tr><td>Введіть прізвище та ім"я: </td><td><input type="text" name="fullName" /></td></tr>
            <tr><td>Введіть посаду: </td><td><input type="text" name="posada" />  </td></tr>
            <tr><td>Введіть місто: </td><td><input type="text" name="city" /> </td></tr>
            <tr><td>Адреса пункту: </td><td><input type="text" name="point" /> </td></tr>
            <tr><td>Введіть телефон: </td><td><input type="text" name="pfone" /></td></tr>
            </table>   
            <br/>
            Виберіть регіон: </br>
            <select name="Region">
                <option>
                </option>
                <option value="Kiev">Київ</option>
                <option value="Lvov">Львів</option>
                <option value="Odessa">Одеса</option>
                <option value="Odessa">Харків</option>
                <option value="Odessa">Вінниця</option>
                <option value="Odessa">Чернівці</option>
            </select>
            <br/><br/>
        <input type="submit" name="enter" value="Сгенерувати підпис" />
        </form>

<br/><br/>
Спочатку потрібно заповнити поля.
<br/>
Потім потрібно вибрати у низпадаючому меню Ваш поточний регіон
<br/>
По закінченню потрібно натиснути кнопку "Сгенерувати підпис" і Вас перенаправить на те, що вийшло.
<br/>
За наявності помилок, можна повернутись і повторити наново. Browser Cookies допоможуть повторно ввести вже введене.
<br/>

<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>