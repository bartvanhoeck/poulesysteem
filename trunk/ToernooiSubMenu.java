/**
 * De klasse <code>ToernooiSubMenu</code>
 * 
 * Dit is het menu waar je in komt als de gebruiker kiest voor een nieuw toernooi.
 * Je kunt kiezen tussen een toernooi met poules of een toernooi zonder poules (knockout)
 * 
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class ToernooiSubMenu{
    private Menu menu;
    private Poulesysteem poulesysteem;
    
    public ToernooiSubMenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        maakMenu();
    }
    
    private void maakMenu() {
        menu = new Menu( poulesysteem.getToernooi().getNaam(), "Welk type toernooi" );
        menu.addItem( "Poule" );
        menu.addItem( "Knockout" );
        menu.addStopItem( "Afsluiten" );
    }
    
    public void toon() {
        int keuze = -1;
        keuze = menu.getMenukeuze();
            
        switch ( keuze ) {
            case 1: nieuwPouleToernooi();   break;
            case 2: nieuwKnockoutToernooi(); break;
        }
    }
    
    // Poule
    private void nieuwPouleToernooi(){
        poulesysteem.getToernooi().beginPouleFase();
        new PouleSubMenu(poulesysteem).toon();
    }
    
    // Knockout
    private void nieuwKnockoutToernooi(){
        poulesysteem.getToernooi().beginKnockoutFase();
        new KnockoutSubMenu(poulesysteem).toon();
    }
}
