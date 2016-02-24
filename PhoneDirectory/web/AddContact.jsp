<%-- 
    Document   : AddContact
    Created on : Feb 22, 2016, 3:53:02 PM
    Author     : cb-sathyanarayanan
--%>

<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/editdetailscss.css">
        <script type="text/javascript" src="countryState.js"> </script>
        <title>Add Contact</title>
    </head>
    <body>
        <%
          response.setHeader("Cache-Control","no-store");
          HttpSession sessionDetails=request.getSession();
          User user=(User) sessionDetails.getAttribute("user");%>
        <%if(user!=null){%>
        <div class="heading">
            <span class="heading-text-left">
                <a class="heading-anchor" href="Directory">Space Portal</a>
            </span>
            <span class="heading-text-right">
                Hi,<%=user.getUserName()%>
            </span>
                <a class="heading-anchor" href="Deactivate.jsp">DeactivateAccount</a>
                <a class="heading-anchor" href="Logout.jsp">Log out</a>
        </div>
        <div id="edit-details-form">
            <h1>Add Details</h1>
            <form method="POST" action="addContacts">
                <div class="edit-details-list">
                    <span class="body-field">Contact Id</span>
                    <span class="body-value">
                        <input type="text" name="contactId" placeholder="ContactId" required>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">NAME</span>
                    <span class="body-value">
                        <input type="text" name="firstName" placeholder="First Name" required>
                        <input type="text" name="lastName" placeholder="Last Name" required>
                    </span>
                </div>
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
                <div class="edit-details-list">
                    <span class="body-field">Phone Number: (Home)</span>
                    <span class="body-value">
                        <input type="text" name="Home" placeholder="Home">
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">Phone Number: (Work)</span>
                    <span class="body-value">
                        <input type="text" name="Work" placeholder="Work">
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">Phone Number: (Mobile)</span>
                    <span class="body-value">
                        <input type="text" name="Mobile" placeholder="Mobile">
                    </span>
                </div>
                    <span class="body-field"> </span>   
                    <span class="body-value">
                        <input type="submit" value="save details">
                        <a href="AddContact.jsp" id="discard">Discard</a>
                    </span>
            </form>
        </div>
        <%} else {%>
        The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <%} %>
    </body>
</html>
