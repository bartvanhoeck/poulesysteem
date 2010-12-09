
public class ToernooiSubMenu{
    private Menu menu;
    private Poulesysteem poulesysteem;
    private Toernooi toernooi;
    
    public ToernooiSubMenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        this.toernooi = poulesysteem.getToernooi();
        maakMenu();
    }
    
    private void maakMenu() {
        menu = new Menu( toernooi.getNaam(), "vul menukeuze in" );
        menu.addItem( "Bekijk alle teams" );
        menu.addItem( "Bekijk de poules" );
        menu.addItem( "Bekijk een poule" );
        menu.addItem( "Bekijk de wedstrijden in een poule" );
        menu.addItem( "Lees de teams in uit een bestand" );
        menu.addStopItem( "Toernooi afsluiten" );
    }
    
    public void toon() {
        int keuze = -1;
        while ( keuze != 0 ) {
            keuze = menu.getMenukeuze();
            switch ( keuze ) {
                case 1: bekijkTeams();   break;
                case 2: bekijkAllePoules();   break;
                case 3: bekijkPoule();   break;
                case 4: bekijkWedstrijden();   break;
                case 5: leesTeamsIn(); break;
            }
        }
    }
    
    private void bekijkTeams(){
        System.out.println(toernooi.getAlleTeams());
    }
    
    private void bekijkPoule(){
        String letter = TuiHelper.stelVraagMetPouleLetterAntwoord( "Welke poule" ).toUpperCase();
        if(toernooi.getPoule(letter) != null){
            System.out.println(toernooi.getPoule(letter).toString());
        } else{
            System.out.println("Poule "+ letter +" bestaat niet.");
        }
    }
    
    private void bekijkAllePoules(){
        System.out.println(toernooi.toString());
    }
    
    private void bekijkWedstrijden(){
        String letter = TuiHelper.stelVraagMetPouleLetterAntwoord( "Welke poule" ).toUpperCase();
        if(toernooi.getPoule(letter) != null){
            System.out.println(toernooi.getPoule(letter).geefWedstrijden());
        } else{
            System.out.println("Poule "+ letter +" bestaat niet.");
        }
    }
    
    private void leesTeamsIn(){
        new Poulegenerator(toernooi).genereerPoules("teams.txt");
    }
}
