package se.linda.mutant_creator.enums;

public enum specFardigheter{
    MUCKA ("Mucka",""),
    MECKA ("Mecka",""),
    LEDA_VAGEN("Leda Vägen",""),
    SCHACKRA ("Schackra",""),
    BUSSA_PA("Bussa på",""),
    INSPIRERA ("Inspirera",""),
    KOMMENDERA ("Kommendera",""),
    UTHARDA("Uthärda","");

    private String name;
    private String descrip;

    specFardigheter(String name, String descrip) {
        this.name = name;
        this.descrip = descrip;
    }

    public String getName() {
        return name;
    }
}