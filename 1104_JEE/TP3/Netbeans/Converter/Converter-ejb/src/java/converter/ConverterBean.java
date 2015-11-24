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
import javax.ejb.Remote;
import javax.ejb.Stateful;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder; 

// Boite mail pour envoyer :
// jeetests@gmail.com
// gogogogo


/**
 *
 * @author doelia
 */
@Stateful // Pour garder en mémoire l'instance
@Remote(Converter.class)
public class ConverterBean implements Converter {
    
    //private SAXBuilder sxb;
    //private Document document;
    
    private Element racine;
    private Element racineMore;
   // private Namespace ns;
    
    private boolean isInit = false;
    
    // TODO ne pas init à chaque fois
    private void init() throws MalformedURLException, JDOMException, IOException {
        if (isInit) {
            return;
        }
        this.isInit = true;
        
        SAXBuilder sxb = new SAXBuilder();
        
        {
            URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            Document document = sxb.build(url);
            racine = document.getRootElement();
            Namespace ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
            racine = racine.getChild("Cube", ns);
            racine = racine.getChild("Cube", ns);
        }
        
        {
           URL url = new URL("http://www.currency-iso.org/dam/downloads/lists/list_one.xml");
           Document document = sxb.build(url);
           racineMore = document.getRootElement();
           racineMore = racineMore.getChild("CcyTbl");
        }
    }
    
    private String getFullNameMonay(String currencyCode) {
        try {
            this.init();
             for (Element e : racineMore.getChildren()) {
            String ccy = e.getChildText("Ccy");
            if (ccy != null && ccy.equals(currencyCode)) {
                 return e.getChildText("CtryNm");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        return "Undefined";
    }
 

    @Override
    public double euroToOtherCurrency(double amount, String currencyCode) {
        System.out.println("amount = "+amount);
        System.out.println("cur = " + currencyCode);
        CurrencyConvertorSoap cc = new CurrencyConvertor().getCurrencyConvertorSoap();
    }

    @Override
    public Map<Monnaie, Double> euroToOtherCurrencies(double amount) {
        Map<Monnaie, Double> map = new HashMap<>();
        
        try {
            this.init();
            
            for (Element e : racine.getChildren()) {
                String currency = e.getAttribute("currency").getValue();
                Double rate = Double.parseDouble(e.getAttribute("rate").getValue());
                
                Monnaie m = new Monnaie();
                m.codeMonnaie = currency;
                m.tauxDeChange = rate;
                m.pays = getFullNameMonay(currency);
                m.nomMonnaie = currency;
                
                Double calculated = m.tauxDeChange * rate;
                
                map.put(m, calculated);
            }
            
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return map;
        
    }

}
