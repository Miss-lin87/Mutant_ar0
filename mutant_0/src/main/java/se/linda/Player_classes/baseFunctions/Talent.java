package java.se.linda.player_classes.baseFunctions;


import java.se.linda.enums.klasser;
import java.util.ArrayList;
import java.util.List;

public class Talent {
    private final List<String> talents;

    private List<String> make_list(klasser klass){
        switch (klass){
            case KROSSARE -> {
                return new ArrayList<>(List.of("Hård jävel", "Njurslag", "Övervåld"));
            }
            case SKROTSKALLE -> {
                return new ArrayList<>(List.of("Motorskalle", "Reparatör", "Uppfinnare"));
            }
            case ZONSTRYKARE -> {
                return new ArrayList<>(List.of("Monsterjägare", "Rötnos", "Sakletare"));
            }
            case FIXARE -> {
                return new ArrayList<>(List.of("Elak jävel", "Storhandlare", "Hållhake"));
            }
            case MUTANT_MED_HUND -> {
                return new ArrayList<>(List.of("Blodhund", "Kamphund", "Mutantens bästa vän"));
            }
            case KRÖNIKÖR -> {
                return new ArrayList<>(List.of("Artist", "Helare", "Våldshetsare"));
            }
            case BOSS -> {
                return new ArrayList<>(List.of("Arkens beskyddare", "Kommendant", "Revolvermän"));
            }
            case SLAV -> {
                return new ArrayList<>(List.of("Obrydd", "Slagtålig", "Rebell"));
            }
        }
        return null;
    }

    public Talent(klasser klass) {
        this.talents = make_list(klass);
    }

    public List<String> getTalents(){
        return this.talents;
    }
}
