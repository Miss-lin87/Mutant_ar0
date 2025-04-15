package se.linda.mutant_creator.enums;

public enum stats {
    STYRKA("Styrka"),
    KYLA("Kyla"),
    SKARPA("Skärpa"),
    KANSLA("Känsla");

    public final String name;

    stats (String name) {
        this.name = name;
    }
}