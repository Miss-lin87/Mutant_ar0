package se.linda.mutant_creator.enums;

public enum fardigheter {
    KAMPA_PA("Kämpa På","", 0),
    TA_KRAFTTAG("Ta Krafttag","", 0),
    SLASS("Slåss","", 0),
    SMYGA("Smyga","", 0),
    FLY("Fly","", 0),
    SKJUTA("Skjuta","", 0),
    SPEJA("Speja","", 0),
    FORSTA_SIG_PÅ("Förstå sig på","", 0),
    KANNA_ZONEN("Känna Zonen","", 0),
    GENOMSKADA("Genomskåda","", 0),
    MANIPULERA("Manipulera","", 0),
    VARDA("Vårda","", 0);

    private final String name;
    private final String descrip;
    private final int value;

    fardigheter(String name, String descrip, int value) {
        this.name = name;
        this.descrip = descrip;
        this.value = value;
    }
}
