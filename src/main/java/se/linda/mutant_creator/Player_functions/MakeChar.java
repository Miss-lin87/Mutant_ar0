package se.linda.mutant_creator.Player_functions;

import se.linda.mutant_creator.Player_functions.baseFunctions.playerKlass;
import se.linda.mutant_creator.enums.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeChar {
    private String name;
    private playerKlass player;
    private klasser klass;
    private HashMap<fardigheter, Integer>skills;
    private specFardigheter specSkill;
    private HashMap<stats, Integer> stats;
    private Map<equipment, Integer> backpack;

    public MakeChar(String name, klasser klass) {
        this.name = name;
        this.player = new playerKlass(klass);
        this.klass = player.getKlass();
        this.skills = player.getSkills().getSkills();
        this.specSkill = player.getSkills().getSpecSkills();
        this.stats = player.getBasestats().getAllStats();
        this.backpack = player.getEquipment().getEquipment();
    }

    private int setSkillBase(fardigheter fardighet) {
        int returnValue = 0;
        switch (fardighet) {
            case KAMPA_PA, TA_KRAFTTAG, SLASS -> returnValue = player.getBasestats().getStyrka();
            case SMYGA, FLY, SKJUTA -> returnValue = player.getBasestats().getKyla();
            case SPEJA, FORSTA_SIG_PÅ, KANNA_ZONEN -> returnValue = player.getBasestats().getSkärpa();
            case GENOMSKADA, MANIPULERA, VARDA -> returnValue = player.getBasestats().getKänsla();
        }
        return returnValue;
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public playerKlass getPlayer() {
        return this.player;
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
    public specFardigheter getSpecSkill() {
        return specSkill;
    }
    public HashMap<stats, Integer> getStats() {
        return stats;
    }
    public Map<equipment, Integer> getBackpack() {
        return backpack;
    }
    public List<Field> getFields() {
        List<Field> fields = new java.util.ArrayList<>(List.of(this.getClass().getDeclaredFields()));
        fields.remove(1);
        return fields;
    }

    public <T> T getFieldValue(Field field) {
        try {
            return (T) field.get(this);
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}