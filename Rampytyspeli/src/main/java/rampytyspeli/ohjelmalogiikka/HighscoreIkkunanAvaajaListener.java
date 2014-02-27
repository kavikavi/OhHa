
package rampytyspeli.ohjelmalogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rampytyspeli.Kayttoliittyma.HighscoreIkkuna;

/**
 *
 * 
 */
public class HighscoreIkkunanAvaajaListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        HighscoreIkkuna ikkuna = new HighscoreIkkuna();
        ikkuna.run();
    }
    
}
