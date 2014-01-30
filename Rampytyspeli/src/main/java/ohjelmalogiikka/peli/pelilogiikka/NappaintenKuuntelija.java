
package ohjelmalogiikka.peli.pelilogiikka;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class NappaintenKuuntelija implements KeyListener {
    
    private Nappain q;
    private Nappain w;
    private Nappain e;
    private Nappain r;
    private Peli peli;
    
    public NappaintenKuuntelija(Nappain q, Nappain w, Nappain e, Nappain r, Peli peli) {
        this.q=q;
        this.w=w;
        this.e=e;
        this.r=r;
        this.peli=peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            if (peli.paina("q") == true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            peli.asetaPainettavaksi("q"); //<---- TESTAUSTA VARTEN
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            if (peli.paina("w")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            if (peli.paina("e")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            System.out.println(peli.pisteet());
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            if (peli.paina("r")==true) {
                peli.nostaPisteita(1);
            } else {
                peli.vahennaPisteita();
            }
            System.out.println(peli.pisteet());
        }
    }
}
