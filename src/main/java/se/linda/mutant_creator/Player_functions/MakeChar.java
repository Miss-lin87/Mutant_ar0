package se.linda.mutant_creator.Player_functions;

import se.linda.mutant_creator.enums.*;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static se.linda.mutant_creator.enums.stats.*;

public class MakeChar {
    private String name;
    private klasser klass;
    private HashMap<fardigheter, Integer>skills;
    private EnumMap<stats, Integer> stats;
    private HashMap<specFardigheter, Integer> specSkill;
    private Map<equipment, Integer> backpack;

    public MakeChar(String name,
                    klasser klass,
                    HashMap<fardigheter, Integer> skillsMap,
                    EnumMap<stats, Integer> statsMap,
                    HashMap<specFardigheter, Integer> specMap,
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
            case SPEJA, FORSTA_SIG_PÅ, KANNA_ZONEN -> returnValue = stats.get(SKARPA);
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
    public HashMap<fardigheter, Integer> getSkills() {
        for (fardigheter fardighet : skills.keySet()) {
            skills.put(fardighet, +setSkillBase(fardighet));
        }
        return this.skills;
    }
    public EnumMap<stats, Integer> getStats() {
        return stats;
    }
    public Map<equipment, Integer> getBackpack() {
        return backpack;
    }
    public List<Field> getFields() {
        List<Field> fields = new java.util.ArrayList<>(List.of(this.getClass().getDeclaredFields()));
        return fields;
    }

    public <T> T getFieldValue(Field field) {
        try {
            return (T) field.get(this);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        return null;
    }
}