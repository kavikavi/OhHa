
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

/**
 * Pisteenlaskijakuokka.
 * 
 * Tunnetaan nimellä laskuri.
 */
public class Pisteenlaskija {
    private int pisteet;
    
    /**
     * Konstruktori.
     * 
     * Asettaa pisteet oletuksena nollaan.
     */
    public Pisteenlaskija() {
        this.pisteet=0;
    }
    
    /**
     * Nostaa pistemäärää.
     * @param maara nostettava määrä
     */
    public void korota(int maara) {
        this.pisteet += maara;
    }
    
    /**
     * Vähentää pisteitä yhdellä
     */
    public void vahenna() {
        this.pisteet--;
        if (this.pisteet<0) {
            this.pisteet=0;
        }
    }

    public int getPisteet() {
        return pisteet;
    }
    
    public void setPisteet(int piste) {
        this.pisteet=piste;
    }

    @Override
    public String toString() {
        return "" + pisteet;
    }
    
}
