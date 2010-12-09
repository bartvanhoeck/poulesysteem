
public class Hoofdmenu{
    private Menu menu;
    private Poulesysteem poulesysteem;
    
    public Hoofdmenu(Poulesysteem poulesysteem){
        this.poulesysteem = poulesysteem;
        maakMenu();
    }
    
	private void maakMenu() {
		menu = new Menu( "Hoofdmenu", "vul menukeuze in" );
		menu.addItem( "Nieuw Toernooi" );
		menu.addStopItem( "Afsluiten" );
	}
	
	public void toon() {
		int keuze = -1;
		while ( keuze != 0 ) {
			keuze = menu.getMenukeuze();
			switch ( keuze ) {
			    case 1: nieuwToernooi();   break;
			}
		}
		System.out.println( "Tot ziens!" );
	}
	
	private void nieuwToernooi(){
	    String naam = TuiHelper.stelVraagMetTekstAntwoord( "Naam van het toernooi", "Nieuw toernooi" );
	    Toernooi toernooi = new Toernooi(naam);
	    new ToernooiSubMenu(toernooi).toon();
	}
}
