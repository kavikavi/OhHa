
package ohjelmalogiikka.peli.pelimoodit;

import java.awt.BorderLayout;
import java.util.Timer;
import java.awt.Container;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ohjelmalogiikka.peli.pelilogiikka.Nappain;
import ohjelmalogiikka.peli.pelilogiikka.NappaintenKuuntelija;
import ohjelmalogiikka.peli.pelilogiikka.Peli;

public class Pelimoodi1 extends JPanel {
    
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
//    private Timer kello;
//    private TimerTask joku;
    private Random random;
    
    public Pelimoodi1(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli) {
        super(new BorderLayout());
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.peli=peli;
        this.random = new Random();
//        this.kello= new Timer();
        luoKomponentit("Moodi: " + random.nextInt());
        
//        kello.scheduleAtFixedRate(joku, 5000, 5000);
//        this.joku = new TimerTask() {
//
//            @Override
//            public void run() {
//                luoKomponentit("" + random.nextInt());
//            }
//        };
        
        
        
    }

    private void luoKomponentit(String keski) {
        add(new JLabel(keski), BorderLayout.CENTER);
        add(new JLabel(peli.pisteet() + ""), BorderLayout.SOUTH);
    }
    
    
    

    
}
