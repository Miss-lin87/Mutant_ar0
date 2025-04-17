package se.linda.mutant_creator.Player_functions;

import se.linda.mutant_creator.enums.*;

import java.lang.reflect.Field;
import java.util.*;

import static se.linda.mutant_creator.enums.stats.*;

public class MakeChar {
    private final String name;
    private final klasser klass;
    private final Map<fardigheter, Integer> skills;
    private final Map<stats, Integer> stats;
    private Map<specFardigheter, Integer> specSkill;
    private final Map<equipment, Integer> backpack;

    public MakeChar(String name,
                    klasser klass,
                    Map<fardigheter, Integer> skillsMap,
                    Map<stats, Integer> statsMap,
                    Map<specFardigheter, Integer> specMap,
                    Map<equipment, Integer> backpack) {
        this.name = name;
        this.klass = klass;
        this.skills = skillsMap;
        this.stats = statsMap;
        this.specSkill = specMap;
        this.backpack = backpack;
    }

    private int setSkillBase(fardigheter fardighet) {
        int returnValue = 0;
        switch (fardighet) {
            case KAMPA_PA, TA_KRAFTTAG, SLASS -> returnValue = stats.get(STYRKA);
            case SMYGA, FLY, SKJUTA -> returnValue = stats.get(KYLA);
            case SPEJA, FORSTA_SIG_PA, KANNA_ZONEN -> returnValue = stats.get(SKARPA);
            case GENOMSKADA, MANIPULERA, VARDA -> returnValue = stats.get(KANSLA);
        }
        return returnValue;
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public klasser getKlass() {
        return this.klass;
    }
    public Map<fardigheter, Integer> getSkills() {
        skills.keySet().forEach(fardighet -> skills.put(fardighet, +setSkillBase(fardighet)));
        return this.skills;
    }
    public Map<stats, Integer> getStats() {
        return stats;
    }
    public Map<equipment, Integer> getBackpack() {
        return backpack;
    }
    public List<Field> getFields() {
        return new ArrayList<>(List.of(this.getClass().getDeclaredFields()));
    }

    public <T> T getFieldValue(Field field) {
        try {
            return (T) field.get(this);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }
}