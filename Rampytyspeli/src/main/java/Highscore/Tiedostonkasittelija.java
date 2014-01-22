
package Highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tiedostonkasittelija {
    
    
    public ArrayList<String> lueHighscore() throws FileNotFoundException {
        ArrayList<String> pistelista = new ArrayList<String>();
        File pistetiedosto = new File("src/main/java/Highscore/Highscore.txt");
        Scanner lukija = new Scanner(pistetiedosto);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            pistelista.add(rivi);
        }
        return pistelista;
    } 
    
    
}
