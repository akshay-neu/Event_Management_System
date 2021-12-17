<%-- 
    Document   : venuesuccess
    Created on : Dec 13, 2021, 10:23:56 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venue Success Page</title>
    </head>
    <body>
       <h1>Following Venue was Saved Successfully: </h1>
        Venue: ${requestScope.venue.venuename}
    </body>
</html>
