package se.linda.mutant_creator.functions;

public class converters {

    public <T> T stringTOEnum(String name, T[] enumValues) {
        T temp = null;
        for (T value : enumValues) {
            name = name.toUpperCase()
                    .replace("Å", "A")
                    .replace("Ä", "A")
                    .replace("Ö", "O");
            if (name.equals(value.toString())) {
                temp = value;
            }
        }
        return temp;
    }
}