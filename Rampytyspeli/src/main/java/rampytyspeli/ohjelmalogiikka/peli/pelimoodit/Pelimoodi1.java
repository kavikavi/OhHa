
package rampytyspeli.ohjelmalogiikka.peli.pelimoodit;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Nappain;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Peli;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Pisteenlaskija;

public class Pelimoodi1 extends JPanel {
    
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
    private Timer kello;
    private TimerTask joku;
    private Random random;
    private JLabel pisteet;
    private JLabel aika;
    private Pisteenlaskija kellotaulu;
    
    public Pelimoodi1(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli) {
        super(new BorderLayout());
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.kellotaulu = new Pisteenlaskija();
        this.peli=peli;
        this.aika = new JLabel("Aikaa mennyt: 0");
        this.pisteet = new JLabel("Pisteet: " + this.peli.pisteet());
        this.random = new Random();
        this.kello= new Timer();
        luoKomponentit("Moodi: " + random.nextInt());
        
        
        this.joku = new TimerTask() {

            @Override
            public void run() {
//                pisteet.setText(random.nextInt()+"");
                aika.setText("Aikaa mennyt: " + kellotaulu.getPisteet());
                paivitaKello();
            }
        };
        kello.scheduleAtFixedRate(joku, 0, 1000);
        
        
        
    }

    private void luoKomponentit(String keski) {
        add(new JLabel(keski), BorderLayout.CENTER);
        add(pisteet, BorderLayout.SOUTH);
        add(aika, BorderLayout.EAST);
    }
    
    public void paivitaPisteet() {
        pisteet.setText("Pisteet: "+peli.pisteet());
    }
    
    public void paivitaKello() {
        this.kellotaulu.korota(1);
    }
    
    

    
}
