package se.linda.Player_functions.baseFunctions;

import se.linda.enums.equipment;
import se.linda.enums.klasser;
import se.linda.functions.dice_rolls;

import java.util.EnumMap;
import java.util.Map;

import static se.linda.enums.equipment.*;


public class Equipment {
    private final dice_rolls D = new dice_rolls();
    private EnumMap<equipment, Integer> backpack = new EnumMap<>(Map.of(PATRONER, D.D6(), KRUBB, D.D6(), VATTEN, D.D6()));

    private void makeEqupiment(klasser klass) {
        switch (klass) {
            case KROSSARE -> this.backpack.replace(KRUBB, backpack.get(KRUBB), D.D6(2));
            case SKROTSKALLE, FIXARE -> this.backpack.replace(PATRONER, backpack.get(PATRONER), D.D6(2));
            case ZONSTRYKARE -> this.backpack.put(VATTEN, +D.D6());
            case MUTANT_MED_HUND, KRÖNIKÖR -> this.backpack.put(PATRONER, +0);
            case BOSS -> this.backpack.putAll(Map.of(PATRONER, +D.D6(), KRUBB, +D.D6()));
            case SLAV -> this.backpack.put(PATRONER, 0);
        }
    }

    public Equipment(klasser klass) {
        makeEqupiment(klass);
    }

    public Map<equipment, Integer> getEquipment() {
        return this.backpack;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (equipment equip : this.backpack.keySet()) {
            result.append(equip).append(" : ").append(backpack.get(equip)).append("\n");
        }
        return result.toString();
    }
}