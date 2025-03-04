package se.linda.player_classes;

import java.util.ArrayList;
import java.util.List;

public class Talent {
    private final List<String> talents;

    private List<String> make_list(String klass){
        List<String> talentraw = null;
        switch (klass){
            case "krossare" -> talentraw = new ArrayList<>(List.of("Hård jävel", "Njurslag", "Övervåld"));
            case "skrotskalle" -> talentraw = new ArrayList<>(List.of("Motorskalle", "Reparatör", "Uppfinnare"));
            case "zonstrykare" -> talentraw = new ArrayList<>(List.of("Monsterjägare", "Rötnos", "Sakletare"));
            case "fixare" -> talentraw = new ArrayList<>(List.of("Elak jävel", "Storhandlare", "Hållhake"));
            case "mutant med hund" -> talentraw = new ArrayList<>(List.of("Blodhund", "Kamphund", "Mutantens bästa vän"));
            case "krönikör" -> talentraw = new ArrayList<>(List.of("Artist", "Helare", "Våldshetsare"));
            case "boss" -> talentraw = new ArrayList<>(List.of("Arkens beskyddare", "Kommendant", "Revolvermän"));
            case "slav" -> talentraw = new ArrayList<>(List.of("Obrydd", "Slagtålig", "Rebell"));
        }
        return talentraw;
    }

    public Talent(String klass) {
        this.talents = make_list(klass);
    }

    public List<String> getTalents(){
        return talents;
    }
}
