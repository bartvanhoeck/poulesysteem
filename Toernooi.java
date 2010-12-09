import java.util.ArrayList;

/**
 * De klasse <code>Toernooi</code> heeft als functie om alles te binden in een toernooi.
 * De teams komen in poules, en de poules worden gebruikt in deze klasse.
 * Tevens is in deze klasse alles bij elkaar gehaald, klaar om aan te roepen vanuit de test klasse.
 * 
 */

public class Toernooi{

    private ArrayList<Poule> poules;
    private String naam;
    
    /**
     * De constructor <code>Toernooi</code> maakt een nieuwe instantie van toernooi aan, en maakt gebruik van de variabele naam.
     * Verder maakt hij gebruik van de ArrayList Poule. Hier haalt hij alle teams die de constructor nodig heeft vandaan.
     */
    public Toernooi(String naam){
        this.naam = naam;
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
     * De <code>toString()</code> print alle poules af die zijn toegevoegd aan ArrayList<Poules>
     * Dit zal hij netjes verticaal en onder elkaar plaatsen i.c.m de toString methode.
     */
    public String toString(){
        String output = "Toernooi: "+ naam +"\n\n";
        for(Poule poule : poules){
            output += poule.toString() +"\n";
        }
        
        return output;
    }
    
    public String getAlleTeams(){
        String output = "Teams in "+ naam +": \n";
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
    

}