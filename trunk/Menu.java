import java.util.ArrayList;

/**
 * De klasse <code>Menu</code>
 * 
 * Menu dient als het geraamte voor de rest van de menus.
 * Hier staat beschreven hoe het menu is opgebouwd.
 * Ieder menu in ons poulesysteem kan erven dan dit menu.
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class Menu{
    private ArrayList<String> menuItems = new ArrayList<String>();
    private String titel;
    private String inputVraag;
    private boolean stopItemToegevoegd = false;
    
     /**
     * De constructor <code>Menu</code> maakt een object aan van menu.
     * Dit bestaat in principe uit een titel en een openings vraag.
     */
    
    public Menu(String titel, String inputVraag){
        this.titel = titel;
        this.inputVraag = inputVraag;
    }
    
      /**
     * De methode <code>addItem()</code> maakt het mogelijk een nieuwe keuze aan het menu toe te voegen.
     */
    
    public void addItem( String item ) {
        menuItems.add( item );
    }

      /**
     * De methode <code>addStopItem()</code> voegt een stopkeuze aan het menu.
     * Dit is de enige manier om het menu af te sluiten.
     */
    
    public void addStopItem( String item ) {
        menuItems.add( 0, item );
        stopItemToegevoegd = true;
    }
    
      /**
     * De methode <code>getMenukeuze()</code> toont een menu zolang de keuze -1 is.
     * Bij een geldige keuze verandert de waarde en gaat het programma verder.
     * Bij een ongeldige keuze blijft het -1 en zal hij het menu opnieuw tonen.
     */
    
    public int getMenukeuze() {
        int keuze = -1;
 
        while ( keuze == -1 ) {
            toonMenu();
            keuze = TuiHelper.stelVraagMetGetalAntwoord( inputVraag );
        }

        return keuze;
    }
    
         /**
     * De methode <code>toonMenu()</code> geeft de daadwerkelijke text based weergave.
     * Ook plaatst het de items van het betreffende menu
     */
    
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
