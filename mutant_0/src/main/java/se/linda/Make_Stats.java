package se.linda;
import java.util.ArrayList;
import java.util.HashMap;

public class Make_Stats {
    static ArrayList make_range_stats(boolean prim_stat){
        ArrayList<Integer> Range_of_Stats = new ArrayList<>();
        Range_of_Stats.add(3);
        Range_of_Stats.add(4);
        if (prim_stat == true){
            Range_of_Stats.add(5);
            return Range_of_Stats;
        }
        else {
            return Range_of_Stats;
        }
    }
    static HashMap<String,Integer> make_stats_list(){
        HashMap<String, Integer> stats_list = new HashMap<>();
        stats_list.put("Styrka", 2);
        stats_list.put("Kyla", 2);
        stats_list.put("Skarpa", 2);
        stats_list.put("Kansla", 2);
        return stats_list;
    }
}