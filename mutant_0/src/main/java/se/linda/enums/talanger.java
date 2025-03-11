package se.linda.enums;

public enum talanger {
    HÅRD_JÄVEL("test"),
    NJURSLAG(""),
    ÖVERVÅLD(""),
    MOTORSKALLE(""),
    REPARATÖR(""),
    UPPFINNARE(""),
    MONSTERJÄGARE(""),
    RÖTNOS(""),
    SAKLETARE(""),
    ELAK_JÄVEL(""),
    STORHANDLARE(""),
    HÅLLHAKE(""),
    BLODHUND(""),
    KAMPHUND(""),
    MUTANTS_BÄSTA_VÄN(""),
    ARTIST(""),
    HELARE(""),
    VÅLDSHETSARE(""),
    ARKENS_BESKYDDARE(""),
    KOMMENDANT(""),
    REVOLTERMÄN(""),
    OBRYDD(""),
    SLAGTÅLIG(""),
    REBELL("");

    public final String descrip;

    talanger(String descrip){
        this.descrip = descrip;
    }
}
