/**
 * De klasse <code>Wedstrijd</code> dient voor het aanmaken van de variabelen van wedstrijd.
 * De constructor <code>Wedstrijd</code> initialiseert deze attributen.
 * De <code>toString()</code> methode zorgt voor het uitprinten van de wedstrijd details (teams en uitslagen)
 * @author Kenny Ekkelboom & Tristan Weber
 * 
 */

public class Wedstrijd
{
    // Attributen
    private int uitslagUit = -1;
    private int uitslagThuis = -1;
    private Team uit;
    private Team thuis;
    private boolean gespeeld = false;
    private int id;
    
 /**
  * Initialiseert alle variabelen die nodig zijn voor het presenteren van een wedstrijd (uitslag en teams)
  * @paramthuis wordt gebruikt in de constructor om het Team aan te duiden dat thuis speelt
  * @param uit wordt gebruikt in de constructor om het Team aan te duiden dat uit speelt
  * @param wedstrijdId wordt gebruikt om een wedstrijd te nummeren zodat hij kan worden aangeroepen uit een ArrayList
  * 
  */
    
    // Constructor
    public Wedstrijd( Team thuis, Team uit, int wedstrijdId ) {
        this.uit = uit;
        this.thuis = thuis;
        this.id = wedstrijdId;
    }
/**
 * Levert het Team op dat uit speelt
 * 
 */
    
    // Methoden
    public Team getUit() {
        return uit;
    }
 /**
  * Levert het ID op van de wedstrijd
  */
    public int getId(){
        return id;
    }
    
    /**
     * Levert het Team op dat thuis speelt
     */
    public Team getThuis() {
        return uit;
    }
    
    /**
     * Levert de score op van het Team dat uit speelt
     */
    public int uitslagUit() {
        return uitslagUit;
    }
    /**
     * Levert de score op van het Team dat thuis speelt
     */
    public int uitslagThuis() {
        return uitslagThuis;
    }
    
    /**
     * Maakt het mogelijk een waarde te geven aan de variabelen uitslagThuis en uitslagUit
     * Deze waarden worden overschreven van de huidige waarde.
     * Na het uitvoeren van deze methode veranderd de boolean "gespeeld" in true.
     * Dit omdat je na het setten van een uitslag kan aannemen dat de wedstrijd gespeeld is 
     */
    public void setUitslag( String score ){
        score = score.trim();
        int thuis = Integer.parseInt(score.substring(0, score.indexOf("-")).trim());
        int uit = Integer.parseInt(score.substring(score.indexOf("-")+1, score.length()).trim());
        this.uitslagUit = uit;
        this.uitslagThuis = thuis;
        gespeeld = true;
    }
    
    /**
     * Levert de toString output.
     * Hier worden alle variabelen op een nette manier in een string gezet.
     * De toString methode wordt tevens gebruikt om uitslagen te tonen aan de gebruiker
     * @return Bijv: Nederland - Engeland, 2-1
     */
    public String toString() {
        String output = uit + " - " + thuis;
        String score = ", " + uitslagThuis + "-" + uitslagUit;
        if(gespeeld) {
            return output + score; 
        }
        else{ 
            return output;
        }
    }
   
}
