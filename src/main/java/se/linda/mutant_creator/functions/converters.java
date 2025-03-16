package se.linda.mutant_creator.functions;

import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;

import static se.linda.mutant_creator.enums.klasser.*;
import static se.linda.mutant_creator.enums.talanger.*;

public class converters {
    private klasser klass;

    public klasser stringTOklass(String klass) {
        klasser temp = null;
        switch (klass) {
            case "Krossare" -> temp = KROSSARE;
            case "Skrotskalle" -> temp = SKROTSKALLE;
            case "Zonstrykare" -> temp = ZONSTRYKARE;
            case "Fixare" -> temp = FIXARE;
            case "Mutant med hund" -> temp = MUTANT_MED_HUND;
            case "Krönikör" -> temp = KRÖNIKÖR;
            case "Boss" -> temp = BOSS;
            case "Slav" -> temp = SLAV;
        }
        return temp;
    }

    public talanger stringTOtalang(String talang) {
        talanger temp = null;
        switch (talang) {
            case "Hård jävel" -> temp = HÅRD_JÄVEL;
            case "Njurslag" -> temp = NJURSLAG;
            case "Övervåld" -> temp = ÖVERVÅLD;
            case "Motorskalle" -> temp = MOTORSKALLE;
            case "Reparatör" -> temp = REPARATÖR;
            case "Uppfinnare" -> temp = UPPFINNARE;
            case "Monsterjägare" -> temp = MONSTERJÄGARE;
            case "Rötnos" -> temp = RÖTNOS;
            case "Sakletre" -> temp = SAKLETARE;
            case "Elak Jävel" -> temp = ELAK_JÄVEL;
            case "Storhandlare" -> temp = STORHANDLARE;
            case "Hållhake" -> temp = HÅLLHAKE;
            case "Blodhund" -> temp = BLODHUND;
            case "Kamphund" -> temp = KAMPHUND;
            case "Mutants Bästa Vän" -> temp = MUTANTS_BÄSTA_VÄN;
            case "Artist" -> temp = ARTIST;
            case "Helare" -> temp = HELARE;
            case "Våldshetsare" -> temp = VÅLDSHETSARE;
            case "Arkens Beskyddare" -> temp = ARKENS_BESKYDDARE;
            case "Kommendant" -> temp = KOMMENDANT;
            case "Revoltermän" -> temp = REVOLTERMÄN;
            case "Obrydd" -> temp = OBRYDD;
            case "Slagtålig" -> temp = SLAGTÅLIG;
            case "Rebell" -> temp = SLAGTÅLIG;
        }
        return temp;
    }
}
