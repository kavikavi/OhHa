
package rampytyspeli.Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Peli;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Nappain;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.NappaintenKuuntelija;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Peli;
import rampytyspeli.ohjelmalogiikka.peli.pelimoodit.Pelimoodi1;
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
        this.moodi1= new Pelimoodi1(q, w, e, r, peli);
        
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
     * Luo komponentit framelle, eli ts. lisää moodin.
     * @param container 
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        container.add(moodi1);
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
        moodi1.paivitaPisteet();
        moodi1.asetaNappi();
        moodi1.paivitaPainettava();
    }
}
