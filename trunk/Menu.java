 

import java.util.ArrayList;

public class Menu{
    private ArrayList<String> menuItems = new ArrayList<String>();
    private String titel;
    private String inputVraag;
    private boolean stopItemToegevoegd = false;
    
    public Menu(String titel, String inputVraag){
        this.titel = titel;
        this.inputVraag = inputVraag;
    }
    
    public void addItem( String item ) {
		menuItems.add( item );
	}

	public void addStopItem( String item ) {
		menuItems.add( 0, item );
		stopItemToegevoegd = true;
	}
	
	public int getMenukeuze() {
		int keuze = -1;
 
		while ( keuze == -1 ) {
			toonMenu();
			keuze = TuiHelper.stelVraagMetGetalAntwoord( inputVraag );
		}

		return keuze;
	}
	
	private void toonMenu() {
		if ( !stopItemToegevoegd ) {
			addStopItem( "(FOUT!!! Er is nog geen stop item toegevoegd aan dit menu)" );
		}

		System.out.println( "\f"                            );
		System.out.println( "==================================" );
		System.out.printf ( "=  %-30s=\n", titel                 );
		System.out.println( "==================================" );

		for ( int i = 1; i < menuItems.size(); i++ ) {
			System.out.printf( "%3d. %s\n", i, menuItems.get( i ) );
		}
		System.out.printf( "%3d. %s\n", 0, menuItems.get( 0 ) );
	}
}
