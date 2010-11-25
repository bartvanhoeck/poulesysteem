import java.util.ArrayList;

public class Poule{

    private ArrayList<Team> teams;
    private String letter;
    
    public Poule(String letter, String team1, String team2, String team3, String team4){
        this.letter = letter;
        teams = new ArrayList<Team>();
        teams.add(new Team(team1));
        teams.add(new Team(team2));
        teams.add(new Team(team3));
        teams.add(new Team(team4));
    }
    
    public String getLetter(){
        return letter;
    }
    
    public String getAlleTeams(){
        String output = "";
        for(Team team : teams){
            output += team +"\n";
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
    
}
    