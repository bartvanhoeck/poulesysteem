import java.util.ArrayList;

/**
 * De klasse <code>WedstrijdenSubMenu</code>
 * 
 * Dit menu komt tevoorschijn wanneer de gebruiker uitslagen aan wedstrijden wil toevoegen.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class WedstrijdenSubMenu{

    private Menu menu;
    private Poule poule;
    private Knockout knockout;
    
    public WedstrijdenSubMenu(Poule poule){
        this.poule = poule;
        maakMenu();
    }
    
    public WedstrijdenSubMenu(Knockout knockout){
        this.knockout = knockout;
        maakMenu();
    }
    
    private void maakMenu() {
        ArrayList<Wedstrijd> wedstrijden = null;
        if(poule != null){
            wedstrijden = poule.getWedstrijdenInArrayList();
            menu = new Menu( "Poule "+poule.getLetter(), "Welke wedstrijd" );
        }
        else if(knockout != null){
            wedstrijden = knockout.getWedstrijden();
            menu = new Menu("Alle wedstrijden", "Welke wedstrijd");
        }
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
        String uitslag = TuiHelper.stelVraagMetUitslagAntwoord("Wat is de uitslag", "Wedstrijd "+wedstrijdId);
        if(poule != null){
            poule.setUitslag(wedstrijdId, uitslag);
        }
        else if(knockout != null){
            knockout.speelWedstrijd(wedstrijdId, uitslag);
        }
        maakMenu();
    }
            
}