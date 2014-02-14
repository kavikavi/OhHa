
package rampytyspeli.ohjelmalogiikka.peli.pelimoodit;



/**
 * Rajapinta pelimoodeille.
 * 
 */
public interface Pelimoodi {
    public void luoKomponentit();
    public void paivitaPisteet();
    public void paivitaKello();
    public void uusiSarja();
    public void asetaNappi();
    public void paivitaPainettava();
    public int getKellonAika();
    public int getPisteet();
    
}
