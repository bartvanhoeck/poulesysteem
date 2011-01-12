import java.io.*;
import java.util.*;

/**
 * De klasse <code>KnockoutFase</code>
 * 
 * Hier kom je in terecht wanneer de gebruiker alle teams heeft ingeladen en wedstrijden wil gaan spelen.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class KnockoutFase implements Serializable{
    private Knockout knockout;
    
    public KnockoutFase(){
        this.nieuweKnockout();
    }
    
    public void nieuweKnockout(){
        knockout = new Knockout(this);
    }
    
    public Knockout getKnockout(){
        return knockout;
    }
    
    public String getAlleTeams(){
        return knockout.getAlleTeams();
    }
    
    public void nieuweRonde(){
        ArrayList<Team> teams = knockout.geefWinnaars();
        this.nieuweKnockout();
        int wedstrijdId = 0;
        for(int i=0; i<teams.size(); i+=2){
            Team thuis = teams.get(i);
            Team uit = teams.get(i+1);
            wedstrijdId++;
            knockout.addWedstrijd(new Wedstrijd(thuis, uit, wedstrijdId));
        }  
    }
}
