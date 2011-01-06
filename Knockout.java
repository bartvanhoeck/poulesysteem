import java.util.*;
public class Knockout{

    // Attributen
    private ArrayList<Wedstrijd> wedstrijden;

    
    
    // Constructor
    public Knockout(){
        wedstrijden = new ArrayList <Wedstrijd>();

    }
    
    // Methoden
    public void addWedstrijd(Wedstrijd wedstrijd){
        wedstrijden.add(wedstrijd);
    }
    
    // Print alle wedstrijden in ArrayList wedstrijd
    public ArrayList<Wedstrijd> getWedstrijden(){
        return wedstrijden;
    }
    
    public void speelWedstrijd(int wedstrijdId, String score){
        for(Wedstrijd wedstrijd : wedstrijden){
            if(wedstrijdId == wedstrijd.getId()){
                wedstrijd.setUitslag(score);
            }
        }
    }
    
    public void geefWinnaars() {
        ArrayList<Team> winnaars = new ArrayList<Team>();
        for (Wedstrijd wedstrijd : wedstrijden){
            if (wedstrijd.uitslagUit() > wedstrijd.uitslagThuis()){
                winnaars.add(wedstrijd.getUit());
            }
            else{
                winnaars.add(wedstrijd.getThuis());
            }
        }
        
        
    }
    
    
        
   
}
