public class KnockoutSubMenu
{
    // Attributen
    private Menu menu;
    private Poulesysteem poulesysteem;
    private Toernooi toernooi;
    
    // Constructor
    public KnockoutSubMenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        this.toernooi = poulesysteem.getToernooi();
        maakMenu();
    }
    
    // Methoden
   private void maakMenu() {
       menu = new Menu (toernooi.getNaam(), "vul menukeuze in");
       menu.addItem( "Bekijk alle teams" );
       menu.addItem( "Lees de teams in uit een bestand" );
       menu.addItem( "Bekijk de wedstrijden" );
       menu.addItem( "Speel wedstrijd" );
       menu.addStopItem( "Toernooi afsluiten" );

    }
    
     public void toon() {
        int keuze = -1;
        while ( keuze != 0 ) {
            keuze = menu.getMenukeuze();
            switch ( keuze ) {
                case 1: bekijkTeams();   break; 
                case 2: leesTeamsIn();   break;
                case 3: bekijkWedstrijden(); break;
            }
        }
    }
    
    // Case1
     private void bekijkTeams(){
        System.out.println(toernooi.getAlleTeams());
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
    
    // Case2 - Poulegenerator straks omzetten in een Knockout generator
    private void leesTeamsIn(){
        System.out.println("Lezen...");
        new Knockoutgenerator(toernooi).genereerKnockoutrondes("teams.txt");
        TuiHelper.wacht(3000);
        System.out.println("Teams ingelezen.");
        TuiHelper.drukafDrukEnterEnWachtOpEnter();
    }
    
    // Case3 - AFMAKEN zodra Knockout klaar is 
    private void bekijkWedstrijden() {
         
    }
        
    // Case4 - AFMAKEN zodra Knockout klaar is
    private void speelWedstrijd() {
            
    }
    
    

    
   
    
    
}