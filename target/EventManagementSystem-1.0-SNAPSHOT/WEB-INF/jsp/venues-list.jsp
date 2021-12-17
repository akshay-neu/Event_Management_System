<%-- 
    Document   : venues-list
    Created on : Dec 15, 2021, 11:24:08 PM
    Author     : aksha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h3>Select Venue for Creating Event</h3><!-- comment -->
       
         <c:forEach items="${venues}" var="a" varStatus="count"> 
             
      Venue: ${a.getVenuename()}<form:radiobutton path="venue" value="${a.getVenueid()}" />
            <br>
            
              </c:forEach>  



 <form:form modelAttribute ="event">
        
    
            
            <input type="submit" value="REGISTER"/>
        </form:form>

  

       
        <p class="text-left"><a href="/myapp/UserDashboard.htm">Go Back to HomePage</a></p>
     
        
        
        
        
    </body>
</html>
