package se.linda.mutant_creator.Player_functions.baseFunctions;

import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;

public class playerKlass {
    private final klasser klass;
    private final Basestats basestats;
    private final Talent talents;
    private talanger selectedTalent;
    private final Equipment equipment;
    private final Fardigheter skills;

    public playerKlass(klasser klass){
        this.klass = klass;
        this.basestats = new Basestats(klass);
        this.talents = new Talent(klass);
        this.equipment = new Equipment(klass);
        this.skills = new Fardigheter(klass);
    }

    //Getters
    public Basestats getBasestats() {
        return this.basestats;
    }
    public klasser getKlass() {
        return this.klass;
    }
    public Equipment getEquipment() {
        return this.equipment;
    }
    public Talent getTalents() {
        return this.talents;
    }
    public talanger getSelectedTalent() {
        return this.selectedTalent;
    }
    public Fardigheter getSkills() {
        return this.skills;
    }

    //Setters
    public void setSelectedTalent(talanger talang) {
        this.selectedTalent = talang;
    }
}