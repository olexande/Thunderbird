<%-- 
    Document   : signature
    Created on : 15.09.2014, 23:14:51
    Author     : syadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signature Page</title>
    </head>
    <body>
        <h1>Hello SignatureGenerator!</h1>
        
        <form action="SignatureGenerator" method="GET">
            Введите login       : <input type="text" name="login" /><br/>
            Введите должность   : <input type="text" name="posada" />  <br/>
            Введите город       : <input type="text" name="city" /> <br/>
            Адрес пункта        : <input type="text" name="point" /> <br/>
            Введите телефон     : <input type="text" name="pfone" /><br/>
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
    </body>
</html>
