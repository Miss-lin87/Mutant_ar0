package se.linda.mutant_creator;


import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;

public class Main {
    public static void main(String[] args) {
        MakeChar player = new MakeChar("Linda", klasser.KROSSARE);
        System.out.println(player.getPlayer().getTalent().getDescription(talanger.HÅRD_JÄVEL));
        System.out.println(player.getPlayer().getTalent().getTalents());
        System.out.println(player.getPlayer().getTalent().toString());
        System.out.println(player.getPlayer().getBasestats().toString());
        System.out.println(player.getPlayer().getEquipment().getEquipment());
        System.out.println(player.getPlayer().getEquipment().toString());
        System.out.println(player.getSkills().getSkills());
        System.out.println(player.getSkills().toString());
        player.getSkills().getSkills().replaceAll((färdigheter, number) -> number +1);
        System.out.println(player.getSkills().getSkills());
    }
}