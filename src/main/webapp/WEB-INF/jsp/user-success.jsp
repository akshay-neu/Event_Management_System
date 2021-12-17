<%-- 
    Document   : user-success
    Created on : Dec 12, 2021, 1:12:45 AM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Success Page</title>
    </head>
    <body>
        <h1>Following User was Saved Successfully: </h1>
        User: ${requestScope.user.username}
    </body>
</html>
