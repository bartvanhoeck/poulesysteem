import java.util.ArrayList;
public class WedstrijdenSubMenu{

    private Menu menu;
    private Poule poule;
    
    public WedstrijdenSubMenu(Poule poule){
        this.poule = poule;
        maakMenu();
    }
    
    private void maakMenu() {
        menu = new Menu( "Poule "+poule.getLetter(), "Welke wedstrijd" );
        ArrayList<Wedstrijd> wedstrijden = poule.getWedstrijdenInArrayList();
        for(Wedstrijd wedstrijd : wedstrijden){
            menu.addItem(wedstrijd.toString());
        }
        menu.addStopItem( "Terug naar toernooi" );
    }
    
    public void toon() {
        int keuze = -1;
        while ( keuze != 0 ) {
            keuze = menu.getMenukeuze();
            if(keuze !=0){
                speelWedstrijd(keuze);
            }
        }
    }
    
    private void speelWedstrijd(int wedstrijdId){
        if(wedstrijdId>0 && wedstrijdId<=6){
            String uitslag = TuiHelper.stelVraagMetTekstAntwoord("Wat is de uitslag", "Wedstrijd "+wedstrijdId);
            poule.setUitslag(wedstrijdId, uitslag);
            maakMenu();
        }
    }
            
}