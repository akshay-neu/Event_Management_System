<%-- 
    Document   : event-form
    Created on : Dec 17, 2021, 12:05:00 AM
    Author     : aksha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
		
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                /* $("#datepicker").datepicker(); */
                $("#datepicker").datepicker({ minDate: 0 });
            });
        </script>
</head>
<body>

<h3>Create Event</h3>

        
        <p><font color="red">${error}</font></p>
        <form action="/EventManagementSystem/addeeventdetails.htm" method="post">
         
           <br>     <br>  
          	
            Event Name: <input type="text" name="eventname" placeholder="Enter Event Name" >
            <br>     <br>       <br>  
             
              <br>
            Event Details:  <input type="text" name="details" placeholder="Details about the event">
            <br>         <br>     <br>  
            Event Capacity:  <input type="number" name="capacity" placeholder="Capacity">
             <br>     <br>       <br>  
           
           
           
           
           
           <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td>Select</td>
                <td><b>Venue ID</b></td>
                <td><b>Venue Name</b></td>
                <td><b>Address</b></td>
                <td><b>Capacity</b></td>
                <td><b>Owner Name</b></td>
              
            </tr>
     
  		<c:forEach items="${venuelist}" var="a" varStatus="count">  
                    <tr>
                        <td> <input type="radio" name="venueid" value="${a.getVenueid()}"></td>
            
                        <td>${a.getVenueid()}</td>           
                        <td>${a.getVenuename()} </td>   
                        <td>${a.getAddress()} </td>  
                        <td>${a.getCapacity()} </td>
                        <td>${a.getOwner().getOwnername()} </td>
                             
                     </tr>
		  </c:forEach> 
                                        
</table>    
           
                <br>       <br>  
                        <br>
            Date: <input type="text" name="eventdate" id="datepicker" >
           <br>     <br>       <br>       <br>       <br>       <br>       <br>       <br>  
           <br><br><br><br>
            
        <p><font color="red">${booked}</font></p>
            
       
            
            <br>
            <input type="submit" name="submit" class="form-control" value="Submit">
          
      
        </form>


</body>
</html>
