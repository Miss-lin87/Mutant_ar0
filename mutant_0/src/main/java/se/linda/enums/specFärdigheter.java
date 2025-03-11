package se.linda.enums;

public enum specFärdigheter {
    MUCKA (""),
    MECKA (""),
    LEDA_VÄGEN (""),
    SCHACKRA (""),
    BUSSA_PÅ (""),
    INSPIRERA (""),
    KOMMENDERA (""),
    UTHÄRDA ("");

    private String desprip;

    specFärdigheter (String descrip) {
        this.desprip = descrip;
    }
}
