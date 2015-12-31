/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


@Stateful // Pour garder en mémoire l'instance
@Remote(Converter.class)
public class ConverterBean implements Converter {


    private ArrayList<String> listCurrencies;
    private Element racineMore;

    private boolean isInit = false;

    private void init() {
        if (isInit) {
            return;
        }
        this.isInit = true;
        this.buildCurrencyList();
        this.buildFullNameCurrencyDocument();
    }
    
    private void buildFullNameCurrencyDocument() {
        SAXBuilder sxb = new SAXBuilder();
        try {
            URL url = new URL("http://www.currency-iso.org/dam/downloads/lists/list_one.xml");
            Document document = sxb.build(url);
            racineMore = document.getRootElement();
            racineMore = racineMore.getChild("CcyTbl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buildCurrencyList() {
        System.out.println("buildCurrencyList...");
        listCurrencies = new ArrayList<>();
        try {
            URL url = new URL("http://currencies.apps.grandtrunk.net/currencies");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(url.openStream()));
            String cur;
            while ((cur = in2.readLine()) != null) {
                listCurrencies.add(cur);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getCurrenciesList() {
        this.init();
        return listCurrencies;
    }

    @Override
    public double euroToOtherCurrency(double amount, String currencyCode) {
        this.init();
        System.out.println("[ConverterBean] amount = " + amount);
        System.out.println("[ConverterBean] currencyCode = " + currencyCode);
        try {
            URL url = new URL("http://currencies.apps.grandtrunk.net/getlatest/" + "EUR" + "/" + currencyCode);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(url.openStream()));
            String rateStr = in2.readLine();
            Double rate = Double.parseDouble(rateStr);
            System.out.println("rate = " + rate);
            return rate * amount;
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

       return -1;
    }
    
    public String getFullNameMonay(String currencyCode){ 
        try {
            this.init();
            for (Element e : racineMore.getChildren()) {
                String ccy = e.getChildText("Ccy");
                if (ccy != null && ccy.equals(currencyCode)) {
                    return "("+e.getChildText("CtryNm")+")";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }



    

}
