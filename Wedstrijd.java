
public class Wedstrijd
{
    // Attributen
    private int uitslagUit = 0;
    private int uitslagThuis = 0;
    private Team uit;
    private Team thuis;
    
    // Constructor
    public Wedstrijd( Team uit, Team thuis ) {
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
    
    public void setUitslag( int uitslagUit, int uitslagThuis )
    {
        this.uitslagUit = uitslagUit;
        this.uitslagThuis = uitslagThuis;
    }
    
    public String toString() {
        return uit + "-" + thuis + "," + uitslagUit + "-" + uitslagThuis; 
    }
   
}
