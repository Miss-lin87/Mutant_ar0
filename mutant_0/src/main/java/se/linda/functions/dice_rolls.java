package java.se.linda.functions;

public class dice_rolls {

    public int D6(){
        return (int)(Math.random()*7);
    }

    public String D66(){
        return D6() + "" + D6();
    }

    public int D6(int times){
        int number = 0;
        for (int i = 0; i < times; i++) {
            number += D6();
        }
        return number;
    }
}