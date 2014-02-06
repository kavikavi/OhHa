
package ohjelmalogiikka.Highscore;


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
    
    
}
