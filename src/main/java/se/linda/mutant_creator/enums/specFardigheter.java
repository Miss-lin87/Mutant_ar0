package se.linda.mutant_creator.enums;

public enum specFardigheter{
    MUCKA (""),
    MECKA (""),
    LEDA_VAGEN(""),
    SCHACKRA (""),
    BUSSA_PA(""),
    INSPIRERA (""),
    KOMMENDERA (""),
    UTHARDA("");

    private String descrip;

    specFardigheter(String descrip) {
        this.descrip = descrip;
    }

    public String getDescrip() {
        return this.descrip;
    }
}