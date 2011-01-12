import java.util.*;

/**
 * De klasse <code>KnockoutSubMenu</code>
 * 
 * In dit menu kom je terecht wanneer de gebruiker kiest voor een toernooi zonder poule
 * In dit menu kun je alles regelen omtrent het toernooi
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class KnockoutSubMenu
{
    // Attributen
    private Menu menu;
    private Poulesysteem poulesysteem;
    private Toernooi toernooi;
    private Knockout knockout;
    private ArrayList<Wedstrijd> wedstrijden;
    private String opslagData;
    
    
    // Constructor
    public KnockoutSubMenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        this.toernooi = poulesysteem.getToernooi();
        this.knockout = toernooi.getKnockoutFase().getKnockout();
        this.leesTeamsIn();
        maakMenu();
    }
    
    // Methoden
   private void maakMenu() {
       menu = new Menu (toernooi.getNaam(), "vul menukeuze in");
       menu.addItem( "Bekijk alle teams" );
       menu.addItem( "Speel wedstrijd" );
       menu.addItem( "Sla toernooi op" );
       menu.addStopItem( "Toernooi afsluiten" );

    }
    
    // Toon menu
     public void toon() {
        int keuze = -1;
        while ( keuze != 0 ) {
            keuze = menu.getMenukeuze();
            switch ( keuze ) {
                case 1: bekijkTeams();     break; 
                case 2: speelWedstrijd();  break;
                case 3: slaToernooiOp();   break;
            }
        }
    }
    
    // Case1
     private void bekijkTeams(){
        System.out.println(toernooi.getAlleTeams());
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
      
     // Case2
    private void speelWedstrijd(){
        new WedstrijdenSubMenu(knockout).toon();
        knockout = toernooi.getKnockoutFase().getKnockout();
    }
    //Case 3
    private void slaToernooiOp(){
        System.out.println("Opslaan....");
        poulesysteem.saveToernooi();
        TuiHelper.wacht(2000);
        System.out.println("Toernooi opgeslagen!");
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
    
    
    private void leesTeamsIn(){
        System.out.println("Lezen...");
        new Knockoutgenerator(toernooi).genereerKnockoutrondes("teams.txt");
        TuiHelper.wacht(3000);
        System.out.println("Teams ingelezen.");
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
        
}