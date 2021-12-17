<%-- 
    Document   : event-form
    Created on : Dec 13, 2021, 10:14:13 PM
    Author     : aksha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>event form</title>
    </head>
    <body >
        <h1>Event Registration Page</h1>
        
        <form:form modelAttribute ="event">
            
            Event Name: <form:input path="eventname" /> 
            <br><br>
            Details: <form:input path="details" />
            <br><br>
            Status <form:input path="status" />
            <br><br>
            Seats Available: <form:input path="seats_available" />
            <br><br>
            Date: <form:input path="eventdate"/>
            <br><br>
            
            <form:select path="venue" >
		<c:forEach var="venue" items="${venues}">
                    <form:option value="${venue.venueid}" />
		</c:forEach>
            </form:select>
            
            
            
            <br><br>
            
            
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
     
    </body>
</html>
