
package rampytyspeli.ohjelmalogiikka.Highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tiedostonkäsittelijä
 * Käsittelee tiedostoa, jossa highscoret ovat.
 *
 */
public class Tiedostonkasittelija {
    
    /**
     * Lukee tiedoston
     * 
     * @param tiedostopolku polku tiedostoon
     * @return Palauttaa arraylistin, johon on tallennettu 
     * tiedoston jokainen rivi kerrallaan
     * 
     * @throws FileNotFoundException 
     */
    public ArrayList<String> lueTiedosto(String tiedostopolku) throws FileNotFoundException {
        ArrayList<String> pistelista = new ArrayList<String>();
        File tiedosto = new File(tiedostopolku);
        Scanner lukija = new Scanner(tiedosto);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            pistelista.add(rivi);
        }
        return pistelista;
    } 
    
    /**
     * Tallentaa tiedostoon.
     * Tallentaa jokaisen arraylistin muistipaikan omaksi rivikseen tiedostoon.
     * 
     * @param tiedostopolku polku tiedostolle
     * @param lista Tallennettava lista
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void tallennaTiedostoon(String tiedostopolku, ArrayList<String> lista) throws FileNotFoundException, IOException {
        File tiedosto = new File(tiedostopolku);
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        for (String string : lista) {
            kirjoittaja.write(string + "\n");
        }
        kirjoittaja.close();
    }
}
