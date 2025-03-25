package se.linda.mutant_creator.enums;

public enum specFardigheter {
    MUCKA (""),
    MECKA (""),
    LEDA_VAGEN(""),
    SCHACKRA (""),
    BUSSA_PA(""),
    INSPIRERA (""),
    KOMMENDERA (""),
    UTHARDA("");

    private String desprip;

    specFardigheter(String descrip) {
        this.desprip = descrip;
    }
}
