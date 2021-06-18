<%-- 
    Document   : login
    Created on : Jun 16, 2021, 3:22:38 PM
    Author     : USER

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" value="${username}" name="user_name">
            <br>
            <label>Password:</label>
            <input type="password" value="${password}" name="password">
            <br>
            <input type="submit" value="Log in">
            
            
        </form>
        
        <%-- Display the message only if validation has been tripped. --%>
        <c:if test="${invalid}">
            <p>Invalid login</p>
        </c:if>
            
        <c:if test="${logoutmessage}">
            <p>You have successfully logged out.</p>
        </c:if>
    
        
    </body>
</html>
