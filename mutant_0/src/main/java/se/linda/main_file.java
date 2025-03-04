package se.linda;
import java.util.HashMap;

public class main_file{
    public static void main(String[] args) {
        int stat_points = 10;
        Boolean valid;
        HashMap<String, Integer> completed_Stats = Make_Stats.make_stats_list();
        for (Object elem : completed_Stats.keySet()) {
            if (stat_points>0){
            System.out.println("You have: " + stat_points + " points left\n" + "What so you want to add to: " + elem.toString());
            Integer user_input = funcs.user_input_integer();
            while (valid = false){
                System.out.println("This is a test");
                stat_points --;
                if (stat_points == 0){valid = true;}
            }
        }
    }
}
}