
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

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
    private Pelimoodi1 moodi1;
    
    

    public Kayttoliittyma() {
        this.q = new Nappain();
        this.w = new Nappain();
        this.e = new Nappain();
        this.r = new Nappain();
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
    
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        container.add(moodi1);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    private void lisaaKuuntelijat() {
        frame.addKeyListener(new NappaintenKuuntelija(q, w, e, r, peli, this));
    }
    
    public void paivitaMoodi() {
        moodi1.paivitaPisteet();
    }
}
