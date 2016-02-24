<%-- 
    Document   : EditContact
    Created on : Feb 23, 2016, 8:42:46 PM
    Author     : cb-sathyanarayanan
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Data.Phone"%>
<%@page import="Data.Address"%>
<%@page import="Data.Person"%>
<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            User user= (User) sessionDetails.getAttribute("user");
            Person person=(Person) sessionDetails.getAttribute("contact");
            Address address=person.getAddress();%>
        <% if(user!=null) {%>
        <div class="heading">
            <span class="heading-text-left">
                <a class="heading-anchor" href="Directory.jsp">Space Portal</a>
            </span>
            <span class="heading-text-right">
                Hi,<%=user.getUserName()%>
            </span>
                <a class="heading-anchor" href="Deactivate.jsp">DeactivateAccount</a>
                <a class="heading-anchor" href="Logout.jsp">Log out</a>
        </div>
        <div id="edit-details-form">
            <h1>Edit Details</h1>
            <form method="POST" action="editContact">
                <div class="edit-details-list">
                    <span class="body-field">NAME</span>
                    <span class="body-value">
                        <input type="text" name="firstName" value="<%=person.getFirstName()%>" placeholder="First Name">
                        <input type="text" name="lastName" value="<%=person.getLastName()%>" placeholder="Last Name" required>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field">ADDRESS</span>
                    <span class="body-value">
                        <%if(address.getAddressLine1()!=null){%>
                        <input type="text" name="addressLine1" value="<%=address.getAddressLine1()%>" placeholder="AddressLine1" required>
                        <%}else{%>
                        <input type="text" name="addressLine1" placeholder="AddressLine1" required>
                        <%}%>
                        <% if(address.getAddressLine2()!=null){%>
                        <input type="text" name="addressLine2" value="<%=address.getAddressLine2()%>" placeholder="AddressLine2" required>
                        <%}else{%>
                        <input type="text" name="addressLine2" placeholder="AddressLine2" required>
                        <%}%>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <% if(address.getCity()!=null){%>
                        <input type="text" name="city" value="<%=address.getCity()%>" placeholder="City" required>
                        <%}else{%>
                        <input type="text" name="city" placeholder="City" required>
                        <%}%>
                        <% if(address.getState()!=null){%>
                        <select name="state" id="stateChange" disabled="disabled" required>
                            <option value="<%=address.getState()%>"><%=address.getState()%></option>
                        </select>
                        <%}else{%>
                        <select name="state" id="state" disabled="disabled" required>
                            <option value=""> </option>
                        </select>
                        <%}%>
                    </span>
                </div>
                <div class="edit-details-list">
                    <span class="body-field"></span>
                    <span class="body-value">
                        <% if(address.getZIP()!=null){%>
                        <input type="text" name="ZIP" value="<%=address.getZIP()%>" placeholder="ZIP" pattern="[0-9]{6}">
                        <%}else{%>
                        <input type="text" name="ZIP" placeholder="ZIP" pattern="[0-9]{6}">
                        <%}%>
                        <% if(address.getCountry()!=null){%>
                        <select  name="country" id="countryChange" onchange="setNewState()" required>
                            <option value="<%=address.getCountry()%>"> <%=address.getCountry()%> </option>
                            <option value="China">China </option>
                            <option value="India">India</option>
                            <option value="Japan">Japan</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="SriLanka">Sri Lanka</option>
                        </select>
                        <%}else{%>
                        <select name="country" id="country"  onchange="setState()" required>
                            <option value=""> </option>
                            <option value="China">China </option>
                            <option value="India">India</option>
                            <option value="Japan">Japan</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="SriLanka">Sri Lanka</option>
                        </select>
                        <%}%>
                    </span>
                </div>
                <div class="edit-details-list">
                    <%
                      for(Phone phone : person.getPhoneNumbers()){
                    %>
                    <span class="body-field">Phone Number: (<%=phone.getType()%>)</span>
                    <span class="body-value">
                         <input type="text" name="<%=phone.getType()%>" value="<%=phone.getNumber()%>">
                    </span>
                    <% } %>
                </div>
                    <span class="body-field"> </span>
                    <span class="body-value">
                        <input type="submit" value="save details">
                        <a href="EditContact.jsp" id="discard">Discard</a>
                    </span>
                    <input type="hidden" name="contactId" value="<%=person.getContactId()%>">
            </form>
        </div>
        <%} else {%>
        The Session has ended please<a href="Login.jsp"> log in </a>again to continue.
        <%} %>
    </body>
</html>
