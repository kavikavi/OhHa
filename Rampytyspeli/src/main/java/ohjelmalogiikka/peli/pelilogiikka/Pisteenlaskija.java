
package ohjelmalogiikka.peli.pelilogiikka;

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

    @Override
    public String toString() {
        return "" + pisteet;
    }
    
    
}
