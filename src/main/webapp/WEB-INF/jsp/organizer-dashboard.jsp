<%-- 
    Document   : organizer-dashboard
    Created on : Dec 14, 2021, 10:38:15 PM
    Author     : aksha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ORGANIZER DASHBOARD</title>
    </head>
    <body>
        <h1>Welcome to Event Organizer Dashboard</h1><br>
        <h2>Hello ${organizer.getOrganizername()}</h2><br>
        
        <a href="/EventManagementSystem/event/save.htm">ADD NEW EVENT</a>
        <br><!-- comment --><br>
        
        <a href="/EventManagementSystem/logout.htm">Log Out</a>
        
        
         <h4>Events added by you-</h4>
           <form action="/EventManagementSystem/updatevent.htm" >
<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td>Select</td>
                <td><b>Event ID</b></td>
                <td><b>Event Name</b></td>
                <td><b>Event Details</b></td>
                <td><b>Event Venue</b></td>
                <td><b>Seats Available</b></td>
                <td><b>Event Status</b></td>
            </tr>
     
  		<c:forEach items="${events}" var="a" varStatus="count">  
                    <tr>
                        <td> <input type="radio" name="eventid" value="${a.getEventid()}"></td>
            
                        <td>${a.getEventid()}</td>           
                        <td>${a.getEventname()} </td>   
                        <td>${a.getDetails()} </td>  
                        <td>${a.getVenue().getVenuename()} </td>
                        <td>${a.getSeats_available()} </td>
                        <td>${a.getStatus()} </td>
			 
                             
                     </tr>
		  </c:forEach> 
                                        
</table>    
               <br><br>
                 <input type="submit" name="delete" class="form-control" value="delete">   
                 <br><br>
               
                 <input type="submit" name="update" class="form-control" value="update">
        </form>
        
        
        
        
        
    </body>
</html>
