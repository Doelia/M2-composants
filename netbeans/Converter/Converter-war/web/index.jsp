<%-- 
    Document   : index.jsp
    Created on : 18 nov. 2015, 10:39:33
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

        <h1>Convertisseur de devise</h1>
        
        <%
            String amount = request.getParameter("amount"); // ...
            if ((amount != null) && (amount.length() != 0)) {
                double amountDouble = Double.parseDouble(request.getParameter("amount"));
                String currency = request.getParameter("devise");
                
                double converted = beanConv.euroToOtherCurrency(amountDouble, currency);
                out.print(converted);
        
                String email = request.getParameter("email");
                if (email != null && email.length() != 0) {
                    // Demander au MDB de déclencher la demande de conversion
                    // dans toutes les monnaies par le bean session
                    // le MDB va ensuite envoyer un email avec toutes
                    // ces informations au format HTML (dans un tableau HTML)
                    // (voir plus loin ce que doivent faire les beans) ...
                }
            }
        %>

        <p>Liste des devises : http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml</p>
        <form action="index.jsp">
            Montant <input name="amount"><br>
            Monnaie cible <input name="devise"><br>
            Adresse email : <input name="mail" type="email" />
            <button type="submit" value="GO">
        </form>
    </body>
</html>
