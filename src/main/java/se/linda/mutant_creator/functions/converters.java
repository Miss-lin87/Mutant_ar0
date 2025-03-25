package se.linda.mutant_creator.functions;

import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.stats;
import se.linda.mutant_creator.enums.talanger;

import static se.linda.mutant_creator.enums.klasser.*;
import static se.linda.mutant_creator.enums.talanger.*;

public class converters {

    public <T> T stringTOEnum(String string, T[] values) {
        T temp = null;
        for (T value : values) {
            string = string.toUpperCase()
                    .replace("Å", "A")
                    .replace("Ä", "A")
                    .replace("Ö", "O");
            if (string.equals(value.toString())) {
                temp = value;
            }
        }
        return temp;
    }
}
