
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
