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
            case KROSSARE -> temp = List.of(HARD_JAVEL, NJURSLAG, OVERVALD);
            case SKROTSKALLE -> temp = List.of(MOTORSKALLE, REPARATOR, UPPFINNARE);
            case ZONSTRYKARE -> temp = List.of(MONSTERJAGARE, ROTNOS, SAKLETARE);
            case FIXARE -> temp = List.of(ELAK_JAVEL, STORHANDLARE, HALLHAKE);
            case MUTANT_MED_HUND -> temp = List.of(BLODHUND, KAMPHUND, MUTANTS_BASTA_VAN);
            case KRONIKOR -> temp = List.of(ARTIST, HELARE, VALDSHETSARE);
            case BOSS -> temp = List.of(ARKENS_BESKYDDARE, KOMMENDANT, REVOLTERMAN);
            case SLAV -> temp = List.of(OBRYDD, SLAGTALIG, REBELL);
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
        return talang + ":\n" + talang.getDescrip();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (talanger talang : talents) {
            result.append(talang).append(" : ").append(talang.getDescrip()).append("\n");
        }
        return result.toString();
    }
}
