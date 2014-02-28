
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

import org.junit.Test;
import static org.junit.Assert.*;


public class NappainTest {
    
    @Test
    public void konstruktoriAsettaapainettavuudeksiFalsen() {
        Nappain nappi = new Nappain("nappi");
        assertEquals(false, nappi.paina());
    }
    
    @Test
    public void AsetaPainettavaksiToimii() {
        Nappain nappi = new Nappain("nappi");
        nappi.asetaPainettavaksi();
        assertEquals(true, nappi.paina());
    }
    
    @Test
    public void AsetaPoisPainettavastaToimii() {
        Nappain nappi = new Nappain("nappi");
        nappi.asetaPainettavaksi();
        nappi.asetaPoisPainettavasta();
        assertEquals(false, nappi.paina());
    }
    
    @Test
    public void palauttaaNimen() {
        Nappain nappi = new Nappain("nappi");
        assertEquals("nappi", nappi.getNimi());
    }
    
    @Test
    public void palauttaaNimen2() {
        Nappain nappi = new Nappain(null);
        assertEquals(null, nappi.getNimi());
    }
    
}
