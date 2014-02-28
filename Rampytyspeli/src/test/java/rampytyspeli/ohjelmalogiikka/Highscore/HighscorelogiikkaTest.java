
package rampytyspeli.ohjelmalogiikka.Highscore;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class HighscorelogiikkaTest {
    
    @Test
    public void haeHighScoreToimii() throws FileNotFoundException {
        Highscorelogiikka logiikka = new Highscorelogiikka();
        Pistetulos a = new Pistetulos("Matti", 404);
        Pistetulos b = new Pistetulos("Tatti", 1337);
        Pistetulos c = new Pistetulos("Katti", 9001);
        ArrayList<Pistetulos> testi1;
        testi1 = logiikka.haeHighscore("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi3.txt");
        Pistetulos[] abc = new Pistetulos[999999];
        abc = testi1.toArray(abc);
        assertEquals(abc[0].getPisteet(), c.getPisteet());
//        assertEquals(abc[1], b);
//        assertEquals(abc[2], a);
    }
}
