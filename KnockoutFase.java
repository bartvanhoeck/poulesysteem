import java.io.*;
import java.util.*;
/**
 * Write a description of class KnockoutFase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void nieuweRonde(){
        ArrayList<Team> teams = knockout.geefWinnaars();
        this.nieuweKnockout();
        int wedstrijdId = 0;
        for(int i=0; i<teams.size(); i+=2){
            Team uit = teams.get(i);
            Team thuis = teams.get(i+1);
            wedstrijdId++;
            knockout.addWedstrijd(new Wedstrijd(uit, thuis, wedstrijdId));
        }  
    }
}
