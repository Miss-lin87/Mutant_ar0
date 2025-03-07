package se.linda.Player_functions.baseFunctions;

import se.linda.enums.equipment;
import se.linda.enums.klasser;
import se.linda.functions.dice_rolls;

import java.util.HashMap;
import java.util.Map;

import static se.linda.enums.equipment.*;


public class Equipment {
    private final dice_rolls D = new dice_rolls();
    private Map<equipment, Integer> backpack = new HashMap<>(Map.of(PATRONER, D.D6(1) , KRUBB, D.D6(1), VATTEN, D.D6(1)));

    private Map<equipment, Integer> makeEqupiment(klasser klass){
        switch (klass) {
            case KROSSARE -> this.backpack.put(KRUBB, +D.D6());
            case SKROTSKALLE, FIXARE -> this.backpack.put(PATRONER, +D.D6());
            case ZONSTRYKARE -> this.backpack.put(VATTEN, +D.D6());
            case MUTANT_MED_HUND, KRÖNIKÖR -> this.backpack.put(PATRONER, +0);
            case BOSS -> this.backpack.putAll(Map.of(PATRONER, +D.D6(), KRUBB, +D.D6()));
            case SLAV -> this.backpack.put(PATRONER, 0);
        }
        return null;
    }

    public Equipment(klasser klass) {
        this.backpack = makeEqupiment(klass);
    }

    public Map<equipment, Integer> getEquipment() {
        return this.backpack;
    }
}