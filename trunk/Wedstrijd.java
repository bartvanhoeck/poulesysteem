
public class Wedstrijd
{
    // Attributen
    private int uitslagUit = -1;
    private int uitslagThuis = -1;
    private Team uit;
    private Team thuis;
    private boolean gespeeld = false;
    
    // Constructor
    public Wedstrijd( Team thuis, Team uit ) {
        this.uit = uit;
        this.thuis = thuis;
        this.uitslagUit = uitslagUit;
        this.uitslagThuis = uitslagThuis;
    }
    
    
    
    // Methoden
    public Team getUit() {
        return uit;
    }
    
    public Team getThuis() {
        return uit;
    }
    
    public int uitslagUit() {
        return uitslagUit;
    }
    
    public int uitslagThuis() {
        return uitslagThuis;
    }
    
    public void setUitslag( int uitslagThuis, int uitslagUit )
    {
        this.uitslagUit = uitslagUit;
        this.uitslagThuis = uitslagThuis;
    }
    
    public String toString() {
        String output = uit + "-" + thuis ;
        String score = ", " + uitslagThuis + "-" + uitslagUit;
        if(gespeeld == true) {
            return output + score; 
        }
        else{ 
            return output;
        }
    }
   
}
