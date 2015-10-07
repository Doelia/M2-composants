/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli1;

import java.awt.TextArea;
import javax.swing.JLabel;

/**
 *
 * @author doelia
 */
public class Test1 extends JLabel {
    TextArea text;
 
    
    public Test1() {
        super("Ceci est le texte par défaut");
    }
    
    public void switchText() {
        String t1 = "Ceci est le texte 1";
        String t2 = "Ceci est le texte 2";
        this.setText(text.getText().equals(t1) ? t2 : t1);
    }
    
    public void testEcho() {
        System.out.println("Test Echo");
    }
}
