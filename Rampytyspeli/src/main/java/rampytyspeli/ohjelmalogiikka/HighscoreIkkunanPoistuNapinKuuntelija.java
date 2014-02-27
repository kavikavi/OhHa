
package rampytyspeli.ohjelmalogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rampytyspeli.Kayttoliittyma.HighscoreIkkuna;

/**
 *Kuuntelija pisteikkunan poistu-napille.
 *
 */
public class HighscoreIkkunanPoistuNapinKuuntelija implements ActionListener {

    private HighscoreIkkuna ikkuna;
    
    /**
     *Konstruktori. 
     * @param ikkuna 
     */
    public HighscoreIkkunanPoistuNapinKuuntelija(HighscoreIkkuna ikkuna) {
        this.ikkuna = ikkuna;
    }
    
    /**
     * Sulkee ikkunan.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.ikkuna.sulje();
    }
    
}
