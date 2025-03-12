package se.linda;

import se.linda.Player_functions.MakeChar;
import se.linda.Player_functions.baseFunctions.Färdigheter;
import se.linda.enums.färdigheter;
import se.linda.enums.klasser;
import se.linda.enums.talanger;

public class Main {
    public static void main(String[] args) {
        MakeChar player = new MakeChar("Linda", klasser.KROSSARE);
        System.out.println(player.getPlayer().getTalent().getDescription(talanger.HÅRD_JÄVEL));
        System.out.println(player.getPlayer().getTalent().getTalents());
        System.out.println(player.getPlayer().getTalent().toString());
        System.out.println(player.getPlayer().getBeststat().toString());
        System.out.println(player.getPlayer().getEquipment().getEquipment());
        System.out.println(player.getPlayer().getEquipment().toString());
        System.out.println(player.getSkills().getSkills());
        System.out.println(player.getSkills().toString());
        player.getSkills().getSkills().replaceAll((färdigheter, number) -> number.intValue() +1);
        System.out.println(player.getSkills().getSkills());
    }
}