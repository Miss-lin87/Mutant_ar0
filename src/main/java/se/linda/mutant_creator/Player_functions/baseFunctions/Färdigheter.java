package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.färdigheter;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.specFärdigheter;

import java.util.HashMap;
import java.util.Map;

import static se.linda.mutant_creator.enums.specFärdigheter.*;


public class Färdigheter {
    private HashMap<färdigheter, Integer> skills = new HashMap<>();
    private specFärdigheter specSkills;

    private void getSpecSkill(klasser klass) {
        switch (klass) {
            case KROSSARE -> this.specSkills = MUCKA;
            case SKROTSKALLE -> this.specSkills = MECKA;
            case ZONSTRYKARE -> this.specSkills = LEDA_VÄGEN;
            case FIXARE -> this.specSkills = SCHACKRA;
            case MUTANT_MED_HUND -> this.specSkills = BUSSA_PÅ;
            case KRÖNIKÖR -> this.specSkills = INSPIRERA;
            case BOSS -> this.specSkills = KOMMENDERA;
            case SLAV -> this.specSkills = UTHÄRDA;
        }
    }

    public Färdigheter(klasser klass) {
        for (färdigheter F : färdigheter.values()) {
            this.skills.put(F, 0);
        }
        getSpecSkill(klass);
    }

    public specFärdigheter getSpecSkills() {
        return this.specSkills;
    }

    public HashMap<färdigheter, Integer> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Map.Entry<färdigheter, Integer> skill : skills.entrySet()) {
            temp.append(skill.getKey()).append(" : ").append(skill.getValue()).append("\n");
        }
        return temp.toString();
    }
}
