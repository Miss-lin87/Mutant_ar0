package se.linda.mutant_creator.enums;

public enum klasser {
    KROSSARE("Krossare"),
    SKROTSKALLE("Skrotskalle"),
    ZONSTRYKARE("Zonstrykare"),
    FIXARE("Fixare"),
    MUTANT_MED_HUND("Mutant med hund"),
    KRONIKOR("Krönikör"),
    BOSS("Boss"),
    SLAV("Slav");

    private String name;

    klasser(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}