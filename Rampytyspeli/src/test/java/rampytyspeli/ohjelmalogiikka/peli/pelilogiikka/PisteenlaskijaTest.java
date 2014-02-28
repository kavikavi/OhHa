
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

import static org.junit.Assert.*;
import org.junit.Test;


public class PisteenlaskijaTest {
    
    
    @Test
    public void konstruktoriAsettaapisteiksiNollan() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        int pisteet = pisteenlaskija.getPisteet();
        assertEquals(0, pisteet);
    }
    
    @Test
    public void korotaKorottaaOikeanMaaran1() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.korota(1);
        int pisteet = pisteenlaskija.getPisteet();
        assertEquals(1, pisteet);
    }
    
    @Test
    public void korotaKorottaaOikeanMaaran2() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.korota(3);
        pisteenlaskija.korota(2);
        pisteenlaskija.korota(1);
        int pisteet = pisteenlaskija.getPisteet();
        assertEquals(6, pisteet);
    }
    
    @Test
    public void vahennaVahentaaOikeanMaaran() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.korota(5);
        pisteenlaskija.vahenna();
        pisteenlaskija.vahenna();
        pisteenlaskija.vahenna();
        int pisteet = pisteenlaskija.getPisteet();
        assertEquals(2, pisteet);
    }
    
    @Test
    public void vahennaEiVieNollanAlle() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.korota(1);
        pisteenlaskija.vahenna();
        pisteenlaskija.vahenna();
        pisteenlaskija.vahenna();
        int pisteet = pisteenlaskija.getPisteet();
        assertEquals(0, pisteet);
    }
    
    @Test
    public void setPisteetToimii() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.setPisteet(50);
        pisteenlaskija.korota(2);
        assertEquals(52, pisteenlaskija.getPisteet());
    }
    
    @Test
    public void toStringToimii() {
        Pisteenlaskija pisteenlaskija = new Pisteenlaskija();
        pisteenlaskija.setPisteet(50);
        assertEquals("50", pisteenlaskija.toString());
    }
    
}
