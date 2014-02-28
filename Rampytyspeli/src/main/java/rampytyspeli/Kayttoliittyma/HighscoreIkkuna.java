
package rampytyspeli.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import rampytyspeli.ohjelmalogiikka.Highscore.Highscorelogiikka;
import rampytyspeli.ohjelmalogiikka.Highscore.Pistetulos;
import rampytyspeli.ohjelmalogiikka.HighscoreIkkunanPoistuNapinKuuntelija;
import java.nio.charset.Charset;

/**
 *Ennätyspisteiden ikkuna. 
 *Avataan päävalikosta.
 * 
 */
public class HighscoreIkkuna implements Runnable {

    private JFrame frame;
    private JLabel ylarivi;
    private JLabel pisteet;
    private JButton poistu;
    private Highscorelogiikka logiikka;
    
    /**
     * Konstruktori.
     */
    public HighscoreIkkuna() {
        this.logiikka = new Highscorelogiikka();
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            luoKomponentit(frame.getContentPane());
        } catch (FileNotFoundException ex) {
        }
        lisaaKuuntelijat();

        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Luo highscoreikkunan komponentit.
     * Ylärivin teksti, 10 riviä pisteille sekä alarivi poistumisnapille.
     * @param container
     * @throws FileNotFoundException 
     */
    private void luoKomponentit(Container container) throws FileNotFoundException {
        container.setLayout(new GridLayout(12,1));
        this.ylarivi= new JLabel("Ennätyspisteet, 10 parasta");
        this.poistu = new JButton("Poistu");
        lisaaFontti();
        container.add(this.ylarivi);
        Pistetulos[] top10 = new Pistetulos[99999];
        top10 = logiikka.haeHighscore("Highscore.txt").toArray(top10);
        int i=0;
        while (i<10) {
            String nimi =top10[i].getNimi();
            JLabel rivi = new JLabel(nimi + " - " + top10[i].getPisteet());
            container.add(rivi);
            i++;
        }
        container.add(this.poistu);
    }
    
    /**
     * Lisää fontit kenttiin.
     */
    private void lisaaFontti() {
        Font font = new Font(SANS_SERIF, PLAIN, 20);
        this.ylarivi.setFont(font);
        this.poistu.setFont(font);
    }
    
    /**
     * Lisää kuuntelijan poistu-napille.
     */
    private void lisaaKuuntelijat() {
        HighscoreIkkunanPoistuNapinKuuntelija poistuja = new HighscoreIkkunanPoistuNapinKuuntelija(this);
        this.poistu.addActionListener(poistuja);
    }
    
    /**
     * Sulkee ikkunan.
     * Poistu-nappi kutsuu tätä metodia.
     */
    public void sulje() {
        this.frame.dispose();
    }
    
}
