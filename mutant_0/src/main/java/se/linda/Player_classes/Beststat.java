package se.linda.player_classes;

public class Beststat{
    private String best_stat;

    private String findStat(String klass){
        String stat = "";
        switch(klass){
            case "krossare" -> stat = "";
            case "skrotskalle" -> stat = "";
            case "zonstrykare" -> stat = "";
            case "fixare" -> stat = "";
            case"mutant med hund" -> stat = "";
            case "krönikör" -> stat = "";
            case "boss" -> stat = "";
            case "slav" -> stat = "";
        }
        return stat;
    }

    public Beststat(String klass){
        this.best_stat = findStat(klass);
    }

    public String getBeststat(){
        return best_stat;
    }
}