
package rampytyspeli.ohjelmalogiikka;

import rampytyspeli.Kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;
import rampytyspeli.Kayttoliittyma.Paavalikko;


public class Main {
    public static void main( String[] args ) {
//        Kayttoliittyma kayttis = new Kayttoliittyma();
//        SwingUtilities.invokeLater(kayttis);
        
        Paavalikko p = new Paavalikko();
        SwingUtilities.invokeLater(p);
    }
}
