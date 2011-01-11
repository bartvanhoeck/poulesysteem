
import java.util.*;
import java.io.*;

/**
 * De klasse <code>Poulegenerator</code> dient voor het aanmaken en automatisch genereren van Poules
 * Dit doet hij d.m.v het inlezen van een textbestandje met daarin de Teams.
 * Elke keer als hij genereert worden er willekeurig teams in een poule geplaatst.
 * @author Burcay Bacak & Peter Padberg
 * @see Test
 */

public class Poulegenerator implements Serializable{
    private ArrayList<String> teams;
    private Toernooi toernooi;
    
    public Poulegenerator(Toernooi toernooi){
        teams = new ArrayList<String>();
        this.toernooi = toernooi;
    }
    
    /**
     * Methode genereerPoules leest vanuit een textbestand (teams.txt) alle teams.
     * Bij ieder team die wordt toegevoegd wordt er een teller bijgehouden
     * Zodra de teller boven de vier komt voegt hij de poule toe en begint hij weer van voor af aan.
     * Dit doet hij net zo lang totdat alle teams zijn ingedeeld.
     */
    public void genereerPoules(String teamlijst){
        this.leesTeamsUitBestand(teamlijst);
        int letterindex = 0;
        while (teams.size()>0){
            letterindex++;
            ArrayList<String> poule = new ArrayList<String>();
            while(poule.size()<4 && teams.size()>0){
                int index = (int)(Math.random()*teams.size());
                poule.add(teams.get(index));
                teams.remove(index);
            }
            
            toernooi.addPoule(this.genereerPouleLetter(letterindex),poule.get(0),poule.get(1),
            poule.get(2),poule.get(3));
            
        }
    }
    
    /**
     * Methode deelPoulesIn zorgt ervoor dat poules worden gedeeld over het aantal teams.
     * Stel er zijn zeventien teams, dan zullen er vier poules zijn met daarin vier teams.
     * In zo'n geval zullen de poules worden veranderd in poules met drie teams en een van vier.
     * Dit realiseerd deze methode door het aantal teams door vier te delen.
     * Hier zorgt Arrays.fill voor
     * 
     */
    public int[] deelPoulesIn(int aantalTeams){ //aantalTeams mag egen 5 zijn
        int[] indeling = null;
/*        switch(aantalTeams%4){
            case 0: indeling = new int[aantalTeams/4];
                    Arrays.fill(indeling, 4);
                    break;
            case 1: indeling = new int[aantalTeams/4+1];
                    Arrays.fill(indeling, 4);
                    Arrays.fill(indeling, indeling.length-3, indeling.length, 3);
                    break;
            case 2: indeling = new int[aantalTeams/4+1];
                    Arrays.fill(indeling, 4);
                    Arrays.fill(indeling, indeling.length-2, indeling.length, 3);
                    break;
            case 3: indeling = new int[aantalTeams/4+1];
                    Arrays.fill(indeling, 4);
                    Arrays.fill(indeling, indeling.length-1, indeling.length, 3);
                    break;
        }
*/        
        if(aantalTeams%4 == 0){
            indeling = new int[aantalTeams/4];
        } else{
            indeling = new int[aantalTeams/4+1];
        }
        Arrays.fill(indeling, 4); 
        Arrays.fill(indeling, indeling.length-(4-aantalTeams%4), indeling.length, 3);
        return indeling;
    }
            
    
    /**
     * Methode genereerPouleLetter zorgt ervoor dat de nieuw aangemaakte poules een letter krijgen.
     * Index wordt bij iedere poule die word aangemaakt met een verhoogd.
     * Vervolgens zal hij om een pouleletter toe te kennen gebruik maken van de ascii tabel.
     * De poule letter zal dus zijn 64 + index = pouleLetter
     * Het begint bij A en gaat tot Z
     * Hier kan je dus uit halen dat je maximaal 26 poules kan maken (tot Z)
     * @return bijv: 64 + index (bijv:3) = C  want 64 + 3 = 67 = C in ascii.
     * 
     */
    private String genereerPouleLetter(int index){

        return Character.toString((char)(64+index));
    }
            
    /**
     * Methode leesTeamsUitBestand leest de teams uit het tekstbestand d.m.v variabele textbestand.
     * textbestand heeft de definitie gekregen in onze testklasse
     * De methode geeft een error wanneer hij een textbestand niet kan lezen.
     */
    private void leesTeamsUitBestand(String textbestand) {
		try {
			BufferedReader bestand = new BufferedReader(new FileReader(textbestand));
			while(bestand.ready()) {
				String team = bestand.readLine();
				teams.add(team);
			}
		} catch (IOException e) {
			System.out.println("Fout tijdens teams inlezen");
		}
	}
    
    
}
