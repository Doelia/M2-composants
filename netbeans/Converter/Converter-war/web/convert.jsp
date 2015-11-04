<%-- 
    Document   : convert
    Created on : 4 nov. 2015, 11:06:28
    Author     : doelia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean class="converter.ConverterBean" id="beanConv"/>
        
        <%
        double amount = Double.parseDouble(request.getParameter("amount"));
        String currency = request.getParameter("amount");
        double converted = beanConv.euroToOtherCurrency(amount, currency);
        out.print(converted);
        %>

        <h1>Hello World!</h1>
    </body>
</html>
