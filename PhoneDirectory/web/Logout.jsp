<%-- 
    Document   : Logout
    Created on : Feb 22, 2016, 12:21:27 PM
    Author     : cb-sathyanarayanan
--%>

<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <meta http-equiv="refresh" content="1; url=logout">
    </head>
    <body>
        <% 
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user= (User) sessionDetails.getAttribute("user");%>
        <%if(user!=null){%>
            Successfully logged out. Redirecting....
        <%} else { %>
            The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <% } %>
    </body>
</html>
