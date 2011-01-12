
import java.io.*;
import java.util.*;

/**
 * De klasse <code>ToernooiLaden</code>
 * 
 * Deze klasse zorgt ervoor dat het mogelijk is om een bestaand toernooi met zijn resultaten op te slaan.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */
public class ToernooiLaden
{
    public static Toernooi laden() {
        Toernooi toernooi = null;     
        String filenaam = "save.ser";
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(filenaam));
            toernooi = (Toernooi)in.readObject();
            in.close();
            
        }
        
        catch( IOException e ) {
                System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                e.printStackTrace();
        } 
        
        catch( ClassNotFoundException e ){
                System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                e.printStackTrace();
        }
        
        return toernooi;
        
        
    }
}
