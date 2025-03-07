package se.linda;


import java.se.linda.enums.klasser;
import java.se.linda.player_classes.baseFunctions.Beststat;

import static java.se.linda.enums.klasser.KROSSARE;

public class Main {
    public static void main(String[] args) {
        Beststat stat = new Beststat(KROSSARE);
        System.out.println(stat.getBeststat().toString());
    }
}