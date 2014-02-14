
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;

/**
 * Peliluokka.
 * 
 * Asettaa painettavat näppäimet moodin ohjeistuksella.
 * Sisältää pelin pistelaskurin ja käsittelee sitä.
 * 
 */
public class Peli {
    private Pisteenlaskija laskuri;
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Nappain[] nappaimet;
    
    /**
     * Konstruktori.
     * Luo pistelaskurin pelille ja listan näppäimille
     * painettavuuden tutkimista varten.
     * 
     * @param q Näppäin q
     * @param w Näppäin w
     * @param e Näppäin e
     * @param r Näppäin r
     */
    public Peli(Nappain q, Nappain w, Nappain e, Nappain r) {
        this.laskuri = new Pisteenlaskija();
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
        this.nappaimet = new Nappain[]{q, w, e, r};
    }
    
    /**
     * "Painaa" nappia.
     * Hakee napilta totuusarvon, onko se painettavana ja palauttaa sen
     * eteenpäin
     * 
     * !Huom! ei käytä näppäimen nimeä hakemiseen koska tehty
     * aiemmassa vaiheessa. Muutetaan sellaiseksi jos muutetaan.
     * 
     * @param kirjain painettava nappi
     * @return palauttaa totuusarvon
     */
    public boolean paina(String kirjain) {
        switch (kirjain) {
            case "q":
                return this.q.paina();
            case "w":
                return this.w.paina();
            case "e":
                return this.e.paina();
            case "r":
                return this.r.paina();
        }
        return false;
    }
    
    /**
     * Nostaa pisteitä
     * @param maara nostettava määrä
     */
    public void nostaPisteita(int maara) {
        this.laskuri.korota(maara);
    }
    
    /**
     * Vähentää yhden pisteen
     */
    public void vahennaPisteita() {
        this.laskuri.vahenna();
    }
    
    /**
     * Pistegetteri
     * @return pisteet
     */
    public int pisteet() {
       return laskuri.getPisteet();
    }
    
    /**
     * Asettaa näppäimen painettavaksi.
     * 
     * !Huom! ei käytä näppäimen nimeä hakemiseen koska tehty
     * aiemmassa vaiheessa. Muutetaan sellaiseksi jos muutetaan.
     * 
     * @param kirjain asetettava näppäin
     */
    public void asetaPainettavaksi(String kirjain) {
        switch (kirjain) {
            case "q":
                this.q.asetaPainettavaksi();
                break;
            case "w":
                this.w.asetaPainettavaksi();
                break;
            case "e":
                this.e.asetaPainettavaksi();
                break;
            case "r":
                this.r.asetaPainettavaksi();
                break;
        }
    }
    
    /**
     * Hakee painettavan näppäimen.
     * @return painettava Nappain
     */
    public Nappain getPainettava() {
        for (Nappain nappain : nappaimet) {
            if (nappain.paina()==true) {
                return nappain;
            }
        }
        return q;
            
        
    }
    
    /**
     * Setteri pisteille.
     * @param piste 
     */
    public void asetaPisteet(int piste) {
        this.laskuri.setPisteet(piste);
    }
    
    
    
}    
