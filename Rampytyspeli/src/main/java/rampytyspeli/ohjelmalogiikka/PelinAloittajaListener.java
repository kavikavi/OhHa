
package rampytyspeli.ohjelmalogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rampytyspeli.Kayttoliittyma.Kayttoliittyma;

/**
 *Listener päävalikon napille "Aloita peli".
 * 
 */
public class PelinAloittajaListener implements ActionListener {

    /**
     * Luo uuden "Käyttöliittymän".
     * Peli aukeaa uuteen ikkunaan.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Kayttoliittyma k = new Kayttoliittyma();
        k.run();
    }
    
    
    
    
}
