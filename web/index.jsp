<%-- 
    Document   : index
    Created on : Sep 14, 2012, 7:52:50 PM
    Author     : deepakga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: blanchedalmond">
        <div style="color: teal">

            <!-- JSP script to validate input parameters-->

            <script type='text/javascript'>
                function isEmpty(){
                    var el = document.getElementById('id1');  //select input for string name 
                    if(el.value.length == 0){                   //If name field is left null send an alert message else submit the form
                        alert("Please enter a name");
                        el.focus();
                        return false;
                    }else hashform.submit();
                }
            </script>
            <!-- Form to collect string for which hash is to be calculated and also selecting hash function using radio button -->
            <form name='hashform' action="RdfParser" method="GET">
                <label for="letter">Enter a String to calculate the HASH for </label>
                <input type="text" name="search" id="id1" value="" /><br>          <!-- Input String for which Hash is to be calculated -->
                          <input type="button" value="Start" onclick="isEmpty()"  /> 
                <!-- onclick is used to call isEmpty()function for validating input parameters -->
            </form>
        </div>
    </body>
</html>
