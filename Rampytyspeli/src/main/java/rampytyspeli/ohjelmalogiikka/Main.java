
package rampytyspeli.ohjelmalogiikka;

import javax.swing.SwingUtilities;
import rampytyspeli.Kayttoliittyma.Paavalikko;


public class Main {
    public static void main( String[] args ) {
        Paavalikko p = new Paavalikko();
        SwingUtilities.invokeLater(p);
    }
}
