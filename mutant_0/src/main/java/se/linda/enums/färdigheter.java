package se.linda.enums;

public enum färdigheter {
    KÄMPA_PÅ("", 0),
    TA_KRAFTTAG("", 0),
    SLÅSS("", 0),
    SMYGA("", 0),
    FLY("", 0),
    SKJUTA("", 0),
    SPEJA("", 0),
    FÖRSTÅ_SIG_PÅ("", 0),
    KÄNNA_ZONEN("", 0),
    GENOMSKÅDA("", 0),
    MANIPULERA("", 0),
    VÅRDA("", 0);

    private String descrip;
    private int value;

    färdigheter(String descrip, int value) {
        this.descrip = descrip;
        this.value = value;
    }
}
