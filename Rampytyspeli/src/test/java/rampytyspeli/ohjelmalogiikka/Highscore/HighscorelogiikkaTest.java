
package rampytyspeli.ohjelmalogiikka.Highscore;


import java.io.FileNotFoundException;
import rampytyspeli.ohjelmalogiikka.Highscore.Highscorelogiikka;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;


public class HighscorelogiikkaTest {
    
    
    @Test
    public void jarjestaJarjestaaOikein() {
        Highscorelogiikka logiikka = new Highscorelogiikka();
        HashMap<Integer, String> testi2 = new HashMap<Integer, String>();
        testi2.put(2, "kaks");
        testi2.put(1, "yks");
        testi2.put(3, "kol");
        logiikka.jarjesta(testi2);
        assertEquals(testi2.keySet().toArray()[0], 1);
    }
    
    @Test
    public void haeHighScoreToimii() throws FileNotFoundException {
        Highscorelogiikka logiikka = new Highscorelogiikka();
        HashMap<Integer, String> testi2 = new HashMap<Integer, String>();
        testi2.put(404, "Matti");
        testi2.put(1337, "Tatti");
        testi2.put(9001, "Katti");
        HashMap<Integer, String> testi1 = logiikka.haeHighscore("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi3.txt");
        assertEquals(testi2, testi1);
    }
}
