import java.util.ArrayList;

/**
 * De klasse <code>Toernooi</code> heeft als functie om alles te binden in een toernooi.
 * De teams komen in poules, en de poules worden gebruikt in deze klasse.
 * Tevens is in deze klasse alles bij elkaar gehaald, klaar om aan te roepen vanuit de test klasse.
 * 
 */

public class Toernooi{

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
    
    public void beginKnockoutFase(){
        knockoutfase = new KnockoutFase();
    }
    
    public void beginPouleFase(){
        poulefase = new PouleFase();
    }
    
    public String getNaam(){
        return naam;
    }
    
    public KnockoutFase getKnockoutFase(){
        return knockoutfase;
    }
    
    public String getAlleTeams(){
        String output = "Teams:\n";
        if(poulefase != null){
            output = poulefase.getAlleTeams();
//        } else if(knockoutfase != null){
//            output = knockoutfase.getAlleTeams();
        }
        return output;
    }
    
    public Poule getPoule(String letter){
        return poulefase.getPoule(letter);
    }
    
    public void addPoule(String letter, String team1, String team2, String team3, String team4){
        poulefase.addPoule(letter, team1, team2, team3, team4);
    }
        
    
    /**
     * De <code>toString()</code> print alle poules af die zijn toegevoegd aan ArrayList<Poules>
     * Dit zal hij netjes verticaal en onder elkaar plaatsen i.c.m de toString methode.
     */
    public String toString(){
        String output = "Toernooi: "+ naam +"\n";
        if (poulefase != null){
            output += "Type: Poule \n";
            output += "Aantal teams: "+ poulefase.getAantalTeams();
//        } else if(knockoutfase != null){
//            output += "Type: Knockout\n";
//            output += "Aantal teams: "+ knockoutfase.getAantalTeams();
        }
        
        return output;
    }
    
    
    
    
    
    

}