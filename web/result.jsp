<%-- 
    Document   : result
    Created on : Sep 21, 2012, 3:14:51 PM
    Author     : deepakga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- To make sure that display is properly sized as per the device -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: lightgray">

        <div style="float:left ; width: 60%">
            <div style="float:top ; width: 70%">

                &nbsp;&nbsp;&nbsp  <label style="color: blue ; font-size: xx-large ; font-style: italic"><%= request.getAttribute("search")%>
                    <br>
                    <br>
                    &nbsp;&nbsp;&nbsp <label style="color: firebrick ; font-size: large">Plant &nbsp;&nbsp;&nbsp

                        &nbsp;&nbsp;&nbsp<label style="color: green ; font-size: large"><%= request.getAttribute("str")%>
                            </br>
                            &nbsp;&nbsp;&nbsp   <label style="color: firebrick ; font-size: large">Abstract  &nbsp;&nbsp;&nbsp

                                &nbsp;&nbsp;&nbsp <label style="color: green ; font-size: large"><%= request.getAttribute("commnts")%>

                                    </br>
                                    &nbsp;&nbsp;&nbsp     <label style="color: firebrick ; font-size: large">Common Name &nbsp;&nbsp;&nbsp
                                        &nbsp;&nbsp;&nbsp    <label style="color: green ; font-size: large"><%= request.getAttribute("name")%>
                                            </br>

                                            &nbsp;&nbsp;&nbsp    <label style="color: firebrick ; font-size: large">Kingdom &nbsp;&nbsp;&nbsp

                                                &nbsp;&nbsp;&nbsp         <a href="<%= request.getAttribute("kingdomURL")%>"> <%= request.getAttribute("kingdom")%></a>
                                                </br>

                                                &nbsp;&nbsp;&nbsp        <label style="color: firebrick ; font-size: large">Species &nbsp;&nbsp;&nbsp

                                                    &nbsp;&nbsp;&nbsp           <label style="color: green ; font-size: large"><%= request.getAttribute("species")%>


                                                        </br>
                                                        &nbsp;&nbsp;&nbsp               <label style="color: firebrick ; font-size: large">Genus &nbsp;&nbsp;&nbsp

                                                            &nbsp;&nbsp;&nbsp                <a href="<%= request.getAttribute("genusURL")%>"> <%= request.getAttribute("genus")%></a>

                                                            </br>

                                                            &nbsp;&nbsp;&nbsp              <label style="color: firebrick ; font-size: large">Familia &nbsp;&nbsp;&nbsp

                                                                &nbsp;&nbsp;&nbsp            <a href="<%= request.getAttribute("familiaURL")%>"> <%= request.getAttribute("familia")%></a>
                                                                </br>


                                                                &nbsp;&nbsp;&nbsp     <label style="color: firebrick ; font-size: large">divisio &nbsp;&nbsp;&nbsp

                                                                    &nbsp;&nbsp;&nbsp        <label style="color: green ; font-size: large"><%= request.getAttribute("divisio")%>


                                                                        </div></div>
                                                                        <div style="float:right ; width: 40%">

                                                                            <img src="<%= request.getAttribute("image")%>" height="200" width="400"></img>        


                                                                        </div>
                                                                        </body>
                                                                        </html>
