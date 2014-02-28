
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

import org.junit.Test;
import static org.junit.Assert.*;


public class PeliTest {
    
    @Test
    public void peliLuoNappaimetFalseiksi() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        assertEquals(false, peli.paina("q"));
        assertEquals(false, peli.paina("w"));
        assertEquals(false, peli.paina("e"));
        assertEquals(false, peli.paina("r"));
    }
    
    @Test
    public void painaToimii() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("w");
        assertEquals(false, peli.paina("t"));
    }
    
    @Test
    public void peliNostaaJaLaskeePisteitaOikein() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.nostaPisteita(5);
        peli.vahennaPisteita();
        assertEquals(4, peli.pisteet());
    }
    
    
    @Test
    public void peliNostaaJaLaskeePisteitaOikein2() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.nostaPisteita(2);
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        peli.vahennaPisteita();
        assertEquals(0, peli.pisteet());
    }
    
    @Test
    public void asetaPainettavaksiToimii1() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("q");
        assertEquals(true, peli.paina("q"));
    }
    
    @Test
    public void asetaPainettavaksiToimii2() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("w");
        assertEquals(true, peli.paina("w"));
    }
    
    @Test
    public void asetaPainettavaksiToimii3() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("e");
        assertEquals(true, peli.paina("e"));
    }
    
    @Test
    public void asetaPainettavaksiToimii4() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("r");
        assertEquals(true, peli.paina("r"));
    }
    
    
    @Test
    public void getPainettavaToimii() {
        Nappain q = new Nappain("q");
        Nappain w = new Nappain("w");
        Nappain e = new Nappain("e");
        Nappain r = new Nappain("r");
        Peli peli = new Peli(q,w,e,r);
        peli.asetaPainettavaksi("r");
        assertEquals(r, peli.getPainettava());
    }
    
}
