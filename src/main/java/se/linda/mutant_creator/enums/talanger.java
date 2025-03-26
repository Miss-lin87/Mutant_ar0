package se.linda.mutant_creator.enums;

public enum talanger {
    HARD_JAVEL("Hård jävel", "test"),
    NJURSLAG("Njurslag", " "),
    OVERVALD("Övervåld"," "),
    MOTORSKALLE("Motorskalle"," "),
    REPARATOR("Reparatör"," "),
    UPPFINNARE("Uppfinnare"," "),
    MONSTERJAGARE("Monsterjägare"," "),
    ROTNOS("Rötnos"," "),
    SAKLETARE("Sakletre"," "),
    ELAK_JAVEL("Elak Jävel"," "),
    STORHANDLARE("Storhandlare"," "),
    HALLHAKE("Hållhake"," "),
    BLODHUND("Blodhund"," "),
    KAMPHUND("Kamphund"," "),
    MUTANTS_BASTA_VAN("Mutants Bästa Vän"," "),
    ARTIST("Artist"," "),
    HELARE("Helare"," "),
    VALDSHETSARE("Våldshetsare"," "),
    ARKENS_BESKYDDARE("Arkens Beskyddare"," "),
    KOMMENDANT("Kommendant"," "),
    REVOLTERMAN("Revoltermän"," "),
    OBRYDD("Obrydd"," "),
    SLAGTALIG("Slagtålig"," "),
    REBELL("Rebell"," ");

    private final String descrip;
    private final String name;

    talanger(String name, String descrip){
        this.descrip = descrip;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDescrip() {
        return this.descrip;
    }
}
