
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Nappain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NappainTest {
    
    @Test
    public void konstruktoriAsettaapainettavuudeksiFalsen() {
        Nappain nappi = new Nappain();
        assertEquals(false, nappi.paina());
    }
    
    @Test
    public void AsetaPainettavaksiToimii() {
        Nappain nappi = new Nappain();
        nappi.asetaPainettavaksi();
        assertEquals(true, nappi.paina());
    }
    
    @Test
    public void AsetaPoisPainettavastaToimii() {
        Nappain nappi = new Nappain();
        nappi.asetaPainettavaksi();
        nappi.asetaPoisPainettavasta();
        assertEquals(false, nappi.paina());
    }
    
}
