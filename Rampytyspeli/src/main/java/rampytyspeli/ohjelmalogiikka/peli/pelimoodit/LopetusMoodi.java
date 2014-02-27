/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rampytyspeli.ohjelmalogiikka.peli.pelimoodit;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JTextField;
import rampytyspeli.Kayttoliittyma.Kayttoliittyma;
import rampytyspeli.ohjelmalogiikka.Highscore.Highscorelogiikka;
import rampytyspeli.ohjelmalogiikka.PisteidenLisaysListener;

/**
 *Viimeinen "moodi", joka oikeastaan on vain lopetusikkuna.
 *Ikkunassa pelaaja voi tallentaa tuloksensa highscorelistalle.
 * 
 */
public class LopetusMoodi extends JPanel implements Pelimoodi {
    
    private int pisteet;
    private JLabel viesti;
    private JLabel viesti1;
    private JLabel viesti2;
    private JLabel viesti3;
    private JTextField kirjoitus;
    private JButton ok;
    private Font font1;
    private Font font2;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori.
     * Kutsuu metodeja luoKomponentit ja isaaListener.
     * @param piste pistemäärä
     * @param kayttis 
     */
    public LopetusMoodi(int piste, Kayttoliittyma kayttis) {
        super(new GridLayout(6,1));
        this.pisteet=piste;
        this.kayttis = kayttis;
        this.font1 = new Font(SANS_SERIF, PLAIN, 20);
        this.font2= new Font(SANS_SERIF, PLAIN, 16);
        luoKomponentit();
        lisaaListener();
        
    }
    
    /**
     *Luodaan komponentit.
     *Itse komponentit, niille fontit ja sijainnit.
     */
    @Override
    public void luoKomponentit() {
        this.viesti=new JLabel("Onneksi olkoon!");
        this.viesti1=new JLabel("Tuloksesi on " + pisteet + " pistettä.");
        this.viesti2=new JLabel("Aseta nimesi ja paina Jatka tallentaaksesi tuloksesi.");
        this.viesti3=new JLabel("Jos jätät nimikentän tyhjäksi, tulostasi ei tallenneta.");
        this.kirjoitus = new JTextField("Nimi tähän");
        this.ok = new JButton("Jatka");
        this.viesti.setFont(font2);
        this.viesti1.setFont(font2);
        this.viesti2.setFont(font2);
        this.viesti3.setFont(font2);
        this.kirjoitus.setFont(font1);
        this.ok.setFont(font1);
        add(viesti);
        add(viesti1);
        add(viesti2);
        add(viesti3);
        add(kirjoitus);
        add(ok);
    }
    
    /**
     * Lisää kuuntelijan nappiin.
     */
    public void lisaaListener() {
        PisteidenLisaysListener k = new PisteidenLisaysListener(kirjoitus, pisteet, kayttis);
        this.ok.addActionListener(k);
    }
    
    
    
    

    @Override
    public void paivitaPisteet() {
        
    }

    @Override
    public void paivitaKello() {
        
    }

    @Override
    public void uusiSarja() {
        
    }

    @Override
    public void asetaNappi() {
        
    }

    @Override
    public void paivitaPainettava() {
        
    }

    @Override
    public int getKellonAika() {
        return 0;
    }

    @Override
    public int getPisteet() {
        return pisteet;
    }
    
}
