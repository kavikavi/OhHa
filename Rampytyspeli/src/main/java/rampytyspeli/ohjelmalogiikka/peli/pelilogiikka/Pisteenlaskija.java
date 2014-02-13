
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

public class Pisteenlaskija {
    private int pisteet;
    
    public Pisteenlaskija() {
        this.pisteet=0;
    }
    
    public void korota(int maara) {
        this.pisteet += maara;
    }
    
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
