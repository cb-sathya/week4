<%-- 
    Document   : Login
    Created on : Feb 20, 2016, 10:30:27 AM
    Author     : cb-sathyanarayanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Phone Directory - login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/logincss.css">
    </head>
    <body>
        <span class="large-heading">Space Portal</span>
        <br>
        <span class="small-heading">Login</span>
        <form method="POST" action="login" name="loginForm">
            <input type="text" name="userName" placeholder="User Name" required><br>
            <input type="password" name="password" placeholder="******" required><br>
            <div id="errormsg">${errormsg} </div>
            <input type="submit" value="LOGIN">
            <div class="underline">Don't remember your password?</div>
        </form>
        <div class="signup">
            <a href="SignUp.jsp"> New here?</a>
        </div>
    </body>
</html>
