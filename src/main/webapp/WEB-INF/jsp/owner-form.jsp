<%-- 
    Document   : owner-form
    Created on : Dec 13, 2021, 10:18:15 PM
    Author     : aksha
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>owner form</title>
    </head>
    <body style="background-color: lightblue; text-align: center">
        <h1>Owner Registration Page</h1>
        
        <form:form modelAttribute ="owner">
            
            Owner Name: <form:input path="ownername" /> 
            <br><br>
            Email ID: <form:input path="emailid" />
            <br><br>
            Password: <form:input path="password" />
            <br><br>
       
                          
            <input type="submit" value="REGISTER"/>
        </form:form>
     
    </body>
</html>
