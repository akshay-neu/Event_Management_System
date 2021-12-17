<%-- 
    Document   : update-venue
    Created on : Dec 17, 2021, 1:48:17 AM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>UPDATE VENUE---</h1>
        
         <form:form modelAttribute ="venue">
            Venue ID <form:input path="venueid" placeholder="${venue.getVenueid()}"/> 
            <br><br>
            Venue Name: <form:input path="venuename" placeholder="${venue.getVenuename()}"/> 
            <br><br>
            Address: <form:input path="address"  placeholder="${venue.getAddress()}" />
            <br><br>
            Capacity: <form:input path="capacity" placeholder="${venue.getCapacity()}" />
            <br><br>
       
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
    </body>
</html>
