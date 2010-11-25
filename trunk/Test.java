public class Test{

    public static void printToernooi(){
        Toernooi toernooi = new Toernooi("UEFA");
        toernooi.addPoule("A", "Ajax", "PSV", "AZ", "NEC");
        toernooi.addPoule("B", "Besiktas", "Galatasaray", "Fenerbahce", "Trabzonspor");
        toernooi.addPoule("C", "Manchester city", "Arsenal", "Chelsea", "Liverpool");
        toernooi.addPoule("D", "Barcelona", "Real Madrid", "Valencia", "Atletico Madrid");
        System.out.println(toernooi.toString());
    }
    
    public static void printPoule(String letter){
        Toernooi toernooi = new Toernooi("UEFA");
        toernooi.addPoule("A", "Ajax", "PSV", "AZ", "NEC");
        toernooi.addPoule("B", "Besiktas", "Galatasaray", "Fenerbahce", "Trabzonspor");
        toernooi.addPoule("C", "Manchester United", "Arsenal", "Chelsea", "Liverpool");
        toernooi.addPoule("D", "Barcelona", "Real Madrid", "Valencia", "Atletico Madrid");
        System.out.println(toernooi.getPoule(letter).toString());
    }
    
    public static void printAlleTeams(){
        Toernooi toernooi = new Toernooi("UEFA");
        toernooi.addPoule("A", "TEST", "PSV", "AZ", "NEC");
        toernooi.addPoule("B", "Besiktas", "Galatasaray", "Fenerbahce", "Trabzonspor");
        toernooi.addPoule("C", "Manchester United", "Arsenal", "Chelsea", "Liverpool");
        toernooi.addPoule("D", "Barcelona", "Real Madrid", "Valencia", "Atletico Madrid");
        System.out.println(toernooi.getAlleTeams());
    }

}