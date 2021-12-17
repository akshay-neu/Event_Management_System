<%-- 
    Document   : homepage
    Created on : Nov 30, 2021, 9:06:39 PM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form:form modelAttribute ="event">
            
            Event Name: <form:input path="eventname" /> 
            <br><br>
            Details: <form:input path="details" />
            <br><br>
            Status <form:input path="status" />
            <br><br>
            Seats Available: <form:input path="seats_available" />
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
        

     
    </body>
</html>
