import java.util.*;


/**
 * De klasse <code>Poulefase</code> is mede verantwoordelijk voor het maken van de poules.
 * Ook regelt hij de poules en maakt het mogelijk om een lijst van de poules met daarin de teams uit te printen
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class PouleFase{
    private ArrayList<Poule> poules;
    
    /**
     * De constructor <code>PouleFase</code> voegt een Poule toe aan <code>ArrayList<Poule></code>
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
    
     /**
      * de Methode <code>getAantalteams()</code> 
      */
    
    public int getAantalTeams(){
        return 5;
    }
    
    public String getAlleTeams(){
        String output = "";
        for(Poule poule : poules){
            output += poule.getAlleTeams();
        }
        return output;
    }
    
    public Poule getPoule(String letter){
        for(Poule poule : poules){
            if(letter.equals(poule.getLetter())){
                return poule;
            }
        }
        return null;
    }
    
    public String toString(){
        String output = "";
        for(Poule poule : poules){
            output += poule.toString() +"\n";
        }
        
        return output;
    }
}
