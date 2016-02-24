<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.User"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="1; url=logout">
        <title>Logout</title>
    </head>
    <body>
        <% 
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user= (User) sessionDetails.getAttribute("User");%>
        <%if(user!=null){%>
            Successfully logged out. Redirecting....
        <%} else { %>
            The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <% } %>
    </body>
</html>
