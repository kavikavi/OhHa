
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

/**
 * "Toinen" pelimoodi.
 * 
 * Koska pelimoodirakennetta ei saatu toimimaan suunnitellusti, 
 * on tähän luokkaan rakennettu 2. ja 3. moodi.
 * 
 */
public class Pelimoodi2 extends JPanel implements Pelimoodi {
    
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
    private Nappain nappi3;
    private Nappain nappi4;
    private Font font;
    private JLabel moodi;
    private JLabel jarjestys;
    
    /**
     * Konstruktori.
     * 
     * Asettaa JLabeleille niiden alkusisällöt, luo randomit ja 
     * fontit jne.
     * 
     * Luo komponentit.
     * 
     * Luo ja sisältää myös timertaskin: Joka sekunti
     * kellon lukema nousee yhdellä ja aina kahdeksan sekunnin välein
     * asetetaan uudet painettavat näppäimet.
     * 
     * @param q Näppäin q
     * @param w Näppäin w
     * @param e Näppäin e
     * @param r Näppäin r
     * @param peli Peli, jolle moodi toimii.
     */
    public Pelimoodi2(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli, int kellonaika, int pisteet) {
        super(new BorderLayout());
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.font = new Font(SANS_SERIF, PLAIN, 20);
        this.napit = new Nappain[]{q, w, e, r};
        this.kellotaulu = new Pisteenlaskija();
        this.peli=peli;
        this.jarjestys = new JLabel();
        this.random = new Random();
        this.aika = new JLabel("Aikaa mennyt: " + kellotaulu.getPisteet());
        this.pisteet = new JLabel("Pisteet: " + this.peli.pisteet());
        this.painettava = new JLabel("Paina: " + this.peli.getPainettava().getNimi());
        this.kello= new Timer();
        this.kellotaulu.setPisteet(kellonaika);
        this.peli.asetaPisteet(pisteet);
        luoKomponentit();
        uusiSarja1();
        asetaNappi1();
        
        
        this.joku = new TimerTask() {

            @Override
            public void run() {
                aika.setText("Aikaa mennyt: " + kellotaulu.getPisteet());
                
                if (kellotaulu.getPisteet()==80) {
                    return;
                }
                
                if (kellotaulu.getPisteet()%8==0) {
                    uusiSarja();
                }
                paivitaKello();
            }
        };
        kello.scheduleAtFixedRate(joku, 0, 1000);
        
    }

    /**
     * Luo komponentit JPanelille.
     * Konstruktori käyttää metodia.
     * JLabelit laitetaan paikoilleen ja 
     * niille asetetaan fontti.
     */
    public void luoKomponentit() {
        add(jarjestys, BorderLayout.CENTER);
        add(pisteet, BorderLayout.SOUTH);
        add(aika, BorderLayout.EAST);
        add(painettava, BorderLayout.NORTH);
        aika.setFont(font);
        pisteet.setFont(font);
        painettava.setFont(font);
        jarjestys.setFont(font);
    }
    
    /**
     * Päivittää pistemäärän ruudulla.
     */
    public void paivitaPisteet() {
        pisteet.setText("Pisteet: "+peli.pisteet());
    }
    
    /**
     * Nostaa kellon lukemaa yhdellä.
     * 
     * Kellona käytetään nerokkaasti pisteenlaskijaa.
     */
    public void paivitaKello() {
        this.kellotaulu.korota(1);
    }
    
    /**
     * Määrittää eron 2. ja 3. moodin välillä: ennen 56. sekuntia
     * on moodi 2 ja sen jälkeen moodi 3.
     */
    public void uusiSarja() {
        if (this.kellotaulu.getPisteet()<56) {
            uusiSarja1();
        } else {
            uusiSarja2();
        }
    }
    
    /**
     * Arpoo uuden kolmen napin sarjan.
     * Käytännössä: moodilla on aina kolme näppäintä, joita
     * pelaajan tulee hakata vuorotellen. Esim: q -> e ->w -> q -> e...
     * Tämä metodi luo siis uuden tällaisen sarjan.
     * Napit valitaan satunnaisesti neljän paikan listasta,
     * johon napit on laitettu.
     * Kolme nappia eivät voi olla samat.
     * 
     */
    public void uusiSarja1() {
        nappi1 = this.napit[random.nextInt(4)];
        while (true) {
            nappi2 = this.napit[random.nextInt(4)];
            if (nappi1!=nappi2) {
                nappi3 = this.napit[random.nextInt(4)];
                if (nappi3!=nappi2 && nappi3!= nappi1) {
                    this.jarjestys.setText("Järjestys: " + nappi1.getNimi()
                            + ", " + nappi2.getNimi() + ", " + nappi3.getNimi());
                    break;
                }
            }
        }
    }
    
    /**
     * Arpoo uuden neljän napin sarjan.
     * Käytännössä: moodilla on aina neljä näppäintä, joita
     * pelaajan tulee hakata vuorotellen. Esim: q -> e ->w -> r -> q...
     * Tämä metodi luo siis uuden tällaisen sarjan.
     * Napit valitaan satunnaisesti neljän paikan listasta,
     * johon napit on laitettu.
     * Neljä nappia eivät voi olla samat.
     */
    public void uusiSarja2() {
        nappi1 = this.napit[random.nextInt(4)];
        while (true) {
            nappi2 = this.napit[random.nextInt(4)];
            if (nappi1!=nappi2) {
                nappi3 = this.napit[random.nextInt(4)];
                if (nappi3!=nappi2 && nappi3!= nappi1) {
                    nappi4 = this.napit[random.nextInt(4)];
                    if (nappi4!=nappi3 && nappi4!=nappi2 && nappi4!=nappi1) {
                        this.jarjestys.setText("Järjestys: " + nappi1.getNimi()
                                + ", " + nappi2.getNimi() + ", " + nappi3.getNimi() + ", " + this.nappi4.getNimi());
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Määrittää eron 2. ja 3. moodin välillä
     * napin asetuksessa, kuten uusiSarja()
     */
    public void asetaNappi() {
        if (this.kellotaulu.getPisteet()<57) {
            asetaNappi1();
        } else {
            asetaNappi2();
        }
    }
    
    /**
     * Tietty nappi asetetaan painettavaksi.
     * 
     * Tässä moodissa metodi asettaa kolmea nappia vuorotellen.
     */
    public void asetaNappi1() {
        
        if (peli.getPainettava()==nappi1) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi2.getNimi());
        } else if (peli.getPainettava()==nappi2) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi3.getNimi());
        } else {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi1.getNimi());
        }
        paivitaPainettava();
    }
    
     /**
     * Tietty nappi asetetaan painettavaksi.
     * 
     * Tässä moodissa metodi asettaa neljä nappia vuorotellen.
     */
    public void asetaNappi2() {
        if (peli.getPainettava()==nappi1) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi2.getNimi());
        } else if (peli.getPainettava()==nappi2) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi3.getNimi());
        } else if (peli.getPainettava()==nappi3) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi4.getNimi());
        } else {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi1.getNimi());
        }
        paivitaPainettava();
    }
    
    
    
    /**
     * Painettava nappi päivitetään ruudulle.
     */
    public void paivitaPainettava() {
        this.painettava.setText("Paina: " + this.peli.getPainettava().getNimi());
    }
    
    
    public int getKellonAika() {
        return this.kellotaulu.getPisteet();
    }
    
    public int getPisteet() {
        return this.peli.pisteet();
    }
    
}
