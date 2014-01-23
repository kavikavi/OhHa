
package Highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonkasittelijaTest {
    
    @Test
    public void lueTiedostoLukeeOikein() throws FileNotFoundException {
        Tiedostonkasittelija kasittelija = new Tiedostonkasittelija();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("rivi1");
        lista.add("rivi2");
        lista.add("rivi3");
        assertEquals(lista, kasittelija.lueTiedosto("src/test/java/Highscore/testi.txt"));
    }
    
    
    
}
