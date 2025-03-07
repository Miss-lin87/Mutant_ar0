package se.linda.Player_functions;

import org.w3c.dom.Document;
import se.linda.Player_functions.baseFunctions.Make_Stats;
import se.linda.Player_functions.baseFunctions.playerKlass;
import se.linda.enums.klasser;
import se.linda.enums.stats;

import java.util.HashMap;

public class MakeChar {
    private HashMap<stats, Integer> stats;
    private playerKlass klass;
    private Document doc;

    public MakeChar(String name, klasser klass) {
        this.stats = new HashMap<>();
        this.klass = new playerKlass(name, klass);
    }
}
