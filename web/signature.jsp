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
<h1>Hello SignatureGenerator!</h1>

        <form action="SignatureGenerator" method="GET">
            <table border="0" cellspacing="0" cellpadding="0">
			
            <tr><td>Введите login: </td><td><input type="text" name="login" /></td></tr>
            <tr><td>Введите FullName: </td><td><input type="text" name="fullName" /></td></tr>
            <tr><td>Введите должность: </td><td><input type="text" name="posada" />  </td></tr>
            <tr><td>Введите город: </td><td><input type="text" name="city" /> </td></tr>
            <tr><td>Адрес пункта: </td><td><input type="text" name="point" /> </td></tr>
            <tr><td>Введите телефон: </td><td><input type="text" name="pfone" /></td></tr>
            </table>   
            <br/>
            <select name="Region">
                <option>
                </option>
                <option value="Kiev">Киев</option>
                <option value="Lvov">Львов</option>
                <option value="Odessa">Одесса</option>
            </select>
        <input type="submit" name="enter" value="Generate Signature" />
        </form>

<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>