<%-- 
    Document   : user-dashboard
    Created on : Dec 14, 2021, 7:21:16 PM
    Author     : aksha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User DASHBOARD</title>
    </head>
    <body>
        
        <h2>Welcome to User Dashboard</h2>
        <h3>Hello ${user.getUsername()}</h3> 
        <br>
        
        <br>
        <a href="/EventManagementSystem/viewallevents.htm">Register for an Event</a>
        
        <br>
           <h3>Check Registered Events</h3>
           
                    
           
  <form  action="/EventManagementSystem/updateuserevent.htm" method="post">               
           
  <br>
  
<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                     <td>Select</td>
                <td><b>Event ID</b></td>
                <td><b>Event Name</b></td>
                <td><b>Event Details</b></td>
                       <td><b>Event Date</b></td>
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
                               <td>${a.getEventdate()}</td>
                        <td>${a.getVenue().getVenuename()} </td>
                        <td>${a.getSeats_available()} </td>
                        <td>${a.getStatus()} </td>
			 
			        
                             
                     </tr>
		  </c:forEach> 
                     
</table>
  
                         <input type="submit" name="submit" value="Submit">
  </form>

           
        
        <br>
         <a href="/EventManagementSystem/logout.htm">Log Out</a>
    </body>
</html>
