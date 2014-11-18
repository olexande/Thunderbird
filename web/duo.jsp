<%-- 
    Document   : duo
    Created on : 11.03.2014, 20:23:11
    Author     : Администратор
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DUO</h1>
        
        <a href="ConfigGenerator"> link click this</a>
        
        <form action="ConfigGenerator" method="GET">
            Input login: <input type="text" name="login" />            
            <input type="submit" name="enter" value="Generate config" />
        </form>
    </body>
</html>
