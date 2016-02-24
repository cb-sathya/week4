<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.User"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/editdetailscss.css">
        <script type="text/javascript" src="countryState.js"> </script>
        <title>Edit Details</title>
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
            <h1>Edit Details</h1>
            <form method="POST" action="editDetails">
                <div class="edit-details-list">
                    <span class="body-field">NAME</span>
                    <span class="body-value">
                        <input type="text" name="firstName" value="<%=user.getFirstName()%>" placeholder="First Name" required>
                        <input type="text" name="lastName" value="<%=user.getLastName()%>" placeholder="Last Name" required>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">EMAIL</span>
                    <span class="body-value">
                        <input type="text" id="nochange" name="Email" value="<%=user.getEmail()%>" readonly>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">ADDRESS</span>
                    <span class="body-value">
                        <%if(user.getAddressLine1()!=null){%>
                        <input type="text" name="addressLine1" value="<%=user.getAddressLine1()%>" placeholder="AddressLine1">
                        <%}else{%>
                        <input type="text" name="addressLine1" placeholder="AddressLine1">
                        <%}%>
                        <% if(user.getAddressLine2()!=null){%>
                        <input type="text" name="addressLine2" value="<%=user.getAddressLine2()%>" placeholder="AddressLine2">
                        <%}else{%>
                        <input type="text" name="addressLine2" placeholder="AddressLine2">
                        <%}%>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <% if(user.getCity()!=null){%>
                        <input type="text" name="city" value="<%=user.getCity()%>" placeholder="City">
                        <%}else{%>
                        <input type="text" name="city" placeholder="City">
                        <%}%>
                        <% if(user.getState()!=null){%>
                        <select name="state" id="stateChange" disabled="disabled">
                            <option value="<%=user.getState()%>"><%=user.getState()%></option>
                        </select>
                        <%}else{%>
                        <select name="state" id="state" disabled="disabled"></select>
                        <%}%>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"></span>
                    <span class="body-value">
                        <% if(user.getZIP()!=null){%>
                        <input type="text" name="ZIP" value="<%=user.getZIP()%>" placeholder="ZIP" pattern="[0-9]{6}">
                        <%}else{%>
                        <input type="text" name="ZIP" placeholder="ZIP" pattern="[0-9]{6}">
                        <%}%>
                        <% if(user.getCountry()!=null){%>
                        <select  name="country" id="countryChange" onchange="setNewState()">
                            <option value="<%=user.getCountry()%>"> <%=user.getCountry()%> </option>
                            <option value="China">China </option>
                            <option value="India">India</option>
                            <option value="Japan">Japan</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="SriLanka">Sri Lanka</option>
                        </select>
                        <%}else{%>
                        <select name="country" id="country"  onchange="setState()">
                            <option value=""></option>
                            <option value="China">China </option>
                            <option value="India">India</option>
                            <option value="Japan">Japan</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="SriLanka">Sri Lanka</option>
                        </select>
                        <%}%>
                    </span>
                </div>
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <input type="submit" value="save details">
                        <a href="EditDetails.jsp" id="discard">Discard</a>
                    <span class="body-value">
            </form>
        </div>
        <%} else {%>
        The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <%} %>
    </body>
</html>
