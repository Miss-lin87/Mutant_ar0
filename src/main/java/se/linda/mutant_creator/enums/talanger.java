package se.linda.mutant_creator.enums;

public enum talanger {
    HÅRD_JÄVEL("Hård jävel", "test"),
    NJURSLAG("Njurslag", ""),
    ÖVERVÅLD("Övervåld",""),
    MOTORSKALLE("Motorskalle",""),
    REPARATÖR("Reparatör",""),
    UPPFINNARE("Uppfinnare",""),
    MONSTERJÄGARE("Monsterjägare",""),
    RÖTNOS("Rötnos",""),
    SAKLETARE("Sakletre",""),
    ELAK_JÄVEL("Elak Jävel",""),
    STORHANDLARE("Storhandlare",""),
    HÅLLHAKE("Hållhake",""),
    BLODHUND("Blodhund",""),
    KAMPHUND("Kamphund",""),
    MUTANTS_BÄSTA_VÄN("Mutants Bästa Vän",""),
    ARTIST("Artist",""),
    HELARE("Helare",""),
    VÅLDSHETSARE("Våldshetsare",""),
    ARKENS_BESKYDDARE("Arkens Beskyddare",""),
    KOMMENDANT("Kommendant",""),
    REVOLTERMÄN("Revoltermän",""),
    OBRYDD("Obrydd",""),
    SLAGTÅLIG("Slagtålig",""),
    REBELL("Rebell","");

    public final String descrip;
    public final String name;

    talanger(String name, String descrip){
        this.descrip = descrip;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
