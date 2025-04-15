package se.linda.mutant_creator.functions;

import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.specFardigheter;
import se.linda.mutant_creator.enums.stats;

import java.util.ArrayList;
import java.util.List;

import static se.linda.mutant_creator.enums.klasser.*;
import static se.linda.mutant_creator.enums.specFardigheter.*;

public class converters {

    public <T> T stringTOEnum(String name, T[] enumValues) {
        T temp = null;
        for (T value : enumValues) {
            name = name.toUpperCase()
                    .replace("Å", "A")
                    .replace("Ä", "A")
                    .replace("Ö", "O")
                    .replace(" ", "_");
            if (name.equals(value.toString())) {
                temp = value;
            }
        }
        return temp;
    }

    public List<String> getKlassList(stats stat) {
        List<String> tempKlassser = new ArrayList<>();
        switch (stat) {
            case STYRKA -> tempKlassser.add(KROSSARE.getName());
            case SKARPA -> tempKlassser.add(SKROTSKALLE.getName());
            case KYLA -> tempKlassser.addAll(List.of(ZONSTRYKARE.getName(),SLAV.getName(), MUTANT_MED_HUND.getName()));
            case KANSLA -> tempKlassser.addAll(List.of(FIXARE.getName(), KRONIKOR.getName(), BOSS.getName()));
        }
        return tempKlassser;
    }

    public specFardigheter findSpecSkill(klasser klass) {
        specFardigheter temp;
        switch (klass) {
            case KROSSARE -> temp = MUCKA;
            case SKROTSKALLE -> temp = MECKA;
            case ZONSTRYKARE -> temp = LEDA_VAGEN;
            case FIXARE -> temp = SCHACKRA;
            case MUTANT_MED_HUND -> temp = BUSSA_PA;
            case KRONIKOR -> temp = INSPIRERA;
            case BOSS -> temp = KOMMENDERA;
            case SLAV -> temp = UTHARDA;
            default -> throw new IllegalStateException("Unexpected: " + klass);
        }
        return temp;
    }
}