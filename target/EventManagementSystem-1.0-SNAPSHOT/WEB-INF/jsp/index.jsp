<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>SOME ERROR!!!!!!!!!!!!!!!!!!!!!!!!.</p>
       
        <form action="/user.htm" method="post">>
            <input type="text" name="userName"  placeholder="Enter First Name" required>
            <input type="email" name="email" placeholder="Enter Email Id">
            <input type="password" name="password" class="form-control" placeholder="Enter password">
            <input type="submit" value="signup"/>
            <input type="hidden" name="action" value="signup" />
        </form>
    </body>
</html>
