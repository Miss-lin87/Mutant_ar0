package java.se.linda;

import java.se.linda.enums.stats;
import java.util.ArrayList;
import java.util.HashMap;

import static java.se.linda.enums.stats.*;


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
    static HashMap<stats,Integer> make_stats_list(){
        HashMap<stats, Integer> stats_list = new HashMap<>();
        stats_list.put(STYRKA, 2);
        stats_list.put(KYLA, 2);
        stats_list.put(SKÄRPA, 2);
        stats_list.put(KÄNSLA, 2);
        return stats_list;
    }
}