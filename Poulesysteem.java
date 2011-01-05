
/**
 * De klasse <code>Poulesysteem</code>
 * Poulesysteem regelt alles wat er in ons programma gebeurt.
 * Poulesysteem beheert de alles omvattende toernooi klasse.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */
public class Poulesysteem{

    private Toernooi toernooi;


    public Poulesysteem(){
        
    }
    
    /**
     * Methode <code>getToernooi() </code> Laat het toernooi zien die de gebruiker heeft gekozen
     */
    
    public Toernooi getToernooi(){
        return toernooi;
    }
    
    /**
     * Methode <code>nieuwToernooi()</code> laat de gebruiker een nieuw toernooi aanmaken.
     * toernooiNaam dient als variabele waarin de naam van het toernooi wordt onthouden.
     */
    
    public void nieuwToernooi(String toernooiNaam){
        toernooi = new Toernooi(toernooiNaam);
    }

}
