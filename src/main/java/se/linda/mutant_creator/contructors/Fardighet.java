package se.linda.mutant_creator.contructors;

public class Fardighet {
    private String skillName;
    private String skillValue;

    public Fardighet(String skillName, String skillValue) {
        this.skillName = skillName;
        this.skillValue = skillValue;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillValue() {
        return skillValue;
    }

    public void setSkillValue(String skillValue) {
        this.skillValue = skillValue;
    }
}
