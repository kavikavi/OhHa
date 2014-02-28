
package rampytyspeli.ohjelmalogiikka.Highscore;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        assertEquals(lista, kasittelija.lueTiedosto("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi.txt"));
    }
    
    @Test 
    public void tallennaTiedostoonTallentaaOikeinJaLueTiedostoLukeeOikein() throws FileNotFoundException, IOException {
        Tiedostonkasittelija kasittelija = new Tiedostonkasittelija();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("testi1");
        lista.add("testi2");
        lista.add("oispa kaljaa");
        kasittelija.tallennaTiedostoon("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi2.txt", lista);
        assertEquals(lista, kasittelija.lueTiedosto("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi2.txt"));
    }
    
    @Test 
    public void tallennaTiedostoonTallentaaOikeinJaLueTiedostoLukeeOikein2() throws FileNotFoundException, IOException {
        Tiedostonkasittelija kasittelija = new Tiedostonkasittelija();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("jou");
        lista.add("yo");
        lista.add("aivanhelvetinpitkäsana AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        kasittelija.tallennaTiedostoon("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi2.txt", lista);
        assertEquals(lista, kasittelija.lueTiedosto("src/test/java/rampytyspeli/ohjelmalogiikka/Highscore/testi2.txt"));
    }
    
    
    
}
