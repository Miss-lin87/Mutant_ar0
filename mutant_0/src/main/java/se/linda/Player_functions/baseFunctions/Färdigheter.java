package se.linda.Player_functions.baseFunctions;

import se.linda.enums.färdigheter;
import se.linda.enums.klasser;
import se.linda.enums.specFärdigheter;

import java.util.EnumMap;
import java.util.Map;

import static se.linda.enums.specFärdigheter.*;

public class Färdigheter {
    private final EnumMap<färdigheter, Integer> skills;
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
        this.skills = new EnumMap<>(färdigheter.class);
        getSpecSkill(klass);
    }

    public void setSkills() {
        for (Map.Entry<färdigheter, Integer> skill : skills.entrySet()) {
            skills.put(skill.getKey(), 0);
        }
    }

    public specFärdigheter getSpecSkills() {
        return this.specSkills;
    }

    public EnumMap<färdigheter, Integer> getSkills() {
        return skills;
    }
}
