<%-- 
    Document   : page
    Created on : 09.06.2014, 15:27:45
    Author     : a.belovol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String login = request.getParameter("login");
        %>
        
        <p> <font color = "green">Login: <%= login %> </font> </p>
    </body>
</html>
