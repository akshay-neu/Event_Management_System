<%-- 
    Document   : event-update
    Created on : Dec 17, 2021, 4:11:43 AM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h1>Hello World!</h1>
        
        
          
        <p><font color="red">${error}</font></p>
        <form action="/EventManagementSystem/addeeventdetails.htm" method="post">
         
           <br>
          	
            Event Name: <input type="text" name="eventname" placeholder="${event.getEventname()}" >
            <br>
             
            Venue Location: <input type="text" name="venueid" placeholder="${event.getEventnam()}">
              <br>
            Event Details:  <input type="text" name="details" placeholder="Details about the event">
            <br>  
            Event Capacity:  <input type="number" name="capacity" placeholder="Capacity">
             <br>
            Date: <input type="text" name="eventdate" id="datepicker" >
           <br>
            
            
        <p><font color="red">${booked}</font></p>
            
       
            
            <br>
            <input type="submit" name="submit" class="form-control" value="Submit">
          </div>
      
        </form>
    </body>
</html>
