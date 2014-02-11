
package rampytyspeli.ohjelmalogiikka.Highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tiedostonkasittelija {
    
    
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
    
    public void tallennaTiedostoon(String tiedostopolku, ArrayList<String> lista) throws FileNotFoundException, IOException {
        File tiedosto = new File(tiedostopolku);
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        for (String string : lista) {
            kirjoittaja.write(string + "\n");
        }
        kirjoittaja.close();
    }
    
    
    
    
    
}
