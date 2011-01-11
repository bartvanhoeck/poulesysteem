
import java.io.*;
import java.util.*;

/**
 * Write a description of class ToernooiLaden here.
 * 
 * @author Kenny Ekkelboom 
 * @version (a version number or a date)
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
