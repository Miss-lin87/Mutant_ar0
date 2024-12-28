package se.linda;
import java.util.ArrayList;

public class Testing_stuff {
    static int random_index(int list_leanth){
        int number = (int)(Math.random()*list_leanth+1);
        return number;
        }
    static int get_list_lenth(ArrayList erray){
        int lenth_of_erray = erray.size();
        return lenth_of_erray;
    }
    public static void main(String[] args) {
        Integer number1 = 1;
        Integer steeps = 5;
        Integer number2 = 8;
        if (number1 == 1 && number2 == 8){
            System.out.println("This is a test number1");
        }
        if (number2 > steeps){
            System.out.println("This is a test number2");
        }
    }
}