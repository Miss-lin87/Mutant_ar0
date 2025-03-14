package se.linda.mutant_creator.Player_functions;


import se.linda.mutant_creator.Player_functions.baseFunctions.Färdigheter;
import se.linda.mutant_creator.Player_functions.baseFunctions.playerKlass;
import se.linda.mutant_creator.enums.klasser;

public class MakeChar {
    private String name;
    private playerKlass player;
    private Färdigheter skills;

    public MakeChar(String name, klasser klass) {
        this.name = name;
        this.player = new playerKlass(klass);
        this.skills = new Färdigheter(klass);
    }

    public String getName() {
        return this.name;
    }

    public playerKlass getPlayer() {
        return this.player;
    }

    public Färdigheter getSkills() {
        return skills;
    }
}