package se.linda.mutant_creator.functions;
import se.linda.mutant_creator.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Funcs {
    private final List<String> charNames = new ArrayList<>();

    public <T> Optional<T> getOptional(T input) {
        return Optional.ofNullable(input);
    }

    private void getCharacters() {
        File folder = new File(Constants.CHAR_PATH);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                charNames.add(file.getName().substring(0, file.getName().indexOf(".json")));
            }
        }
    }

    public List<String> getCharNames() {
        getCharacters();
        return charNames;
    }
}