
package rampytyspeli.ohjelmalogiikka.peli.pelimoodit;

import java.awt.BorderLayout;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;
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
    private Nappain[] napit;
    private Peli peli;
    private Timer kello;
    private TimerTask joku;
    private Random random;
    private JLabel pisteet;
    private JLabel aika;
    private JLabel painettava;
    private Pisteenlaskija kellotaulu;
    private Nappain nappi1;
    private Nappain nappi2;
    private Font font;
    private JLabel moodi;
    
    
    public Pelimoodi1(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli) {
        super(new BorderLayout());
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.font = new Font(SANS_SERIF, PLAIN, 20);
        this.napit = new Nappain[]{q, w, e, r};
        this.kellotaulu = new Pisteenlaskija();
        this.peli=peli;
        this.random = new Random();
        this.aika = new JLabel("Aikaa mennyt: 0");
        this.pisteet = new JLabel("Pisteet: " + this.peli.pisteet());
        this.painettava = new JLabel("Paina: " + this.peli.getPainettava().getNimi());
        this.moodi = new JLabel("Moodi: " + random.nextInt());
        this.kello= new Timer();
        luoKomponentit();
        
        
        this.joku = new TimerTask() {

            @Override
            public void run() {
                aika.setText("Aikaa mennyt: " + kellotaulu.getPisteet());
                
                if (kellotaulu.getPisteet()%5==0) {
                    uusiKahdenNapinSarja();
                }
                paivitaKello();
            }
        };
        kello.scheduleAtFixedRate(joku, 0, 1000);
        
        
        
    }

    private void luoKomponentit() {
        add(moodi, BorderLayout.CENTER);
        add(pisteet, BorderLayout.SOUTH);
        add(aika, BorderLayout.EAST);
        add(painettava, BorderLayout.NORTH);
        aika.setFont(font);
        pisteet.setFont(font);
        painettava.setFont(font);
        moodi.setFont(font);
    }
    
    public void paivitaPisteet() {
        pisteet.setText("Pisteet: "+peli.pisteet());
    }
    
    public void paivitaKello() {
        this.kellotaulu.korota(1);
    }
    
    public void uusiKahdenNapinSarja() {
        nappi1 = this.napit[random.nextInt(4)];
        while (true) {
            nappi2 = this.napit[random.nextInt(4)];
            if (nappi1!=nappi2) {
                break;
            }
        }
    }
    
    public void asetaNappi() {
        
        if (peli.getPainettava()==nappi1) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi2.getNimi());
        }
        
        else {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi1.getNimi());
        }
    }
    
    public void paivitaPainettava() {
        this.painettava.setText("Paina: " + this.peli.getPainettava().getNimi());
    }
    
    public int getKellonAika() {
        return this.kellotaulu.getPisteet();
    }
    
    
    
    
    

    
}
