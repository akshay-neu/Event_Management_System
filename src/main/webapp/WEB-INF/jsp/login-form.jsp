<%-- 
    Document   : login-form
    Created on : Dec 14, 2021, 3:01:49 PM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form Page</title>
    </head>
    <body>
        <h1>EVENT MANAGEMENT SYSTEM</h1> <br> <br>
        <h2>SIGN IN</h2>
        <form:form modelAttribute ="home" >
            Email ID: <form:input path="emailid" placeholder="Enter email id"  /> 
            <br> <br>

            Password: <form:input path="password" placeholder="Enter password"  />
            <br> <br>
            
            User: <form:radiobutton path="role" value="user" />
            <br>
            EVENT ORGANIZER: <form:radiobutton path="role" value="organizer" />
            <br>
            VENUE OWNER: <form:radiobutton path="role" value="owner" />
            <br> <br>


            <input type="submit" value="LOGIN"/>
            
        </form:form>
            
            <p>
                <font color="red">
                ${nocredentials}
                
                <br><!-- comment -->
                <br>
                
                ${notmatched}
                </font>
            </p>
            
        <br> <br>
        <h2>SIGN UP</h2> 
        <!--        <a href="event/save.htm">Save Event</a> <br> <br>-->
        <a href="organizer/save.htm">Event Organizer Registration</a> <br> <br>
        <a href="owner/save.htm">Venue Owner Registration</a> <br> <br>
        <a href="user/save.htm">User Registration</a>   <br> <br>
        <!--        <a href="venue/save.htm">Save Venue</a> <br> <br>-->


    </body>
</html>
