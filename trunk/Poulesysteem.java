
/**
 * Write a description of class Poulesysteem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poulesysteem{

    private Toernooi toernooi;

    /**
     * Constructor for objects of class Poulesysteem
     */
    public Poulesysteem(){
        
    }
    
    public Toernooi getToernooi(){
        return toernooi;
    }
    
    public void nieuwToernooi(String toernooiNaam){
        toernooi = new Toernooi(toernooiNaam);
    }

}
