
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FromCurrency" type="{http://www.webserviceX.NET/}Currency"/>
 *         &lt;element name="ToCurrency" type="{http://www.webserviceX.NET/}Currency"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fromCurrency",
    "toCurrency"
})
@XmlRootElement(name = "ConversionRate")
public class ConversionRate {

    @XmlElement(name = "FromCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected Currency fromCurrency;
    @XmlElement(name = "ToCurrency", required = true)
    @XmlSchemaType(name = "string")
    protected Currency toCurrency;

    /**
     * Obtient la valeur de la propriété fromCurrency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getFromCurrency() {
        return fromCurrency;
    }

    /**
     * Définit la valeur de la propriété fromCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setFromCurrency(Currency value) {
        this.fromCurrency = value;
    }

    /**
     * Obtient la valeur de la propriété toCurrency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getToCurrency() {
        return toCurrency;
    }

    /**
     * Définit la valeur de la propriété toCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setToCurrency(Currency value) {
        this.toCurrency = value;
    }

}
