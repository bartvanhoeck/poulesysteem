import java.util.ArrayList;
import java.io.*;

/**
 * De klasse <code>Toernooi</code> heeft als functie om alles te binden in een toernooi.
 * De teams komen in poules, en de poules worden gebruikt in deze klasse.
 * Tevens is in deze klasse alles bij elkaar gehaald, klaar om aan te roepen vanuit de test klasse.
 * 
 */

public class Toernooi implements Serializable{

    private String naam;
    private PouleFase poulefase;
    private KnockoutFase knockoutfase;
    
    /**
     * De constructor <code>Toernooi</code> maakt een nieuwe instantie van toernooi aan, en maakt gebruik van de variabele naam.
     * Verder maakt hij gebruik van de ArrayList Poule. Hier haalt hij alle teams die de constructor nodig heeft vandaan.
     */
    public Toernooi(String naam){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
        this.naam = naam;
    }
    
      /**
      * de Methode <code>beginKnockoutFase()</code> maakt een nieuw object KnockoutFase() aan.
      * Dit zal worden aangeroepen wanneer alle teams zijn ingeschreven en de gebruiker voor een Knockout toernooi heeft gekozen.
      * 
      */
    public void beginKnockoutFase(){
        knockoutfase = new KnockoutFase();
    }
    
      /**
      * de Methode <code>beginPouleFase()</code> maakt een nieuw object PouleFase() aan.
      * Dit zal worden aangeroepen wanneer alle teams zijn ingedeeld in poules en de gebruiker voor een toernooi met poules heeft gekozen.
      */
    
    public void beginPouleFase(){
        poulefase = new PouleFase();
    }
    
      /**
      * de Methode <code>getNaam()</code> levert de naam van het huidige toernooi op.
      */
     
    public String getNaam(){
        return naam;
    }
    
      /**
      * de Methode <code>isPoulefase()</code> word gebruikt om aan te geven bij o.a het laden wat voor een soort toernooi het is.
      * Als er voor poulefase niks is ingevuld (null), dan returnt hij false.
      */
     
    public boolean isPoulefase(){
        if(poulefase != null){
            return true;
        }
        return false;
    }
    
      /**
      * de Methode <code>isKnockoutfase()</code> word gebruikt om aan te geven bij o.a het laden wat voor een soort toernooi het is.
      * Als er voor knockoutfase niks is ingevuld (null), dan returnt hij false.
      */
     
    
    public boolean isKnockoutfase(){
        if(knockoutfase != null){
            return true;
        }
        return false;
    }
   
    /**
      * de Methode <code>getPouleFase()</code> levert de huidige uitslagen en het verloop van de Poulefase
      */
    
    public PouleFase getPouleFase(){
        return poulefase;
    }
    
     /**
      * de Methode <code>getKnockoutFase()</code> levert de huidige uitslagen en het verloop van de Knockoutfase
      */
     
    public KnockoutFase getKnockoutFase(){
        return knockoutfase;
    }
    
        /**
      * de Methode <code>getAlleTeams()</code> geeft een lijst weer met alle teams die momenteel zijn ingelezen in het programma.
      */
     
    public String getAlleTeams(){
        String output = "Teams:\n";
        if(poulefase != null){
            output = poulefase.getAlleTeams();
//        } else if(knockoutfase != null){
//            output = knockoutfase.getAlleTeams();
        }
        return output;
    }
    
       /**
      * de Methode <code>getPoule()</code> laat de gebruiker een poule invullen die vervolgens het verloop in de poulefase van de ingevulde poule laat zien.
      */
     
    
    public Poule getPoule(String letter){
        return poulefase.getPoule(letter);
    }
    
     /**
      * de Methode <code>addPoule()</code> word gebruikt om een poule te maken die gereed is om ingedeeld te worden.
      */
     
    public void addPoule(String letter, String team1, String team2, String team3, String team4){
        poulefase.addPoule(letter, team1, team2, team3, team4);
    }
    
    public void addPoule(String letter, String team1, String team2, String team3){
        poulefase.addPoule(letter, team1, team2, team3);
    }
        
    
    /**
     * De <code>toString()</code> print alle poules af die zijn toegevoegd aan ArrayList<Poules>
     * Dit zal hij netjes verticaal en onder elkaar plaatsen i.c.m de toString methode.
     */
    public String toString(){
        String output = "Toernooi: "+ naam +"\n";
        if (poulefase != null){
            output += "Type: Poule \n";

        }
        
        return output;
    }
    
    
    
    
    
    

}