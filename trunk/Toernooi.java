import java.util.ArrayList;

public class Toernooi{

    private ArrayList<Poule> poules;
    private String naam;
    
    public Toernooi(String naam){
        this.naam = naam;
        poules = new ArrayList<Poule>();
    }
    
    public void addPoule(String letter, String team1, String team2, String team3, String team4){
        poules.add(new Poule(letter, team1, team2, team3, team4));
    }
    
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