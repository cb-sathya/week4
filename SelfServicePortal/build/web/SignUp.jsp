<%-- 
    Document   : SignUp
    Created on : Feb 5, 2016, 3:15:13 PM
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
            <form action="signUp" method="post">
                <div class="inputBlock">
                    <input type="text" name="firstName" placeholder="First Name" required>
                    <input type="text" name="lastName" placeholder = "Last Name" required>
                </div>
                <div class="inputBlock">
                    <input type="email" name="email" placeholder = "Email" required>
                    <input type="email" name="confirmEmail" placeholder="Confirm email" required>
                </div>
                <div class="inputBlock">
                    <input type="password" name="password" placeholder = "Password" required>
                    <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
                </div>
                <div id="errormsg">${errormsg}</div>
               <div id="registerSubmit">
                <input type="submit" value="Create an account"><br>
                <a href="Login.jsp">Have an account already?</a>
               </div>
            </form>
        </div>
    </body>
</html>
