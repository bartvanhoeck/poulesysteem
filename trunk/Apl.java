/**
 * De klasse <code>Apl</code>
 * 
 * De Apl is onze uitvoerbare klasse.
 * Dit zorgt ervoor dat de console word geopend met daarin onze TUI.
 * 
 * 
 * @author Kenny Ekkelboom, Peter Padberg, Tristan Weber
 * 
 */

public class Apl{

    public static void main(String[] args){
        new Hoofdmenu(new Poulesysteem()).toon();
    }

}
