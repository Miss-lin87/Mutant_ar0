package se.linda.mutant_creator.enums;

public enum färdigheter {
    KÄMPA_PÅ("Kämpa På","", 0),
    TA_KRAFTTAG("Ta Krafttag","", 0),
    SLÅSS("Slåss","", 0),
    SMYGA("Smyga","", 0),
    FLY("Fly","", 0),
    SKJUTA("Skjuta","", 0),
    SPEJA("Speja","", 0),
    FÖRSTÅ_SIG_PÅ("Förstå sig på","", 0),
    KÄNNA_ZONEN("Känna Zonen","", 0),
    GENOMSKÅDA("Genomskåda","", 0),
    MANIPULERA("Manipulera","", 0),
    VÅRDA("Vårda","", 0);

    private final String name;
    private final String descrip;
    private final int value;

    färdigheter(String name, String descrip, int value) {
        this.name = name;
        this.descrip = descrip;
        this.value = value;
    }
}
