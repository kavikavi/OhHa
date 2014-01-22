
package peli.pelilogiikka;

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
    
}
