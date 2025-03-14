package se.linda.mutant_creator.functions;


import se.linda.mutant_creator.Player_functions.baseFunctions.playerKlass;
import se.linda.mutant_creator.enums.stats;

import java.util.Scanner;

public class StatsFunction {
    Scanner input = new Scanner(System.in);

    private void printStats(playerKlass player) {
        System.out.println(player.getBasestats().toString());
    }

    private boolean statChange (stats stat, playerKlass player, int value) {
        int base = player.getBasestats().getStat(stat);
        player.getBasestats().setStat(stat, value);
        if (player.getBasestats().getStat(stat) == base) {
            return false;
        } else {
            return true;
        }
    }

    public void changeStats(playerKlass player) {
        int points = 6;
        do {
            System.out.println("You have " + points + " Points left");
            printStats(player);
        } while (points != 0);
    }
}