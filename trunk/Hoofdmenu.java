/**
 * De klasse <code>Hoofdmenu</code>
 * 
 * De klasse Hoofdmenu is wat de gebruiker te zien krijgt als hij het programma opstart.
 * Hier heb je de keuze uit de verschillende toernooien die mogelijk zijn.
 * Ook kan je hier een toernooi met bestaande uitslagen laden.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class Hoofdmenu{
    private Menu menu;
    private Poulesysteem poulesysteem;
    private ToernooiSubMenu toernooiMenu;
    
    /**
     * De Constructor <code>Hoofdmenu()</code> maakt een object aan van het hoofdmenu die de gebruiker te zien krijgt.
     */
    
    public Hoofdmenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        maakMenu();
    }
    
    /**
     * De methode <code>maakMenu()</code> voegt daadwerkelijk de items toe aan het menu en stelt de vraag welke keuze je neemt.
     * 
     */
    private void maakMenu() {
        menu = new Menu( "Hoofdmenu", "vul menukeuze in" );
        menu.addItem( "Nieuw Toernooi" );
        menu.addItem( "Laad Toernooi" );
        menu.addStopItem( "Afsluiten" );
    }
    
    /**
     * De methode <code>toon()</code> zorgt ervoor dat er ook wat gebeurt als je een keuze invoert.
     * De items zijn verbonden met een case aan variabelen voor de betreffende case. 
     */
    
    public void toon() {
        int keuze = -1;
        while ( keuze != 0 ) {
            keuze = menu.getMenukeuze();
            switch ( keuze ) {
                case 1: nieuwToernooi();   break;
                case 2: laadToernooi();    break;
            }
        }
        System.out.println( "Tot ziens!" );
    }
    
    /**
     * De methode <code>nieuwToernooi()</code> maakt een toernooi aan (een nieuw spel).
     * Dit word gebruikt bij het selecteren van de toernooikeuze.
     */
    
    private void nieuwToernooi(){
        String naam = TuiHelper.stelVraagMetTekstAntwoord( "Naam van het toernooi", "Nieuw toernooi" );
        poulesysteem.nieuwToernooi(naam);
        toernooiMenu = new ToernooiSubMenu(poulesysteem);
        toernooiMenu.toon();
    }
    
    /**
     * De methode <code>laadToernooi()</code> zorgt ervoor dat je uitslagen en resultaten op kunt slaan.
     * Zo kun je het programma afsluiten zonder alles weer opnieuw in te hoeven vullen.
     * 
     */
    
    
    private void laadToernooi(){
        poulesysteem.laadToernooi();
        if(poulesysteem.getToernooi().isPoulefase()){
            new PouleSubMenu(poulesysteem).toon();
        }
        else if(poulesysteem.getToernooi().isKnockoutfase()){
            new KnockoutSubMenu(poulesysteem).toon();
        }
    }
}
