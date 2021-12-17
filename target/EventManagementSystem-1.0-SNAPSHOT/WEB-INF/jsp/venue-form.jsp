<%-- 
    Document   : venue-form
    Created on : Dec 13, 2021, 10:20:10 PM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>venue form</title>
    </head>
    <body >
        <h1>Venue Registration Page</h1>
        
        <form:form modelAttribute ="venue">
            
            Venue Name: <form:input path="venuename" /> 
            <br><br>
            Address: <form:input path="address" />
            <br><br>
            Capacity: <form:input path="capacity" />
            <br><br>
       
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
            
            <a href="/owner/dashboard.htm">Go Back</a>
     
    </body>
</html>
