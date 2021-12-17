<%-- 
    Document   : owner-dashboard
    Created on : Dec 14, 2021, 9:14:46 PM
    Author     : aksha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
    </head>
  
    <body>
        <h1>Welcome to Owner Dashboard</h1>
        <h2> Welcome ${owner.getOwnername()}</h2>
        <a href="/EventManagementSystem/venue/save.htm"> Add a new Venue</a>
        
        <br><!-- comment -->
        
     
		
        <a href="/EventManagementSystem/logout.htm">Log Out</a>
        
        
        <br><br>
        <h4>Venues added by you-</h4>
           <form action="/EventManagementSystem/updatevenueq.htm" >
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
               <br><br>
                 <input type="submit" name="delete" class="form-control" value="delete">   
                 <br><br>
               
                 <input type="submit" name="update" class="form-control" value="update">
        </form>
<!--               
        <h3> UPDATE THE VENUE DETAILS - </h3>
        <form action="/EventManagementSystem/updatevenue.htm" >
           <br>
           Venue ID To Update: <input type="text" name="venueidupdate" placeholder="Enter Venue ID to Update" >
            <br>
            <br>
            <input type="submit" name="update" class="form-control" value="Update">
        </form>
        <br>
        <form action="/EventManagementSystem/updatevenue.htm" >
           <br>
           Venue ID To Delete: <input type="text" name="venueiddelete" placeholder="Enter Venue ID to Delete" >
            <br>
            <br>
            <input type="submit" name="delete" class="form-control" value="Delete">
        </form>-->
        
           
        <p>
            ${errorselection}
        </p>
        
			
    </body>
</html>
