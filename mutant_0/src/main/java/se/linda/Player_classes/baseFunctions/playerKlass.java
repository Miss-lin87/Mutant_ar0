package java.se.linda.player_classes.baseFunctions;


import java.se.linda.enums.klasser;

public class playerKlass {
    private String name;
    private klasser klass;
    private Beststat beststat;
    private Talent talent;
    private Equipment equipment;
    private String specialEquipment;

    void newKlass(String name, klasser klass){
        this.name = name;
        this.klass = klass;
        this.beststat = new Beststat(klass);
        this.talent = new Talent(klass);
        this.equipment = new Equipment(klass);
        this.specialEquipment = "";
    }
}
