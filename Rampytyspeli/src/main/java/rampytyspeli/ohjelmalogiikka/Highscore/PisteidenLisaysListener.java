
package rampytyspeli.ohjelmalogiikka.Highscore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JTextArea;
import rampytyspeli.Kayttoliittyma.Kayttoliittyma;

/**
 * Pelin lopetusmoodin jatkamisnapin toiminnankuuntelija.
 * 
 */
public class PisteidenLisaysListener implements ActionListener {

    private JTextArea teksti;
    private Highscorelogiikka kirjoittaja;
    private int pisteet;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori.
     * @param teksti teksti tekstikentästä
     * @param piste pistemäärä
     * @param kayttis 
     */
    public PisteidenLisaysListener(JTextArea teksti, int piste, Kayttoliittyma kayttis) {
        this.teksti=teksti;
        this.pisteet=piste;
        this.kayttis=kayttis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if ((this.teksti.getText().equals("")) || (this.teksti.getText().equals("Nimi tähän"))) {
                this.kayttis.sulje();
            } else {
                this.kirjoittaja.tallennaUusitulos(this.teksti.getText(), pisteet, "Highscore.txt");
                this.kayttis.sulje();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
    
}
