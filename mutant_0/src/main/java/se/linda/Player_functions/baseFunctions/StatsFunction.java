package se.linda.Player_functions.baseFunctions;

import se.linda.enums.stats;

import java.util.HashMap;

import static se.linda.enums.stats.*;

public class StatsFunction {

    public void changeStats(HashMap<stats, Integer> statsList, stats bestStat) {

    }
    public HashMap<stats,Integer> make_stats_list(){
        HashMap<stats, Integer> stats_list = new HashMap<>();
        stats_list.put(STYRKA, 2);
        stats_list.put(KYLA, 2);
        stats_list.put(SKÄRPA, 2);
        stats_list.put(KÄNSLA, 2);
        return stats_list;
    }
}