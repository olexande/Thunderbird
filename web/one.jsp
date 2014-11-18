<%--<%@page import="java.lang.System.setProperty(String, String)"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="err.jsp"%>

<%--<%@include file="duo.jsp" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <a href="MyServlet"> 1 link click this</a>
        
        <form action="DownloadServlet" method="GET">
            Input login: <input type="text" name="login" />            
            <input type="submit" name="enter" value="Generate config" />
        </form>
        
        <select name="TypeServ">
            <option></option>
            <option value="t1">Чебурашка</option>
            <option value="t2">Гена</option>
            <option selected value="t3">Шапокляк</option>
        </select>
        
    </body>
</html>
