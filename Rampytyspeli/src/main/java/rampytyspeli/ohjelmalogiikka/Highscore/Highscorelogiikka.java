
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
     * * Hakee tiedostonkäsittelijällä pisteet 
     * ja muuttaa ne liikuteltavaan muotoon. 
     * @param polku tiedostopolku (piti laittaa tähänkin testausta varten)
     * @return palauttaa pisteet ja nimet hashmapissa
     * @throws FileNotFoundException 
     */
    public HashMap<Integer, String> haeHighscore(String polku) throws FileNotFoundException {
        HashMap<Integer, String> pisteet = new HashMap<Integer, String>();
        for (String s : kasittelija.lueTiedosto(polku)) {
            String[] osat = s.split(":");
            int piste = Integer.parseInt(osat[0]);
            pisteet.put(piste, osat[1]);
        }
        jarjesta(pisteet);
        return pisteet;
    }
    
    /**
     * Järjestysmetodi, asettaa pisteet suuruusjärjestykseen hashmapissa.
     * Kutsutaan aina pisteitä haettaessa.
     * 
     * @param mappi Järjestettävä hashmap.
     * @return 
     */
    public HashMap<Integer, String> jarjesta(HashMap<Integer, String> mappi) {
        ArrayList<Integer> pistelista = new ArrayList<Integer>();
        for (Integer integer : mappi.keySet()) {
            pistelista.add(integer);
        }
        Collections.sort(pistelista);
        HashMap<Integer, String> jarjestetty = new HashMap<Integer, String>();
        for (Integer integer : pistelista) {
            jarjestetty.put(integer, mappi.get(integer));
        }
        return jarjestetty;
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
    public void tallennaUusitulos(String nimi, Integer pisteet, String polku) throws FileNotFoundException, IOException {
        HashMap<Integer, String> pistelista = haeHighscore(polku);
        pistelista.put(pisteet, nimi);
        ArrayList<String> tallennettava = new ArrayList<String>();
        for (Integer integer : pistelista.keySet()) {
            tallennettava.add(integer + ":" + pistelista.get(integer));
        }
        kasittelija.tallennaTiedostoon(polku, tallennettava);
    }
}
