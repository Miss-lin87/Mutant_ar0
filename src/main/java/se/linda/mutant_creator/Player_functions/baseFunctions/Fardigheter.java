package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.fardigheter;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.specFardigheter;
import java.util.HashMap;
import java.util.Map;

import static se.linda.mutant_creator.enums.specFardigheter.*;

public class Fardigheter {
    private Map<fardigheter, Integer> skills;
    private specFardigheter specSkills;

    public Fardigheter(klasser klass) {
        for (fardigheter F : fardigheter.values()) {
            this.skills.put(F, 0);
        }
        getSpecSkill(klass);
    }

    private void getSpecSkill(klasser klass) {
        switch (klass) {
            case KROSSARE -> this.specSkills = MUCKA;
            case SKROTSKALLE -> this.specSkills = MECKA;
            case ZONSTRYKARE -> this.specSkills = LEDA_VAGEN;
            case FIXARE -> this.specSkills = SCHACKRA;
            case MUTANT_MED_HUND -> this.specSkills = BUSSA_PA;
            case KRONIKOR -> this.specSkills = INSPIRERA;
            case BOSS -> this.specSkills = KOMMENDERA;
            case SLAV -> this.specSkills = UTHARDA;
        }
    }

    public specFardigheter getSpecSkills() {
        return this.specSkills;
    }

    public Map<fardigheter, Integer> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Map.Entry<fardigheter, Integer> skill : skills.entrySet()) {
            temp.append(skill.getKey()).append(" : ").append(skill.getValue()).append("\n");
        }
        return temp.toString();
    }
}
