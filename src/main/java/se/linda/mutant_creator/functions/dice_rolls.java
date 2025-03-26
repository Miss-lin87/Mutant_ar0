package se.linda.mutant_creator.functions;

import java.util.Optional;

public class dice_rolls {

    public int D6(Optional<Integer> times) {
        if (times.get() != 0 || times.get() > 0) {
            return D6(times.get());
        } else {
            throw new IllegalArgumentException("Number of times must be greater than 0");
        }
    }

    public int D6() {
        int roll = (int)(Math.random()*7);
        if (roll == 0) {
            D6();
        } else {
            return roll;
        }
        return roll;
    }

    public int D6(int times) {
        int number = 0;
        for (int i = 0; i < times; i++) {
            number += D6();
        }
        return number;
    }

    public String D66(){
        return D6() + "" + D6();
    }


}