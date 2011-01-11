
public class Hoofdmenu{
    private Menu menu;
    private Poulesysteem poulesysteem;
    private ToernooiSubMenu toernooiMenu;
    
    public Hoofdmenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        maakMenu();
    }
    
    private void maakMenu() {
        menu = new Menu( "Hoofdmenu", "vul menukeuze in" );
        menu.addItem( "Nieuw Toernooi" );
        menu.addItem( "Laad Toernooi" );
        menu.addStopItem( "Afsluiten" );
    }
    
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
    
    private void nieuwToernooi(){
        String naam = TuiHelper.stelVraagMetTekstAntwoord( "Naam van het toernooi", "Nieuw toernooi" );
        poulesysteem.nieuwToernooi(naam);
        toernooiMenu = new ToernooiSubMenu(poulesysteem);
        toernooiMenu.toon();
    }
    
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
