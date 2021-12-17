<%-- 
    Document   : event-list
    Created on : Dec 16, 2021, 3:52:31 PM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body
        <h3>Register for Events</h3>

<br><br>
  <form  action="/EventManagementSystem/registerevent.htm" method="post">  
                        
                 
           
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


            
 

</body>
</html>