import java.util.*;
import java.io.*;

/**
 * De klasse <code>Knockout</code>
 *
 *De knockoutklasse regelt de knockout toernooien
 *Hier word bijgehouden welke wedstrijden moeten worden gespeeld en hoeveel teams en poules er zijn
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class Knockout implements Serializable{

    // Attributen
    private ArrayList<Wedstrijd> wedstrijden;
    private KnockoutFase knockoutfase;
    
    /**
     * De constructor <code>Knockout()</code> Maakt een nieuwe knockout fase aan.
     * Tevens initialiseerd hij de arraylist Wedstrijd
     */
    
    // Constructor
    public Knockout(KnockoutFase knockoutfase){
        wedstrijden = new ArrayList <Wedstrijd>();
        this.knockoutfase = knockoutfase;
    }
    
    // Methoden
    
    /**
     * De methode <code>addWedstrijd()</code> word gebruikt om wedstrijden toe te voegen tussen teams.
     */
    
    public void addWedstrijd(Wedstrijd wedstrijd){
        wedstrijden.add(wedstrijd);
    }
    
    /**
     * De methode <code>getWedstrijden()</code> levert alle wedstrijden uit de arraylist Wedstrijd 
     */
    
    // Print alle wedstrijden in ArrayList wedstrijd
    public ArrayList<Wedstrijd> getWedstrijden(){
        return wedstrijden;
    }
    
    public String getAlleTeams(){
        String output = "";
        for(Wedstrijd wedstrijd : wedstrijden){
            output += wedstrijd.getThuis().toString() +"\n";
            output += wedstrijd.getUit().toString() +"\n";
        }
        
        return output;
    }
    
    /**
     * De methode <code>speelWedstrijd()</code> laat de gebruiker voor een bepaalde wedstrijd een score zetten
     * Als er bij meer dan een wedstrijd een score is gezet begint er een nieuwe ronde voor de finale
     */
    
    public void speelWedstrijd(int wedstrijdId, String score){
        for(Wedstrijd wedstrijd : wedstrijden){
            if(wedstrijdId == wedstrijd.getId()){
                wedstrijd.setUitslag(score);
            }
        }

    
        if(this.allesGespeeld() && wedstrijden.size() > 1){
            knockoutfase.nieuweRonde();
        }
            
    }
    
    /**
     * De methode <code>allesGespeeld()</code> kijkt of alle wedstrijden zijn gespeeld, als dat zo is, dan gaat de boolean gespeeld op true
     * is dit niet zo het geval dan gaat de boolean op false.
     */
    
    
    public boolean allesGespeeld(){
        boolean gespeeld = true;
        for(Wedstrijd wedstrijd : wedstrijden){
            if(!wedstrijd.isGespeeld()){
                gespeeld = false;
            }
        }
        return gespeeld;
    }
    
    /**
     * De methode <code>geefWinnaars()</code> geeft de winnaars (de teams met de hoogste score) en plaatst die in de team arraylist.
     * Deze teams zullen mee worden genomen naar de volgende ronde.
     */
    
    public ArrayList<Team> geefWinnaars() {
        ArrayList<Team> winnaars = new ArrayList<Team>();
        for (Wedstrijd wedstrijd : wedstrijden){
            if (wedstrijd.uitslagUit() > wedstrijd.uitslagThuis()){
                winnaars.add(wedstrijd.getUit());
            }
            else{
                winnaars.add(wedstrijd.getThuis());
            }
        }
        return winnaars;
        
    }
    
    
        
   
}
