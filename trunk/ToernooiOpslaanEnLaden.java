
import java.io.*;
import java.util.*;

/**
 * Write a description of class ToernooiOpslaanEnLaden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToernooiOpslaanEnLaden {
public static void main ( String[] args ) {
{
    BufferedWriter uit;
    try {
        String peer = "Toernooi.txt";
        uit = new BufferedWriter( new FileWriter( peer ));
        
        //for(int i = 0; i <= wedstrijd.getId(); i++) {
          //String wedstrijd = wedstrijd.toString();
            //uit.write( wedstrijd );
         //   uit.newLine();
       // }
        uit.close();
        System.out.println( "Bestand " + peer + " is geschreven." );
    }
    catch( IOException e ) {
        System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
        e.printStackTrace();
    }
}
}
}


          
