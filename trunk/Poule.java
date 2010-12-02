import java.util.ArrayList;

public class Poule{
    
    // Attributen
    private ArrayList<Team> teams;
    private ArrayList<Wedstrijd> wedstrijden;
    private String letter;
    
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
    
    // Methoden
    public String getLetter(){
        return letter;
    }
    
    public String getAlleTeams(){
        String output = "";
        for(Team team : teams){
            output += team.toString() +"\n";
        }
        return output;
    }
    
    public String toString(){
        String output = "Poule "+ letter +"\n";
        for(Team team : teams){
            output += team.toString() +"\n";
        }
        
        return output;
    }
    
    public void addWedstrijdVerloop() {
        wedstrijden.add(new Wedstrijd(teams.get(0), teams.get(1)));
        wedstrijden.add(new Wedstrijd(teams.get(2), teams.get(3)));
        wedstrijden.add(new Wedstrijd(teams.get(1), teams.get(2)));
        wedstrijden.add(new Wedstrijd(teams.get(0), teams.get(2)));
        wedstrijden.add(new Wedstrijd(teams.get(3), teams.get(1)));
        wedstrijden.add(new Wedstrijd(teams.get(0), teams.get(3)));
    }
    
    public void setUitslag(int wedstrijdnummer, String score){
        
    }
    
    public String geefWedstrijden() {
        String output = "Wedstrijden in poule "+ letter +":\n";
        for(Wedstrijd wedstrijd : wedstrijden){
            output += wedstrijd.toString() +"\n";
            
        }
        
        
        return output;    
    }
    
          
}

        
    

    