package se.linda.mutant_creator.functions;

public class dice_rolls {

    public int D6() {
        int roll = (int)(Math.random()*7);
        if (roll == 0) {
            D6();
        } else {
            return roll;
        }
        return 1;
    }

    public String D66(){
        return D6() + "" + D6();
    }

    public int D6(int times) {
        int number = 0;
        for (int i = 0; i < times; i++) {
            number += D6();
        }
        return number;
    }
}