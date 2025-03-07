package java.se.linda.player_classes.baseFunctions;


import java.se.linda.enums.klasser;
import java.se.linda.enums.stats;

import static java.se.linda.enums.stats.*;

public class Beststat{
    private stats best_stat;

    public Beststat(klasser klass) {
        this.best_stat = findStat(klass);
    }

    private stats findStat(klasser klass){
        switch(klass) {
            case KROSSARE -> this.best_stat = STYRKA;
            case SKROTSKALLE -> this.best_stat = SKÄRPA;
            case ZONSTRYKARE, SLAV, MUTANT_MED_HUND -> this.best_stat = KYLA;
            case FIXARE, KRÖNIKÖR, BOSS -> this.best_stat = KÄNSLA;
        }
        return null;
    }

    public stats getBeststat(){
        return this.best_stat;
    }
}