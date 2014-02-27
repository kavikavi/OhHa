
package rampytyspeli.ohjelmalogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import rampytyspeli.Kayttoliittyma.Kayttoliittyma;
import rampytyspeli.ohjelmalogiikka.Highscore.Highscorelogiikka;

/**
 * Pelin lopetusmoodin jatkamisnapin toiminnankuuntelija.
 * 
 */
public class PisteidenLisaysListener implements ActionListener {

    private JTextField teksti;
    private int pisteet;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori.
     * @param teksti teksti tekstikentästä
     * @param piste pistemäärä
     * @param kayttis 
     */
    public PisteidenLisaysListener(JTextField teksti, int piste, Kayttoliittyma kayttis) {
        this.teksti=teksti;
        this.pisteet=piste;
        this.kayttis=kayttis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
            if ((this.teksti.getText().equals("")) || (this.teksti.getText().equals("Nimi tähän"))) {
                this.kayttis.sulje();
            } else {
            try {
                Highscorelogiikka l = new Highscorelogiikka();
                String nimi = this.teksti.getText();
                l.tallennaUusitulos(nimi, pisteet, "Highscore.txt");
                this.kayttis.sulje();
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
            }
        
        
    }
    
}
