import java.util.ArrayList;
import java.io.*;

/**
 * De klasse <code>Poule</code> dient voor het aanmaken van de Poules
 * Poule voegt vier bestaande Teams toe en sluit ze bijeen.
 * Verder geeft hij iedere poule een letter ter identificatie.
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */
public class Poule implements Serializable{
    

    // Attributen
    private ArrayList<Team> teams;
    private ArrayList<Wedstrijd> wedstrijden;
    private String letter;
    
    /**
     * Hier word de ArrayList<Team> en ArrayList<Wedstrijd> geinitialiseerd.
     * Vervolgens word er een verloop van wedstrijden aan toegevoegd. zie @see wedstrijdVerloop
     * Als laatste voegt hij hier de vier teams toe aan de arraylist Wedstrijd.
     */
    // Constructor
    public Poule(String letter, String team1, String team2, String team3, String team4){
        this.letter = letter;
        teams = new ArrayList<Team>();
        teams.add(new Team(team1));
        teams.add(new Team(team2));
        teams.add(new Team(team3));
        teams.add(new Team(team4));
        wedstrijden = new ArrayList<Wedstrijd>();
        this.addWedstrijdVerloop();
    }
    
    public Poule(String letter, String team1, String team2, String team3){
        this.letter = letter;
        teams = new ArrayList<Team>();
        teams.add(new Team(team1));
        teams.add(new Team(team2));
        teams.add(new Team(team3));
        wedstrijden = new ArrayList<Wedstrijd>();
        this.addWedstrijdVerloop();
    }
    
    // Methoden
    /**
     * Methode getLetter() Levert de letter van de poule op
     */
    public String getLetter(){
        return letter;
    }
    
    public ArrayList<Wedstrijd> getWedstrijdenInArrayList(){
        return wedstrijden;
    }
    
    /**
     * Methode getAlleTeams() gaat met behulp van een for loop alle teams af en print iedere team die het vindt m.b.v de toString methode
     * Deze methode is aan te roepen in de TUI en in de test klasse
     */
    public String getAlleTeams(){
        String output = "";
        for(Team team : teams){
            output += team.toString() +"\n";
        }
        return output;
    }
    
    /**
     * De toString methode print de poule met bijbehorende teams af
     */
    public String toString(){
        String output = "Poule "+ letter +"\n";
        
        for(Team team : teams){
            output += team.toString() +"\n";
        }
        
        return output;
    }
    /**
     * Dit is het wedstrijd verloop dat iedere poule krijgt.
     * De volgorde waarin de wedstrijden worden gespeeld is bij iedere poule hetzelfde
     */
    public void addWedstrijdVerloop() {
        int id = 1;
        for(int i=0; i<teams.size()-1; i++){
            for(int j=i+1; j<teams.size(); j++){
                wedstrijden.add(new Wedstrijd(teams.get(i), teams.get(j), id));
                id++;
            }
        }
    }
    
    /**
     * Methode <code>setUitslag()</code> zorgt ervoor dat je de uitslag toe kunt voegen aan een wedstrijd.
     * Dit zal na het toevoegen automatisch aan een wedstrijd worden geplakt, inclusief bij de output van die wedstrijd.
     */
    
    public void setUitslag(int wedstrijdId, String score){
        for(Wedstrijd wedstrijd : wedstrijden){
            if(wedstrijdId == wedstrijd.getId()){
                wedstrijd.setUitslag(score);
            }
        }
    }
    /**
     * Methode <code>geefWedstrijden()</code> print alle wedstrijden in de ArrayList<wedstrijd> af m.b.v de toString() methode
     */
    public String geefWedstrijden() {
        String output = "Wedstrijden in poule "+ letter +":\n";
        for(Wedstrijd wedstrijd : wedstrijden){
            output += wedstrijd.toString() +"\n";
            
        }
            
        return output;    
    }
    
          
}

        
    

    