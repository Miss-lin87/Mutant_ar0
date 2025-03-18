package se.linda.mutant_creator.enums;

public enum equipment {
    PATRONER("Patroner",0),
    KRUBB("Krubb",0),
    VATTEN("Vatten",0);

    public final String name;
    public final int value;

    equipment (String name, int value) {
        this.name = name;
        this.value = value;
    }
}
