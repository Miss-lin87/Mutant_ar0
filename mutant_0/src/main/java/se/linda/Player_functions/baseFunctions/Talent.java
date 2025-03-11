package se.linda.Player_functions.baseFunctions;

import se.linda.enums.klasser;
import se.linda.enums.talanger;

import java.util.ArrayList;
import java.util.List;

import static se.linda.enums.talanger.*;

public class Talent {
    private final List<talanger> talents;

    private List<talanger> make_list(klasser klass){
        switch (klass){
            case KROSSARE -> {
                return new ArrayList<>(List.of(HÅRD_JÄVEL, NJURSLAG, ÖVERVÅLD));
            }
            case SKROTSKALLE -> {
                return new ArrayList<>(List.of(MOTORSKALLE, REPARATÖR, UPPFINNARE));
            }
            case ZONSTRYKARE -> {
                return new ArrayList<>(List.of(MONSTERJÄGARE, RÖTNOS, SAKLETARE));
            }
            case FIXARE -> {
                return new ArrayList<>(List.of(ELAK_JÄVEL, STORHANDLARE, HÅLLHAKE));
            }
            case MUTANT_MED_HUND -> {
                return new ArrayList<>(List.of(BLODHUND, KAMPHUND, MUTANTS_BÄSTA_VÄN));
            }
            case KRÖNIKÖR -> {
                return new ArrayList<>(List.of(ARTIST, HELARE, VÅLDSHETSARE));
            }
            case BOSS -> {
                return new ArrayList<>(List.of(ARKENS_BESKYDDARE, KOMMENDANT, REVOLTERMÄN));
            }
            case SLAV -> {
                return new ArrayList<>(List.of(OBRYDD, SLAGTÅLIG, REBELL));
            }
        }
        return null;
    }

    public Talent(klasser klass) {
        this.talents = make_list(klass);
    }

    public List<talanger> getTalents(){
        return this.talents;
    }

    public String getDescription(talanger talang) {
        return talang + " : " + talang.descrip;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (talanger talang : talents) {
            result.append(talang).append(" : ").append(talang.descrip).append("\n");
        }
        return result.toString();
    }
}
