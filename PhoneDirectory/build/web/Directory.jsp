<%-- 
    Document   : Details
    Created on : Feb 20, 2016, 12:36:01 PM
    Author     : cb-sathyanarayanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Directory</title>
        <link rel="stylesheet" type="text/css" href="CSS/directorycss.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <div id ="phoneDirectory" class ="detailsForm">
                <h1> Phone Directory </h1>
                <form action="nameMatch" method="post">
                    <input type ="text" class="textclass" name="name" placeholder="Match by name">
                    <input type="submit" class="submitclass" value="Submit">
                </form>
                <form action="partialMatch" method="post">
                    <input type ="text" class="textclass" name="partial" placeholder = "Match by partial">
                    <input type="submit" class="submitclass" value="Submit">
                </form>
                <form action="numberMatch"  method="post">
                    <input type ="text" class="textclass" name="phone" placeholder="Match by phone">
                    <input type="submit" class="submitclass" value="Submit">
                </form>
            </div>
        <%@include file="contacts.jspf"%> 
        <a href="AddContact.jsp"><button>Add Contact</button></a>
    </body>
</html>
