/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.ejb.Remote;

/**
 *
 * @author doelia
 */
@Remote
public interface Converter {
    
    public double euroToOtherCurrency(double amount, String currencyCode);
    
}
