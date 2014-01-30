
package ohjelmalogiikka.peli.pelilogiikka;


public class Nappain {
    private boolean painettava;

    public Nappain() {
        this.painettava=false;
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
    
    
}
