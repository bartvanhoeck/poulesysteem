public class Team{

    private String naam;
    
    public Team(String naam){
        this.naam = naam;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public String toString(){
        return ""+ naam;
    }
}