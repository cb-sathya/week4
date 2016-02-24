<%-- 
    Document   : Deactivate
    Created on : Feb 17, 2016, 4:01:32 PM
    Author     : cb-sathyanarayanan
--%>

<%@page import="servlets.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="5; url=deactivate">
        <title>Deactivate</title>
    </head>
    <body>
        <%
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user= (User) sessionDetails.getAttribute("User");
        %>
        <%if(user!=null){%>
        Deactivated account cannot be retrieved. Are you sure you want to deactivate your account?
        Your account will be deactivated in 5 seconds.
        <a href="Details.jsp"> no </a>
        <%} else { %>
            The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <% } %>
    </body>
</html>
