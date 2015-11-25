<%-- 
    Document   : index.jsp
    Created on : 18 nov. 2015, 10:39:33
    Author     : doelia
--%>

<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="javax.jms.MessageProducer"%>
<%@page import="javax.jms.TextMessage"%>
<%@page import="javax.jms.Session"%>
<%@page import="javax.jms.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.jms.QueueConnectionFactory"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">
    </head>
    <body class="container">
        <jsp:useBean class="converter.ConverterBean" id="beanConv"/>

        <h1>Convertisseur</h1>
        
        <%
            String defaultValue = "0";
            String defaultCurrency = "";
            String defaultConverted = "0";
            String errMessage = null;
            
            // Gestion du formulaire
            if (request.getParameter("submit") != null) {
                String amount = request.getParameter("amount");
                String currency = request.getParameter("currency");
                
                if (amount == null || currency == null) {
                    errMessage = ("Erreur: Des valeurs n'ont pas été entrées correctement.");
                } else {
                    try {
                        double amountDouble = Double.parseDouble(amount);
                        double converted = beanConv.euroToOtherCurrency(amountDouble, currency);
                        
                        if (amountDouble < 0) {
                            throw new IllegalArgumentException();
                        }
                        
                        // Affichage au client
                        defaultConverted = ""+converted;
                        defaultValue = amount;
                        defaultCurrency = currency;
                        
                    } catch (Exception e) {
                       errMessage = ("Erreur durant la conversion de '"+amount+"' en double.");
                    }
                    
                }
                
            }
        %>   
            
        <%
            // Liste des devises pour la liste déroulante du client
            ArrayList<String> curencies = beanConv.getCurrenciesList();
        %>

        
        <%
            if (errMessage != null) {
                %>
                <div class="alert alert-danger">
                    <% out.print(errMessage); %>
                </div>
                <%
            }
        %>
            
        <form action="index.jsp">
            <b>Montant</b> (en EUR) <input name="amount" type="number" value="<% out.print(defaultValue); %>">
            
            vers
            <select name="currency">
            <%
                for (String sc : curencies) {
                    out.println("<option value=\""+sc+"\" "+((sc.equals(defaultCurrency))?"selected=\"selected\"":"")+">"+sc+" "+beanConv.getFullNameMonay(sc)+"</option>");
                }
            %>
            </select>
            
            <br> <br>
            <input  class="btn btn-success btn-sm" type="submit" value="Convertir =>" name="submit" />
            <input name="converted" type="number" disabled="disabled" value="<% out.print(defaultConverted); %>">
        </form>
        
    </body>
</html>
