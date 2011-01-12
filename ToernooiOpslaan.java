
import java.io.*;
import java.util.*;

/**
 * De klasse <code>ToernooiOpslaan</code>
 * 
 * De klasse toernooiOpslaan maakt het mogelijk de uitslagen die zijn opgeschreven te bewaren.
 * 
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class ToernooiOpslaan {

    public static void opslaan(Toernooi toernooi) {
        
        
        String filenaam = "save.ser";
        try {
            ObjectOutputStream uit = new ObjectOutputStream( new FileOutputStream(filenaam));
            uit.writeObject(toernooi);
            uit.close();
        }
        
        catch( IOException e ) {
                    System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                    e.printStackTrace();
        } 
    }

   
      
      
}