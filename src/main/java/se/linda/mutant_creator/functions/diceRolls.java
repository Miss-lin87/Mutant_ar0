package se.linda.mutant_creator.functions;

import java.util.Optional;
import java.util.Random;

public class diceRolls {
    private final Random rand = new Random();

    public int D6(Optional<Integer> times) {
        if (times.isPresent() && times.get() > 0) {
            return roll(times.get());
        } else {
            return roll(1);
        }
    }

    private int roll(int times, int number) {
        if (times == 0) {
            return number;
        } else {
            number += rand.nextInt(6)+1;
            return roll(times-1, number);
        }
    }

    private int roll(int times) {
        return roll(times, 0);
    }

    public String D66(){
        return roll(1) + "" + roll(1);
    }


}