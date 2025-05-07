package se.linda.mutant_creator.enums;

public enum fardigheter {
    KAMPA_PA("Kämpa På",""),
    TA_KRAFTTAG("Ta Krafttag",""),
    SLASS("Slåss",""),
    SMYGA("Smyga",""),
    FLY("Fly",""),
    SKJUTA("Skjuta",""),
    SPEJA("Speja",""),
    FORSTA_SIG_PA("Förstå sig på",""),
    KANNA_ZONEN("Känna Zonen",""),
    GENOMSKADA("Genomskåda",""),
    MANIPULERA("Manipulera",""),
    VARDA("Vårda","");

    private final String name;
    private final String descrip;

    fardigheter(String name, String descrip) {
        this.name = name;
        this.descrip = descrip;
    }

    public String getName() {
        return name;
    }
}