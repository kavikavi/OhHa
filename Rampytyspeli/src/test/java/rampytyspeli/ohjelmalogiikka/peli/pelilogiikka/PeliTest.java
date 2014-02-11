
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Peli;
import rampytyspeli.ohjelmalogiikka.peli.pelilogiikka.Nappain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliTest {
    
    @Test
    public void peliLuoNappaimetFalseiksi() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        assertEquals(false, peli.paina("q"));
        assertEquals(false, peli.paina("w"));
        assertEquals(false, peli.paina("e"));
        assertEquals(false, peli.paina("r"));
    }
    
    @Test
    public void peliNostaaJaLaskeePisteitaOikein() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.nostaPisteita(5);
        peli.vahennaPisteita();
        assertEquals(4, peli.pisteet());
    }
    
    public void peliNostaaJaLaskeePisteitaOikein2() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.nostaPisteita(2);
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        assertEquals(0, peli.pisteet());
    }
    
    public void asetaPainettavaksiToimii1() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("q");
        assertEquals(true, peli.paina("q"));
    }
    
    public void asetaPainettavaksiToimii2() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("w");
        assertEquals(true, peli.paina("w"));
    }
    
    public void asetaPainettavaksiToimii3() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("e");
        assertEquals(true, peli.paina("e"));
    }
    
    public void asetaPainettavaksiToimii4() {
        Nappain q = new Nappain();
        Nappain w = new Nappain();
        Nappain e = new Nappain();
        Nappain r = new Nappain();
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("r");
        assertEquals(true, peli.paina("r"));
    }
    
}
