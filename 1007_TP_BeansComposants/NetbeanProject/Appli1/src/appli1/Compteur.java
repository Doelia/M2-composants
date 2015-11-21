/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli1;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author doelia
 */
public class Compteur implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private int cpt = 0;
    
    private PropertyChangeSupport propertySupport;
    
    public Compteur() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public int getSampleProperty() {
        return cpt;
    }
    
    public void setSampleProperty(int value) {
        int oldValue = cpt;
        cpt = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, cpt);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public String getStringCounter() {
        return ""+cpt;
    }
    
    public void incr() {
        this.setSampleProperty(cpt+1);
    }
    
     public void decr() {
        this.setSampleProperty(cpt-1);
    }
    
    
    
}
