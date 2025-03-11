package se.linda.Player_functions.baseFunctions;


import se.linda.enums.klasser;

public class playerKlass {
    private final klasser klass;
    private final Basestats beststat;
    private final Talent talent;
    private final Equipment equipment;

    public playerKlass(klasser klass){
        this.klass = klass;
        this.beststat = new Basestats(klass);
        this.talent = new Talent(klass);
        this.equipment = new Equipment(klass);
    }

    //Getters
    public Basestats getBeststat() {
        return this.beststat;
    }
    public klasser getKlass() {
        return this.klass;
    }
    public Equipment getEquipment() {
        return this.equipment;
    }
    public Talent getTalent() {
        return this.talent;
    }
}