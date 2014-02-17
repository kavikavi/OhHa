
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

/**
 * Päävalikko.
 * 
 *
 */
public class Paavalikko implements Runnable {
    private JFrame frame;
    private Kayttoliittyma kayttis;
    
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
        Font font = new Font(SANS_SERIF, PLAIN, 20);
        JLabel otsikko = new JLabel("Rämpytyspeli");
        JButton kaynnistysnappi = new JButton("Aloita peli");
        JButton highscore = new JButton("Ennätyspisteet");
    }
    
    /**
     * Lisää nappien kuuntelijat.
     */
    private void lisaaKuuntelijat() {
        //TEE TÄÄ LOPPUUN
    }
}
