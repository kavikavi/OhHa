
package rampytyspeli.ohjelmalogiikka.peli.pelilogiikka;


public class Peli {
    private Pisteenlaskija laskuri;
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Nappain[] nappaimet;
    
    /**
     * 
     * @param q
     * @param w
     * @param e
     * @param r 
     */
    public Peli(Nappain q, Nappain w, Nappain e, Nappain r) {
        this.laskuri = new Pisteenlaskija();
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
        this.nappaimet = new Nappain[]{q, w, e, r};
    }
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
    
    public void nostaPisteita(int maara) {
        this.laskuri.korota(maara);
    }
    
    public void vahennaPisteita() {
        this.laskuri.vahenna();
    }
    
    public int pisteet() {
       return laskuri.getPisteet();
    }
    
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
    
    public Nappain getPainettava() {
        for (Nappain nappain : nappaimet) {
            if (nappain.paina()==true) {
                return nappain;
            }
        }
        return q;
            
        
    }
    
    
    
}    
