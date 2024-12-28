package se.linda;
import java.util.ArrayList;

public class dice_rolls {
    static ArrayList<Integer> make_array_index(int list_leanth){
        ArrayList<Integer> range_numbers = new ArrayList<>();
        while (list_leanth > -1){
        range_numbers.add(list_leanth);
        list_leanth --;
        }
        return range_numbers;
    }

    static int D6(){
        int roll = (int)(Math.random()*7);
        switch (roll) {
            case 0 -> { D6();
            }
            default -> System.out.println(roll); 
        }
        return roll;
    }

    static String D66(){
        String total_value = String.valueOf(D6()) + "" + String.valueOf(D6());
        return total_value;
    }

    static ArrayList<String> make_array_choises(){
        ArrayList<String> Choises = new ArrayList<>();
        Choises.add("Value1");
        Choises.add("Value2");
        Choises.add("Value3");
        Choises.add("Value4");
        return Choises;
    }
    public static void main(String[] args) {
        ArrayList<String> choises_list = make_array_choises();
        int how_long_is_choise = Testing_stuff.get_list_lenth(choises_list);
        int x =(int)(Math.random()*how_long_is_choise);
        do { 
            System.out.println(D6());
        } while (true);
        // System.out.println(x);
        // System.out.println(choises_list);
        // System.out.println(make_array_choises().get(x));
    }
}