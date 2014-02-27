
package rampytyspeli.Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import rampytyspeli.ohjelmalogiikka.Highscore.Highscorelogiikka;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Nappain;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.NappaintenKuuntelija;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Peli;
import rampytyspeli.ohjelmalogiikka.peli.pelimoodit.Pelimoodi;
import rampytyspeli.ohjelmalogiikka.peli.pelimoodit.Pelimoodi1;
import rampytyspeli.ohjelmalogiikka.peli.pelimoodit.Pelimoodi2;
import rampytyspeli.ohjelmalogiikka.peli.pelimoodit.LopetusMoodi;
/**
 * Itse pelin käyttöliittymäluokka. 
 * 
 * Luo vain framen, ikkunan sisältö tulee pelimoodilta JPanelissa.
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
    private Pelimoodi1 moodi1;
    private Pelimoodi2 moodi2;
    private LopetusMoodi lopetus;
    private Pelimoodi moodi;
    
    
    /**
     * Konstruktori.
     * Luodaan ja asetetaan näppäimet, peli ja moodit.
     */
    public Kayttoliittyma() {
        this.q = new Nappain("q");
        this.w = new Nappain("w");
        this.e = new Nappain("e");
        this.r = new Nappain("r");
        this.peli = new Peli(q,w,e,r);
        this.moodi1 = new Pelimoodi1(q, w, e, r, peli);
        this.moodi= moodi1;
        
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit1(frame.getContentPane());
        lisaaKuuntelijat();

        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Luo komponentit framelle, eli ts. lisää moodin.
     * @param container 
     */
    private void luoKomponentit1(Container container) {
//        container.setLayout(new BorderLayout());
        container.add(moodi1);
    }
    
    private void luoKomponentit2(Container container) {
//        container.setLayout(new BorderLayout());
        container.remove(moodi1);
        container.add(moodi2);
    } 
    
    private void luoKomponentit3(Container container) {
//        container.setLayout(new BorderLayout());
        container.remove(moodi2);
        container.add(lopetus);
    }
    
    /**
     * sulkee ikkunan.
     */
    public void sulje() {
        this.frame.dispose();
    }
    
    
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Luo ja lisää näppäintenkuuntelijan
     */
    private void lisaaKuuntelijat() {
        frame.addKeyListener(new NappaintenKuuntelija(q, w, e, r, peli, this));
    }
    
    
    /**
     * Päivittää moodin JPanelin.
     * Metodi kutsutaan aina nappia painettaessa NappaintenKuuntelijassa.
     */
    public void paivitaMoodi() {
        moodi.paivitaPisteet();
        moodi.asetaNappi();
        moodi.paivitaPainettava();
        if (moodi.getKellonAika()==25) {
            this.moodi2 = new Pelimoodi2(q, w, e, r, peli, moodi.getKellonAika(), moodi.getPisteet());
            this.moodi=moodi2;
            luoKomponentit2(frame.getContentPane());
        }
        if (moodi.getKellonAika()==80) {
           this.lopetus= new LopetusMoodi(moodi.getPisteet(), this);
           this.moodi = lopetus;
           luoKomponentit3(frame.getContentPane());

        }
    }
}
