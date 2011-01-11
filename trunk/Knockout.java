import java.util.*;
import java.io.*;

public class Knockout implements Serializable{

    // Attributen
    private ArrayList<Wedstrijd> wedstrijden;
    private KnockoutFase knockoutfase;
    
    
    // Constructor
    public Knockout(KnockoutFase knockoutfase){
        wedstrijden = new ArrayList <Wedstrijd>();
        this.knockoutfase = knockoutfase;
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
        
        if(this.allesGespeeld()){
            knockoutfase.nieuweRonde();
        }
            
    }
    
    public boolean allesGespeeld(){
        boolean gespeeld = true;
        for(Wedstrijd wedstrijd : wedstrijden){
            if(!wedstrijd.isGespeeld()){
                gespeeld = false;
            }
        }
        return gespeeld;
    }
    
    public ArrayList<Team> geefWinnaars() {
        ArrayList<Team> winnaars = new ArrayList<Team>();
        for (Wedstrijd wedstrijd : wedstrijden){
            if (wedstrijd.uitslagUit() > wedstrijd.uitslagThuis()){
                winnaars.add(wedstrijd.getUit());
            }
            else{
                winnaars.add(wedstrijd.getThuis());
            }
        }
        return winnaars;
        
    }
    
    
        
   
}
