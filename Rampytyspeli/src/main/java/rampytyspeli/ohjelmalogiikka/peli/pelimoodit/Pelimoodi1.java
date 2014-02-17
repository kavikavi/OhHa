
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
 * Ensimmäinen pelimoodi.
 * 
 * Luokalle tullaan tekemään todennäköisesti yläluokka,
 * ettei jokaisen pelimoodin kohdalla tarvitsisi katsoa
 * tällaista rivihelvettiä.
 * 
 */
public class Pelimoodi1 extends JPanel implements Pelimoodi {
    
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
     * kellon lukema nousee yhdellä ja aina viiden sekunnin välein
     * asetetaan uudet painettavat näppäimet.
     * 
     * @param q Näppäin q
     * @param w Näppäin w
     * @param e Näppäin e
     * @param r Näppäin r
     * @param peli Peli, jolle moodi toimii.
     */
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
        this.jarjestys = new JLabel();
        this.random = new Random();
        this.aika = new JLabel("Aikaa mennyt: 0");
        this.pisteet = new JLabel("Pisteet: " + this.peli.pisteet());
        this.painettava = new JLabel("Paina: " + this.peli.getPainettava().getNimi());
        this.moodi = new JLabel("Moodi: 1");
        this.kello= new Timer();
        luoKomponentit();
        
        
        this.joku = new TimerTask() {

            @Override
            public void run() {
                aika.setText("Aikaa mennyt: " + kellotaulu.getPisteet());
                
                if (kellotaulu.getPisteet()==25) {
                    return;
                }
                
                if (kellotaulu.getPisteet()%5==0) {
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
     * Arpoo uuden kahden napin sarjan.
     * Käytännössä: moodilla on aina kaksi näppäintä, joita
     * pelaajan tulee hakata vuorotellen. Esim: q -> e -> q -> e...
     * Tämä metodi luo siis uuden tällaisen sarjan.
     * Napit valitaan satunnaisesti neljän paikan listasta,
     * johon napit on laitettu.
     * Kaksi nappia eivät voi olla samat.
     * 
     * Tulevilla moodeilla vastaava metodi arpoo eri määrän nappeja
     * tai tekee jotain muuta jännittävää.
     * 
     */
    public void uusiSarja() {
        nappi1 = this.napit[random.nextInt(4)];
        while (true) {
            nappi2 = this.napit[random.nextInt(4)];
            if (nappi1!=nappi2) {
                this.jarjestys.setText("Järjestys: " + nappi1.getNimi()
                            + ", " + nappi2.getNimi());
                break;
            }
        }
    }
    
    /**
     * Tietty nappi asetetaan painettavaksi.
     * 
     * Tässä moodissa metodi asettaa kahta nappia vuorotellen.
     */
    public void asetaNappi() {
        
        if (peli.getPainettava()==nappi1) {
            for (Nappain nappain : napit) {
                nappain.asetaPoisPainettavasta();
            }
            peli.asetaPainettavaksi(nappi2.getNimi());
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
