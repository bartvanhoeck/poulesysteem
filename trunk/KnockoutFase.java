
/**
 * Write a description of class KnockoutFase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnockoutFase{
    private Knockout knockout;
    
    public KnockoutFase(){
        this.nieuweKnockout();
    }
    
    public void nieuweKnockout(){
        knockout = new Knockout();
    }
    
    public Knockout getKnockout(){
        return knockout;
    }
}
