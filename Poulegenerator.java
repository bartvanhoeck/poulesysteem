import java.util.*;
import java.io.*;

public class Poulegenerator{
    private ArrayList<String> teams;
    private Toernooi toernooi;
    
    public Poulegenerator(Toernooi toernooi){
        teams = new ArrayList<String>();
        this.toernooi = toernooi;
    }
    
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
            
    
    private String genereerPouleLetter(int index){
/*        switch (index){
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            case 5: return "E";
            case 6: return "F";
            case 7: return "G";
            case 8: return "H";
            case 9: return "I";
            case 10: return "J";
        }
*/
        return Character.toString((char)(64+index));
    }
            
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
