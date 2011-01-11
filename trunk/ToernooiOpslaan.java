 


import java.io.*;
import java.util.*;

/**
 * Write a description of class ToernooiOpslaanEnLaden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ToernooiOpslaan {

    public static void main( String[] args) {
        
        Team team1 = new Team();
        
        String filenaam = "test.ser";
        try {
            ObjectOutputStream uit = new ObjectOutputStream( new FileOutputStream(filenaam));
            uit.writeObject(team);
            uit.close();
        }
        
        catch( IOException e ) {
                    System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                    e.printStackTrace();
        } 
    }

/**    private Wedstrijd wedstrijd;

        public void slaOp(int Id){
            BufferedWriter uit;
            try {
                String peer = "Toernooi.txt";
                uit = new BufferedWriter( new FileWriter( peer ));
        
                if( Id == wedstrijd.getId()) {
                    String toernooi = wedstrijd.toString();
                    uit.write(toernooi); 
                    uit.newLine();
                }
                    uit.close();
                    System.out.println( "Bestand " + peer + " is geschreven." );
            }
                catch( IOException e ) {
                    System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                    e.printStackTrace();
               } 
       }
       */
      
      
      
}