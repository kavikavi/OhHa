
package rampytyspeli.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;
import javax.swing.JButton;
import rampytyspeli.ohjelmalogiikka.HighscoreIkkunanAvaajaListener;
import rampytyspeli.ohjelmalogiikka.PelinAloittajaListener;

/**
 * Päävalikko.
 * Sisältää napit aloitukselle ja pisteiden tarkastelulle.
 *
 */
public class Paavalikko implements Runnable {
    private JFrame frame;
    private Kayttoliittyma kayttis;
    private JButton kaynnistysnappi;
    private JButton highscore;
    private JLabel otsikko;
    
    /**
     * Konstruktori.
     */
    public Paavalikko() {
        this.kayttis = new Kayttoliittyma();
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();

        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Luo komponentit, eli pelin nimi, käynnistysnappi ja highscoren avaamisnappi.
     * @param container 
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(3,1));
        this.otsikko = new JLabel("Tervetuloa Rämpytyspeliin!");
        this.kaynnistysnappi = new JButton("Aloita peli");
        this.highscore = new JButton("Ennätyspisteet");
        asetaFontit();
        container.add(otsikko);
        container.add(kaynnistysnappi);
        container.add(highscore);
    }
    
    /**
     * Asettaa fontin.
     */
    private void asetaFontit() {
        Font font = new Font(SANS_SERIF, PLAIN, 20);
        this.otsikko.setFont(font);
        this.kaynnistysnappi.setFont(font);
        this.highscore.setFont(font);
    }
    
    /**
     * Lisää nappien kuuntelijat.
     */
    private void lisaaKuuntelijat() {
        PelinAloittajaListener aloittaja = new PelinAloittajaListener();
        HighscoreIkkunanAvaajaListener avaaja = new HighscoreIkkunanAvaajaListener();
        this.kaynnistysnappi.addActionListener(aloittaja);
        this.highscore.addActionListener(avaaja);
    }
}
