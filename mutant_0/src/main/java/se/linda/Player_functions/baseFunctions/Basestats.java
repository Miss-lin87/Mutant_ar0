package se.linda.Player_functions.baseFunctions;

import se.linda.enums.klasser;
import se.linda.enums.stats;

import java.lang.module.FindException;

import static se.linda.enums.stats.*;

public class Basestats {
    private stats best_stat;
    private int styrka;
    private int kyla;
    private int skärpa;
    private int känsla;

    public Basestats(klasser klass) {
        this.best_stat = findStat(klass);
        this.styrka = 2;
        this.kyla = 2;
        this.skärpa = 2;
        this.känsla = 2;
    }

    private int getStatValue(stats stat) {
        switch (stat) {
            case STYRKA -> {
                return this.styrka;
            }
            case KYLA -> {
                return this.kyla;
            }
            case SKÄRPA -> {
                return this.skärpa;
            }
            case KÄNSLA -> {
                return this.känsla;
            }
        }
        return 0;
    }

    private boolean checkRange(int addValue, stats stat) {
        if (this.best_stat == stat && getStatValue(stat)+addValue <= 5) {
            return true;
        } else if (getStatValue(stat)+addValue <= 4) {
            return true;
        } else {
            return false;
        }
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

    //setters
    public void setStyrka(int addValue) {
        this.styrka = checkRange(addValue, STYRKA)? +addValue: this.styrka;
    }
    public void setKyla(int addValue) {
        this.kyla = checkRange(addValue, KYLA)? +addValue: this.kyla;
    }
    public void setKänsla(int addValue) {
        this.känsla = checkRange(addValue, KÄNSLA)? +addValue: this.känsla;
    }
    public void setSkärpa(int addValue) {
        this.skärpa = checkRange(addValue, SKÄRPA)? +addValue: this.känsla;
    }

    public int getStyrka() {
        return styrka;
    }
    public int getSkärpa() {
        return skärpa;
    }
    public int getKänsla() {
        return känsla;
    }
    public int getKyla() {
        return kyla;
    }
}