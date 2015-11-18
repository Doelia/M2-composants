/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.IOException;
import java.net.URL;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author doelia
 */
@Stateless
@Remote(Converter.class)
public class ConverterBean implements Converter {
    

    @Override
    public double euroToOtherCurrency(double amount, String currencyCode) {
        System.out.println("amount = "+amount);
        System.out.println("cur = " + currencyCode);
        try {
            SAXBuilder sxb = new SAXBuilder();
            URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            Document document = sxb.build(url);
            Element racine = document.getRootElement();
            Namespace ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
            Element elem = racine.getChild("Cube", ns);
            elem = elem.getChild("Cube", ns);
            for (Element e : elem.getChildren()) {
                if (e.getAttribute("currency").getValue().equals(currencyCode)) {
                    String rate = e.getAttribute("rate").getValue();
                    return Double.parseDouble(rate) * amount;
                }
            }
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
