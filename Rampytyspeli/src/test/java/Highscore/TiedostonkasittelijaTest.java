
package Highscore;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonkasittelijaTest {
    
    @Test
    public void lueHighscoreLukeeOikein() throws FileNotFoundException {
        Tiedostonkasittelija kasittelija = new Tiedostonkasittelija();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("rivi1");
        lista.add("rivi2");
        lista.add("rivi3");
        assertEquals(lista, kasittelija.lueHighscore());
    }
    
    
    
}
