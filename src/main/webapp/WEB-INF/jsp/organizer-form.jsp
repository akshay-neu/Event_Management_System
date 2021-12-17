<%-- 
    Document   : organizer-form
    Created on : Dec 14, 2021, 9:59:23 PM
    Author     : aksha
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Organizer Form Page</title>
    </head>
    <body style="background-color: lightblue; text-align: center">
        <h1>Organizer Registration Page</h1>
        <form:form modelAttribute ="organizer">
            Organizer Name: <form:input path="organizername" /> 
            <br><br>
            Email ID: <form:input path="emailid" />
            <br><br><!-- comment -->
            Password: <form:input path="password" />
            <br><br><!-- comment -->
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
    </body>
</html><body>
      
