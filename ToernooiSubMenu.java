
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
            case 1: nieuwToernooi();   break;
            case 2: break;
        }
    }
    
    private void nieuwToernooi(){
        new PouleSubMenu(poulesysteem).toon();
    }
}
