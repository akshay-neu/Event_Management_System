<%-- 
    Document   : user-form
    Created on : Dec 12, 2021, 1:12:33 AM
    Author     : aksha
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user form</title>
    </head>
    <body style="background-color: lightblue; text-align: center">
        <h1>User Registration Page</h1>
        <form:form modelAttribute ="user">
            User Name: <form:input path="username" /> 
            <br><br>
            Email ID: <form:input path="emailid" />
            <br><br><!-- comment -->
            Password: <form:input path="password" />
            <br><br><!-- comment -->
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
    </body>
</html>
