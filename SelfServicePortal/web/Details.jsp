<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.User"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/detailscss.css">
        <title>User Details</title>
    </head>
    <body>
        <%
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user= (User) sessionDetails.getAttribute("User");%>
        <%if(user!=null){%>
        <div class="heading">
            <span class="heading-text-left">
                Space Portal
            </span>
            <span class="heading-text-right">
                Hi,<%=user.getFirstName()%>
            </span>
                <a class="heading-anchor" href="Deactivate.jsp">DeactivateAccount</a>
                <a class="heading-anchor" href="Logout.jsp">Log out</a>
        </div>
        <div id="details-form">
            <h1>Welcome to the Space Portal</h1>
            <div class="details-list">
            <span class="body-field"> 
                NAME
            </span> 
            <span class="body-value">
                <span id="name"> <%=user.getFirstName()%>  <%=user.getLastName()%> </span>
            </span>
            </div>
            <div class="details-list">
            <span class="body-field">
                EMAIL ID
            </span>
            <span class="body-value">
                <%=user.getEmail()%>
            </span>
            </div>
            <div class="details-list">
            <span class="body-field">
                ADDRESS
            </span>
            <span class="body-value">
            <%if(user.getAddressLine1()!=null || user.getAddressLine2()!=null || user.getCity()!=null || user.getState()!=null || user.getZIP() !=null || user.getCountry()!=null){%>
                <%=user.getAddress()%> <br>
            <%}else{%>
                --NA--  <br> <a href="AddDetails.jsp">AddDetails</a> &nbsp;
            <%}%>
            </span>
            </div>
            <button onclick="location.href = 'EditDetails.jsp';">EditDetails</button>
        </div>
        <%} else { %>
            The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <% } %>
    </body>
</html>
