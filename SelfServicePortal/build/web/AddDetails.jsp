<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.User"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/editdetailscss.css">
        <title>Add Details</title>
        <script type="text/javascript" src="countryState.js"> </script>
    </head>
    <body>
        <% 
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user= (User) sessionDetails.getAttribute("User");%>
        <%if(user!=null){%>
        <div class="heading">
            <span class="heading-text-left">
                <a class="heading-anchor" href="Details.jsp">Space Portal</a>
            </span>
            <span class="heading-text-right">
                Hi,<%=user.getFirstName()%>
            </span>
                <a class="heading-anchor" href="Deactivate.jsp">DeactivateAccount</a>
                <a class="heading-anchor" href="Logout.jsp">Log out</a>
        </div>
        <div id="edit-details-form">
            <h1>Add Details</h1>
            <form method="POST" action="addDetails">
                <div class="edit-details-list">
                    <span class="body-field">ADDRESS</span>
                    <span class="body-value">
                        <input type="text" name="addressLine1" placeholder="AddressLine1">
                        <input type="text" name="addressLine2" placeholder="AddressLine2">
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <input type="text" name="city" placeholder="City">
                        <select name="state" id="state" disabled="disabled">
                            <option value="" disabled selected>Select state</option>
                        </select>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <input type="text" name="ZIP" placeholder="ZIP" pattern="[0-9]{6}">
                        <select name="country" id="country"  onchange="setState()">
                            <option value="" disabled selected>select country</option>
                            <option value="China">China </option>
                            <option value="India">India</option>
                            <option value="Japan">Japan</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="SriLanka">Sri Lanka</option>
                        </select>
                    </span>
                </div>
                    <span class="body-field"> </span>   
                    <span class="body-value">
                        <input type="submit" value="save details">
                        <a href="AddDetails.jsp" id="discard">Discard</a>
                    </span>
            </form>
        </div>
        <%} else {%>
        The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <%} %>
    </body>
</html>