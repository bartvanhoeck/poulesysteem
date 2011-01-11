package Model;

/**
 * De klasse <code>Team</code> dient voor het aanmaken van de teams in ons poulesysteem.
 * De constructor <code>Team</code> initialiseert de variabele naam.
 * De <code>toString()</code> methode zorgt ervoor dat de naam in een string kan worden afgedrukt.
 * @author Peter Padberg
 * 
 */

import java.io.*;

public class Team implements Serializable{

    private String naam;
    
    /**
     * Initialiseert de variabele naam. De constructor maakt een team aan.
     * @param naam is de variabele die voor de naam van het team staat.
     */
    public Team(String naam){
        this.naam = naam;
    }
    
    /**
     * Levert de naam van het team op.
     * Dit kan extern worden aangeroepen
     */
    public String getNaam(){
        return naam;
    }
    
    /**
     * Levert de teamnaam af in een string.
     * Dit wordt gebruikt in een System.out.println om te tonen aan de gebruiker 
     */
    public String toString(){
        return ""+ naam;
    }
}