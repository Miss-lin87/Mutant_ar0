package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.klasser;

public class playerKlass {
    private final klasser klass;
    private final Basestats basestats;
    private final Talent talent;
    private final Equipment equipment;

    public playerKlass(klasser klass){
        this.klass = klass;
        this.basestats = new Basestats(klass);
        this.talent = new Talent(klass);
        this.equipment = new Equipment(klass);
    }

    //Getters
    public Basestats getBasestats() {
        return this.basestats;
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