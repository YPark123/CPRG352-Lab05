<%-- 
    Document   : home
    Created on : Jun 16, 2021, 3:22:27 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <form> 
            <h3> Hello ${user.username}</h3>
            <a href ="login?action=logout">Log out</a>
        </form>
           
            

    </body>
</html>
