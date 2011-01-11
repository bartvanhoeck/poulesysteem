 


import java.util.*;
import java.io.*;

/**
 * De klasse <code>Knockoutgenerator</code> dient voor het aanmaken en automatisch genereren van Knockoutrondes
 * Dit doet hij d.m.v het inlezen van een textbestandje met daarin de Teams.
 * Elke keer als hij genereert worden er willekeurig teams in een Knockoutronde geplaatst.
 * @author Kenny Ekkelboom
 * @see Test
 */

public class Knockoutgenerator {
    //Attributej
    private ArrayList<String> teams;
    private Toernooi toernooi;
    private Knockout knockout;
    
    //Constructor
    public Knockoutgenerator(Toernooi toernooi){
        this.toernooi = toernooi;
        this.knockout = toernooi.getKnockoutFase().getKnockout();
        teams = new ArrayList<String>();
    }
    
    //
    public void genereerKnockoutrondes(String teamlijst){
        int wedstrijdId = 0; 
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        leesTeamsUitBestand(teamlijst);
        for(int i=0; i<teams.size(); i+=2){
            Team uit = new Team(teams.get(i));
            Team thuis = new Team(teams.get(i+1));
            wedstrijdId++;
            knockout.addWedstrijd(new Wedstrijd(uit, thuis, wedstrijdId));
        }      
    }
    
    //Leest de teams in vanuit een tekstbestand
    private void leesTeamsUitBestand(String textbestand) {
        try {
            BufferedReader bestand = new BufferedReader(new FileReader(textbestand));
            while(bestand.ready()) {
                String team = bestand.readLine();
                teams.add(team);
            }
        } catch (IOException e) {
            System.out.println("Fout tijdens teams inlezen");
        }
    }
        
        
        
}
