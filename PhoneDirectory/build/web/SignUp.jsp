<%-- 
    Document   : SignUp
    Created on : Feb 20, 2016, 4:21:55 PM
    Author     : cb-sathyanarayanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  type="text/css" href="CSS/signupcss.css">
        <title>Sign Up</title>
    </head>
    <body>
        <div id="registerForm">
            <h6>Register to</h6>
            <h1>Self Service Portal</h1>
            <form action="signup" method="post">
                <div class="inputBlock">
                    <input type="text" name="userName" placeholder = "User Name" required>
                    <input type="text" name="confirmUserName" placeholder="Confirm User Name" required>
                </div>
                <div class="inputBlock">
                    <input type="password" name="password" placeholder = "Password" required>
                    <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
                </div>
               <div id="registerSubmit">
                <input type="submit" value="Create an account"><br>
                <a href="Login.jsp">Have an account already?</a>
               </div>
            </form>
        </div>
    </body>
</html>
