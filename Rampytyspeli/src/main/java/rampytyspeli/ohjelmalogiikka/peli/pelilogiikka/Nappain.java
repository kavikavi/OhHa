
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

/**
 * Näppäimen luokka.
 * Määrittää lähinnä, onko jokin tietty nappi asetettu painettavaksi.
 * 
 */
public class Nappain {
    private boolean painettava;
    private String nimi;

    /**
     * Konstruktori
     * Luodaan uusi näppäin, jolle annetaan nimi.
     * Oletuksena näppäin ei ole asetettu painettavaksi.
     * @param nimi Näppäimen nimi esim. q
     */
    public Nappain(String nimi) {
        this.painettava=false;
        this.nimi=nimi;
    }
    
    /**
     * boolean-getteri
     * @return 
     */
    public boolean paina() {
        return this.painettava;
    }
    
    /**
     * Setteri
     */
    public void asetaPainettavaksi() {
        this.painettava=true;
    }
    
    /**
     * Toinen setteri
     */
    public void asetaPoisPainettavasta() {
        this.painettava=false;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    
}
