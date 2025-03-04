package se.linda.player_classes;

public class playerKlass {
    String name;
    String klass;
    Beststat beststat;
    Talent talent;
    Equipment equipment;
    String specialEquipment;

    void newKlass(String name, String klass){
        this.name = name;
        this.klass = klass;
        this.beststat = new Beststat(klass);
        this.talent = new Talent(klass);
        this.equipment = new Equipment(klass);
        this.specialEquipment = "";
    }
}
