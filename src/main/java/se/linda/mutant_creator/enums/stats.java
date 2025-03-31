package se.linda.mutant_creator.enums;

public enum stats {
    STYRKA("Styrka",2),
    KYLA("Kyla",2),
    SKARPA("Skärpa",2),
    KANSLA("Känsla",2);

    public final String name;
    public final int value;

    stats (String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
