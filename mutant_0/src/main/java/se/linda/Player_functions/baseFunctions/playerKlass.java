package se.linda.Player_functions.baseFunctions;


import se.linda.enums.klasser;

public class playerKlass {
    private String name;
    private klasser klass;
    private Basestats beststat;
    private Talent talent;
    private Equipment equipment;
    private String specialEquipment;

    public playerKlass(String name, klasser klass){
        this.name = name;
        this.klass = klass;
        this.beststat = new Basestats(klass);
        this.talent = new Talent(klass);
        this.equipment = new Equipment(klass);
        this.specialEquipment = "";
    }

    //Getters
    public Basestats getBeststat() {
        return beststat;
    }
    public klasser getKlass() {
        return klass;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public String getName() {
        return name;
    }
    public Talent getTalent() {
        return talent;
    }
    public String getSpecialEquipment() {
        return specialEquipment;
    }
}
