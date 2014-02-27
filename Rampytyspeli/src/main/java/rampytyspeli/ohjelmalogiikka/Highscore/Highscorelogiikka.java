
package rampytyspeli.ohjelmalogiikka.Highscore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Highscorelogiikka, eli pisteiden muovaaminen
 * katseltavaan muotoon.
 * Pisteiden hakeminen tiedostosta tapahtuu tiedostonkasittelijassa.
 * 
 */
public class Highscorelogiikka {
    private Tiedostonkasittelija kasittelija;
    
    /**
     * Konstruktori
     */
    public Highscorelogiikka() {
        this.kasittelija= new Tiedostonkasittelija();
    }
    
    /**
     * * Hakee tiedostonkäsittelijällä pisteet, järjestää ne
     * ja muuttaa ne liikuteltavaan muotoon. 
     * @param polku tiedostopolku
     * @return palauttaa järjestetyn listan tuloksista
     * @throws FileNotFoundException 
     */
    public ArrayList<Pistetulos> haeHighscore(String polku) throws FileNotFoundException {
        ArrayList<Pistetulos> pisteet = new ArrayList<>();
        for (String s : kasittelija.lueTiedosto(polku)) {
            String[] osat = s.split(":");
            int piste = Integer.parseInt(osat[0]);
            pisteet.add(new Pistetulos(osat[1], piste));
        }
        Collections.sort(pisteet);
        Collections.reverse(pisteet);
        return pisteet;
    }
    
    
    /**
     * /**
     * Tallentaa uuden pistetuloksen.
     * 
     * @param nimi pelaajan nimi
     * @param pisteet pelaajan pisteet
     * @param polku tiedostopolku
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void tallennaUusitulos(String nimi, int pisteet, String polku) throws FileNotFoundException, IOException {
        ArrayList<Pistetulos> pistelista = haeHighscore(polku);
        pistelista.add(new Pistetulos(nimi, pisteet));
        ArrayList<String> tallennettava = new ArrayList<String>();
        for (Pistetulos tulos : pistelista) {
            tallennettava.add(tulos.getPisteet() +":"+ tulos.getNimi());
        }
        kasittelija.tallennaTiedostoon(polku, tallennettava);
    }
}
