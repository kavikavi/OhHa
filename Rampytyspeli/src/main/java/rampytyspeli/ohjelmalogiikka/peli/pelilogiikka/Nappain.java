
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;


public class Nappain {
    private boolean painettava;
    private String nimi;

    public Nappain(String nimi) {
        this.painettava=false;
        this.nimi=nimi;
    }
    
    public boolean paina() {
        return this.painettava;
    }
    
    public void asetaPainettavaksi() {
        this.painettava=true;
    }
    
    public void asetaPoisPainettavasta() {
        this.painettava=false;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    
}
