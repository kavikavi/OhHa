
package ohjelmalogiikka.Highscore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Highscorelogiikka {
    private Tiedostonkasittelija kasittelija;
    
    public Highscorelogiikka() {
        this.kasittelija= new Tiedostonkasittelija();
    }
    
    public HashMap<Integer, String> haeHighscore() throws FileNotFoundException {
        HashMap<Integer, String> pisteet = new HashMap<Integer, String>();
        for (String s : kasittelija.lueTiedosto("src/main/java/ohjelmalogiikka/Highscore/Highscore.txt")) {
            String[] osat = s.split(":");
            int piste = Integer.parseInt(osat[0]);
            pisteet.put(piste, osat[1]);
        }
        jarjesta(pisteet);
        return pisteet;
    }
    
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
    
    public void tallennaUusitulos(String nimi, Integer pisteet) throws FileNotFoundException, IOException {
        HashMap<Integer, String> pistelista = haeHighscore();
        pistelista.put(pisteet, nimi);
        ArrayList<String> tallennettava = new ArrayList<String>();
        for (Integer integer : pistelista.keySet()) {
            tallennettava.add(integer + ":" + pistelista.get(integer));
        }
        kasittelija.tallennaTiedostoon("src/main/java/ohjelmalogiikka/Highscore/Highscore.txt", tallennettava);
    }
    
    
    
}
