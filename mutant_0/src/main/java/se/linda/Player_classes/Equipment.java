package se.linda.player_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.linda.functions.dice_rolls;

public class Equipment {
    private Map<String, Integer> equipment;

    private Map<String, Integer> make_equpiment(String klass){
        dice_rolls D = new dice_rolls();
        Map<String, Integer> equipmentlist = null;
        switch (klass) {
            case "krossare" -> equipmentlist = new HashMap<>(Map.of("Patroner", D.D6(1) , "Krubb", D.D6(2), "Vatten", D.D6(1)));
            case "skrotskalle" -> equipmentlist = new HashMap<>(Map.of("Patroner", D.D6(2), "Krubb", D.D6(1), "Vatten", D.D6(1)));
            case "zonstrykare" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
            case "fixare" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
            case "mutant med hund" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
            case "krönikör" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
            case "boss" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
            case "slav" -> equipmentlist = new HashMap<>(Map.of("Patroner", 0, "Krubb", 0, "Vatten", 0));
        }
        return equipmentlist;
    }

    public Equipment(String klass) {
        this.equipment = make_equpiment(klass);
    }

    public Map<String, Integer> getEquipment() {
        return equipment;
    }
}