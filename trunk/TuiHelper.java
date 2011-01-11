 

import java.util.Calendar;
import java.util.Scanner;

/**
 * Hulpclass voor tekstgebaseerde menu's. Best een complexe klasse dus als
 * je deze niet begrijpt, geen probleem. Er zitten ook foutafhandeling
 * (exception handling) in, wat in latere modules pas aan bod komt * 
 * @author Etto Salomons en Douwe van Twillert
 * 
 */
public class TuiHelper {

    static Scanner scan = new Scanner( System.in );

    public static String stelVraagMetTekstAntwoord( String vraag ) {
        return stelVraagMetTekstAntwoord( vraag, null );
    }

    public static String stelVraagMetTekstAntwoord( String vraag, String header ) {
        if ( header != null ) {
            System.out.println( "========================" );
            System.out.println( header                     );
        }
        System.out.println( vraag );

        return scan.nextLine();
    }
    
    public static String stelVraagMetPouleLetterAntwoord( String vraag) {
        System.out.println( vraag );
        
        String antwoord = scan.nextLine();
        if(antwoord.length()>1){
            System.err.println("Invoer '"+ antwoord +"' is geen geldige poule-aanduiding.");
            return stelVraagMetPouleLetterAntwoord(vraag);
        } else{
            return antwoord;
        }
    }

    public static int stelVraagMetGetalAntwoord( String vraag ) {
        return stelVraagMetGetalAntwoord( vraag, null, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    public static int stelVraagMetGetalAntwoord( String vraag, String header, int laagstMogelijkeWaarde, int hoogsteMogelijkeWaarde ) {
        try {
            int antwoord = Integer.parseInt( stelVraagMetTekstAntwoord( vraag, header ) );
            if ( antwoord < laagstMogelijkeWaarde || antwoord > hoogsteMogelijkeWaarde ) {
                System.err.println( "getal" + antwoord + "niet tussen " + laagstMogelijkeWaarde + " en " + hoogsteMogelijkeWaarde );
                TuiHelper.wacht( 1000 );
                return stelVraagMetGetalAntwoord( vraag, header, laagstMogelijkeWaarde,  hoogsteMogelijkeWaarde );
            } else {
                return antwoord;
            }
        } catch ( NumberFormatException nfe ) {
            System.err.println( "Fout: geen getal, voer een getal in" );
            TuiHelper.wacht( 1000 );
            return stelVraagMetGetalAntwoord( vraag, header, laagstMogelijkeWaarde,  hoogsteMogelijkeWaarde );
        }
    }

    public static void drukafDrukEnterEnWachtOpEnter() {
        System.out.println( "\n<-- druk enter -->" );
        scan.nextLine();
    }

    public static void wacht( int milliseconds ) {
        try {
            Thread.sleep( milliseconds );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
    
    public static int huidigeJaar() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get( Calendar.YEAR );
    }
}
