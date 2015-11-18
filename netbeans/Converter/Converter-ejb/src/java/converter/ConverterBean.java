/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateful;
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
@Stateful
@Remote(Converter.class)
public class ConverterBean implements Converter {
    
    private SAXBuilder sxb;
    private Document document;
    private Map<Monnaie, Double> map;
    
    private Element racine;
    private Namespace ns;
    
    
    private void init() throws MalformedURLException, JDOMException, IOException {
        sxb = new SAXBuilder();
        URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        document = sxb.build(url);
        racine = document.getRootElement();
        ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
        racine = racine.getChild("Cube", ns);
        racine = racine.getChild("Cube", ns);
    }
 

    @Override
    public double euroToOtherCurrency(double amount, String currencyCode) {
        System.out.println("amount = "+amount);
        System.out.println("cur = " + currencyCode);
        try {
            
            this.init();
            
            for (Element e : racine.getChildren()) {
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

    @Override
    public Map<Monnaie, Double> euroToOtherCurrencies(double amount) {
        try {
            this.init();
            
            Map<Monnaie, Double> map = new HashMap<>();
            
            for (Element e : racine.getChildren()) {
                String currency = e.getAttribute("currency").getValue();
                Double rate = Double.parseDouble(e.getAttribute("rate").getValue());
                
                Monnaie m = new Monnaie();
                m.codeMonnaie = currency;
                m.tauxDeChange = rate;
                m.pays = "";
                m.nomMonnaie = currency;
                
                Double calculated = m.tauxDeChange * rate;
                
                map.put(m, calculated);
                
            }
            
            return map;
            
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        
    }

}
