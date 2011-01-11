
import java.io.*;
import java.util.*;

/**
 * Write a description of class ToernooiOpslaanEnLaden here.
 * 
 * @author Kenny Ekkelboom 
 * @version (a version number or a date)
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