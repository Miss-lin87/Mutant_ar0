package se.linda.mutant_creator.contructors;

import net.minidev.json.parser.ParseException;
import se.linda.mutant_creator.enums.*;
import se.linda.mutant_creator.functions.savedCharFunctions;
import java.io.FileNotFoundException;
import java.util.Map;

public class tempData {
    private final String name;
    private final klasser klass;
    private final Map<fardigheter, Integer> skills;
    private final Map<stats, Integer> charStats;
    private final Map<specFardigheter, Integer> specSkill;
    private final Map<equipment, Integer> backpack;
    private final savedCharFunctions saved = new savedCharFunctions();

    public tempData(String name) throws FileNotFoundException, ParseException {
        this.name = name;
        this.klass = klasser.valueOf(saved.getTypeData(name, "klass").getAsString("klass"));
        this.skills = saved.makeMap(saved.getTypeData(name, "skills").getAsString("skills"), fardigheter.values());
        this.charStats = saved.makeMap(saved.getTypeData(name, "stats").getAsString("stats"), stats.values());
        this.specSkill = saved.makeMap(saved.getTypeData(name, "specSkill").getAsString("specSkill"), specFardigheter.values());
        this.backpack = saved.makeMap(saved.getTypeData(name, "backpack").getAsString("backpack"), equipment.values());
    }

    public String getName() {
        return name;
    }

    public klasser getKlass() {
        return klass;
    }

    public Map<fardigheter, Integer> getSkills() {
        return skills;
    }

    public Map<stats, Integer> getCharStats() {
        return charStats;
    }

    public Map<specFardigheter, Integer> getSpecSkill() {
        return specSkill;
    }

    public Map<equipment, Integer> getBackpack() {
        return backpack;
    }
}