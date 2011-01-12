import java.util.*;
import java.io.*;


/**
 * De klasse <code>Poulefase</code> is mede verantwoordelijk voor het maken van de poules.
 * Ook regelt hij de poules en maakt het mogelijk om een lijst van de poules met daarin de teams uit te printen
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class PouleFase implements Serializable {
    private ArrayList<Poule> poules;
    
    /**
     * De constructor <code>PouleFase</code> voegt een Poule toe aan <code>ArrayList<Poule></code>
     * Een poule bestaat uit vier teams en een letter om hem aan te kunnen roepen.
     * Een poule bestaat uit vier teams en een letter om hem aan te kunnen roepen.
     */
    
    public PouleFase(){
        poules = new ArrayList<Poule>();
    }
    
    /**
     * De methode <code>addPoule</code> voegt een Poule toe aan <code>ArrayList<Poule></code>
     * Een poule bestaat uit vier teams en een letter om hem aan te kunnen roepen.
     */
    public void addPoule(String letter, String team1, String team2, String team3, String team4){
        poules.add(new Poule(letter, team1, team2, team3, team4));
    }

    
    public void addPoule(String letter, String team1, String team2, String team3){
        poules.add(new Poule(letter, team1, team2, team3));
    }
    
      /**
      * de Methode <code>getAantalteams()</code> levert alle teams op die zijn ingedeeld in een poule.
      */
    public String getAlleTeams(){
        String output = "";
        for(Poule poule : poules){            
            output += poule.getAlleTeams();
        }
        return output;
    }
    
    
      /**
      * de Methode <code>getPoule()</code> maakt het mogelijk een poule letter in te vullen,
      * om vervolgens de betreffende poule  te bekijken.
      */
     
    public Poule getPoule(String letter){
        for(Poule poule : poules){
            if(letter.equals(poule.getLetter())){
                return poule;
            }
        }
        return null;
    }
      /**
      * de Methode <code>toString()</code> levert de poules met bijbehorende teams in een string
      */
     
    public String toString(){
        String output = "";
        for(Poule poule : poules){
            output += poule.toString() +"\n";
        }
        
        return output;
    }
}
