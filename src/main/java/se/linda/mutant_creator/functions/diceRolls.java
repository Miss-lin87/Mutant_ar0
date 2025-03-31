package se.linda.mutant_creator.functions;

import java.util.Optional;
import java.util.Random;

public class diceRolls {

    public int D6(Optional<Integer> times) {
        if (times.isPresent() && times.get() > 0) {
            return D6(times.get());
        } else {
            return D6(1);
        }
    }

    private int D6(int times, int number) {
        if (times == 0) {
            return number;
        } else {
            number += new Random().nextInt(6)+1;
            return D6(times-1, number);
        }
    }

    private int D6(int times) {
        return D6(times, 0);
    }

    public String D66(){
        return D6(1) + "" + D6(1);
    }


}