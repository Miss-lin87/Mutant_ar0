package se.linda.Player_functions.baseFunctions;

import se.linda.enums.klasser;
import se.linda.enums.stats;

import static se.linda.enums.stats.*;

public class Basestats {
    private stats best_stat;
    private int styrka;
    private int kyla;
    private int skärpa;
    private int känsla;

    public Basestats(klasser klass) {
        findStat(klass);
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

    private void findStat(klasser klass){
        switch(klass) {
            case KROSSARE -> this.best_stat = STYRKA;
            case SKROTSKALLE -> this.best_stat = SKÄRPA;
            case ZONSTRYKARE, SLAV, MUTANT_MED_HUND -> this.best_stat = KYLA;
            case FIXARE, KRÖNIKÖR, BOSS -> this.best_stat = KÄNSLA;
        }
    }

    public stats getBeststat(){
        return this.best_stat;
    }

    //setters
    public void setStyrka(int value) {
        if (value < 0) {
            this.styrka = Math.max(this.styrka - value, 0);
        } else {
            this.styrka += checkRange(value, STYRKA) ? value : 0;
        }
    }
    public void setKyla(int value) {
        if (value < 0) {
            this.kyla = Math.max(this.kyla - value, 0);
        } else {
            this.kyla += checkRange(value, KYLA)? value: 0;
        }
    }
    public void setKänsla(int value) {
        if (value < 0) {
            this.kyla = Math.max(this.kyla - value, 0);
        } else {
            this.känsla += checkRange(value, KÄNSLA)? value: 0;
        }
    }
    public void setSkärpa(int value) {
        if (value < 0) {
            this.skärpa = Math.max(this.skärpa - value, 0);
        } else {
            this.skärpa += checkRange(value, SKÄRPA)? value: 0;
        }
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

    @Override
    public String toString() {
        return STYRKA.toString() + " : " + this.styrka + "\n" +
                SKÄRPA.toString() + " : " + this.skärpa + "\n" +
                KÄNSLA.toString() + " : " + this.känsla + "\n" +
                KYLA.toString() + " : " + this.kyla;
    }
}