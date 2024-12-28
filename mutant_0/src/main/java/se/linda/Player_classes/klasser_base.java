package se.linda.Player_classes;

import java.util.Map;

    interface klass{
        public void getBeststat();
        public Map<String, Integer> get_stats();
        public String select_talent();
        public Map<String, Integer> make_equipment();
    }

class klasser_base{
    private Map<String, String> Beststat;
    
    public Map<String, String> getBeststat(String class){
        Beststat.get(class);
        return Beststat;
    }


}
