import java.util.*;

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
        maakMenu();
    }
    
    // Methoden
   private void maakMenu() {
       menu = new Menu (toernooi.getNaam(), "vul menukeuze in");
       menu.addItem( "Bekijk alle teams" );
       menu.addItem( "Lees de teams in uit een bestand" );
       menu.addItem( "Bekijk de wedstrijden" );
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
                case 1: bekijkTeams();       break; 
                case 2: leesTeamsIn();       break;
                case 3: bekijkWedstrijden(); break;
                case 4: speelWedstrijd();    break;
                case 5: slaToernooiOp();     break;
            }
        }
    }
    
    // Case1
     private void bekijkTeams(){
        System.out.println(toernooi.getAlleTeams());
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
    
    // Case2
    private void leesTeamsIn(){
        System.out.println("Lezen...");
        new Knockoutgenerator(toernooi).genereerKnockoutrondes("teams.txt");
        TuiHelper.wacht(3000);
        System.out.println("Teams ingelezen.");
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
    
    // Case3
    private void bekijkWedstrijden() {
        knockout.getWedstrijden();
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
         
    }
    
     // Case4 
    private void speelWedstrijd(){
        new WedstrijdenSubMenu(knockout).toon();
    }
    //Case5
    private void slaToernooiOp(){
        System.out.println("Opslaan....");
        poulesysteem.saveToernooi();
        TuiHelper.wacht(2000);
        System.out.println("Toernooi opgeslagen!");
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
        
}