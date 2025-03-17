package se.linda.mutant_creator.Player_functions.baseFunctions;


import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;

import java.util.List;

import static se.linda.mutant_creator.enums.talanger.*;

public class Talent {
    private final List<talanger> talents;

    private List<talanger> makeList(klasser klass){
        List<talanger> temp = List.of();
        switch (klass){
            case KROSSARE -> temp = List.of(HÅRD_JÄVEL, NJURSLAG, ÖVERVÅLD);
            case SKROTSKALLE -> temp = List.of(MOTORSKALLE, REPARATÖR, UPPFINNARE);
            case ZONSTRYKARE -> temp = List.of(MONSTERJÄGARE, RÖTNOS, SAKLETARE);
            case FIXARE -> temp = List.of(ELAK_JÄVEL, STORHANDLARE, HÅLLHAKE);
            case MUTANT_MED_HUND -> temp = List.of(BLODHUND, KAMPHUND, MUTANTS_BÄSTA_VÄN);
            case KRÖNIKÖR -> temp = List.of(ARTIST, HELARE, VÅLDSHETSARE);
            case BOSS -> temp = List.of(ARKENS_BESKYDDARE, KOMMENDANT, REVOLTERMÄN);
            case SLAV -> temp = List.of(OBRYDD, SLAGTÅLIG, REBELL);
        }
        return temp;
    }

    public Talent(klasser klass) {
        this.talents = makeList(klass);
    }

    public List<talanger> getTalents(){
        return this.talents;
    }

    public String getDescription(talanger talang) {
        return talang + ":\n" + talang.descrip;
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
