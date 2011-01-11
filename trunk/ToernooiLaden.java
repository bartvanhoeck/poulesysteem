package Model;


/**
 * Write a description of class ToernooiLaden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToernooiLaden
{
    public static void main( String[] args) {
        
        Team team1 = new Team();
        
        String filenaam = "test.ser";
        try {
            ObjectInputStream uit = new ObjectInputStream( new FileInputStream(filenaam));
            team = (Team)in.readObject();
            uit.close();
        }
        
        catch( IOException e ) {
                    System.out.println( "Fout bij het openen, maken of sluiten van het bestand." );
                    e.printStackTrace();
        } 
        
        catch( ClassNotFoundException e ){
               e.printStackTrace();
        }
    }
}
