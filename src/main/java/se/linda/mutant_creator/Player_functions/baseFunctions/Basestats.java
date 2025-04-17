package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.stats;
import java.util.HashMap;

import static se.linda.mutant_creator.enums.stats.*;

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
        int returnValue = 0;
        switch (stat) {
            case STYRKA -> returnValue = this.styrka;
            case KYLA -> returnValue = this.kyla;
            case SKARPA -> returnValue = this.skärpa;
            case KANSLA -> returnValue = this.känsla;
        }
        return returnValue;
    }

    private boolean checkRange(int addValue, stats stat) {
        if (this.best_stat == stat && getStatValue(stat)+addValue <= 5) {
            return true;
        } else return getStatValue(stat) + addValue <= 4;
    }

    private void findStat(klasser klass){
        switch(klass) {
            case KROSSARE -> this.best_stat = STYRKA;
            case SKROTSKALLE -> this.best_stat = SKARPA;
            case ZONSTRYKARE, SLAV, MUTANT_MED_HUND -> this.best_stat = KYLA;
            case FIXARE, KRONIKOR, BOSS -> this.best_stat = KANSLA;
        }
    }

    public stats getBeststat(){
        return this.best_stat;
    }

    //Setters
    private void setStyrka(int value) {
        if (value < 0) {
            this.styrka = Math.max(this.styrka - Math.abs(value), 2);
        } else {
            this.styrka += checkRange(value, STYRKA) ? value : 0;
        }
    }
    private void setKyla(int value) {
        if (value < 0) {
            this.kyla = Math.max(this.kyla - Math.abs(value), 2);
        } else {
            this.kyla += checkRange(value, KYLA)? value: 0;
        }
    }
    private void setKänsla(int value) {
        if (value < 0) {
            this.känsla = Math.max(this.känsla - Math.abs(value), 2);
        } else {
            this.känsla += checkRange(value, KANSLA)? value: 0;
        }
    }
    private void setSkärpa(int value) {
        if (value < 0) {
            this.skärpa = Math.max(this.skärpa - Math.abs(value), 2);
        } else {
            this.skärpa += checkRange(value, SKARPA)? value: 0;
        }
    }

    public void setStat(stats stat, int value) {
        switch (stat) {
            case STYRKA -> setStyrka(value);
            case KYLA -> setKyla(value);
            case KANSLA -> setKänsla(value);
            case SKARPA -> setSkärpa(value);
        }
    }

    public int getStat(stats stat) {
        int value = 0;
        switch (stat) {
            case STYRKA -> value = getStyrka();
            case SKARPA -> value = getSkärpa();
            case KANSLA -> value = getKänsla();
            case KYLA -> value = getKyla();
        }
        return value;
    }

    public HashMap<stats, Integer> getAllStats() {
        HashMap<stats, Integer> allStats = new HashMap<>();
        allStats.put(STYRKA, this.styrka);
        allStats.put(SKARPA, this.skärpa);
        allStats.put(KANSLA, this.känsla);
        allStats.put(KYLA, this.kyla);
        return allStats;
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

    public int getTotal() {
        return this.styrka + this.kyla + this.känsla + this.skärpa;
    }

    @Override
    public String toString() {
        return STYRKA + " : " + this.styrka + "\n" +
                SKARPA + " : " + this.skärpa + "\n" +
                KANSLA + " : " + this.känsla + "\n" +
                KYLA + " : " + this.kyla;
    }
}