
package rampytyspeli.ohjelmalogiikka.Highscore;

/**
 *Pistetulos.
 * Sisältää pelaajan nimen ja pisteet.
 * pistetulokset ovat vertailtavissa toisiinsa.
 */
public class Pistetulos implements Comparable<Pistetulos> {
    private String nimi;
    private int Pisteet;
    
    /**
     * Konstruktori
     * @param nimi pelaajan nimi
     * @param tulos pelaajan pistetulos
     */
    public Pistetulos(String nimi, int tulos) {
        this.Pisteet=tulos;
        this.nimi=nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return Pisteet;
    }

    @Override
    public int compareTo(Pistetulos o) {
        if (this.Pisteet==o.Pisteet) {
            return 0;
        } else if (this.Pisteet<o.Pisteet) {
            return -1;
        } else {
            return 1;
        }
    }
    
    
}
