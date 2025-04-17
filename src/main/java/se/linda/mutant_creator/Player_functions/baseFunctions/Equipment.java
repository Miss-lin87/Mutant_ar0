package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.equipment;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.functions.diceRolls;
import se.linda.mutant_creator.functions.funcs;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static se.linda.mutant_creator.enums.equipment.*;


public class Equipment {
    private final diceRolls D = new diceRolls();
    private final Optional<Integer> one = new funcs().getOptional(1);
    private EnumMap<equipment, Integer> backpack = new EnumMap<>(Map.of(PATRONER, D.D6(one), KRUBB, D.D6(one), VATTEN, D.D6(one)));

    private void makeEqupiment(klasser klass) {
        switch (klass) {
            case KROSSARE -> this.backpack.replace(KRUBB, backpack.get(KRUBB), +D.D6(one));
            case SKROTSKALLE, FIXARE -> this.backpack.replace(PATRONER, backpack.get(PATRONER), +D.D6(one));
            case ZONSTRYKARE -> this.backpack.put(VATTEN, +D.D6(one));
            case MUTANT_MED_HUND, KRONIKOR -> {}
            case BOSS -> this.backpack.putAll(Map.of(PATRONER, +D.D6(one), KRUBB, +D.D6(one)));
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