<%-- 
    Document   : event-success
    Created on : Dec 13, 2021, 10:21:51 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Success Page</title>
    </head>
    <body>
       <h1>Following Event was Saved Successfully: </h1>
        Event: ${requestScope.event.eventname}
    </body>
</html>
