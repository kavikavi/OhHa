
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import rampytyspeli.Kayttoliittyma.Kayttoliittyma;

/**
 * Näppäintenkuuntelijaluokka
 * 
 * Toimii yhteistyössä lähinnä pelin kanssa: kokeilee,
 * onko painettu nappi painettavana ja muuttaa pistemäärää sen mukaan.
 */
public class NappaintenKuuntelija implements KeyListener {
    
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori
     * 
     * @param q Näppäin q
     * @param w Näppäin w
     * @param e Näppäin e
     * @param r Näppäin r
     * @param peli Peli, jolle luokka kuuntelee ja joka asettaa
     * painettavat näppäimet.
     * @param kayttoliittyma Käyttöliittymä, jonka moodia näppäimen painallus
     * päivittää.
     */
    public NappaintenKuuntelija(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli, Kayttoliittyma kayttoliittyma) {
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.peli=peli;
        this.kayttis = kayttoliittyma;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    /**
     * Jos painettu näppäin on pelissä asetettu painettavaksi, 
     * pistemäärä nousee yhdellä.
     * Jos taas ei ole, pistemäärä vähenee yhdellä.
     * 
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            if (peli.paina("q") == true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            kayttis.paivitaMoodi();
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            if (peli.paina("w")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            kayttis.paivitaMoodi();
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            if (peli.paina("e")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            kayttis.paivitaMoodi();
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            if (peli.paina("r")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            kayttis.paivitaMoodi();
            System.out.println(peli.pisteet());
        }
        
    }
}
