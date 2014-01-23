
package Highscore;

import java.io.File;
import java.io.FileNotFoundException;
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
    
    
    
}
