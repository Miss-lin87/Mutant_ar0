package se.linda.mutant_creator.functions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class funcs {
    Logger message = Logger.getLogger(getClass().getName());
    private List<String> charNames = new ArrayList<>();

    public String user_input_string(String input_line){
        Scanner input_from_user = new Scanner(System.in);
        message.info(input_line);
        return input_from_user.nextLine();
    }

    public Integer user_input_integer(){
        Scanner input_from_user = new Scanner(System.in);
        message.info("Please enter a number: ");
        return input_from_user.nextInt();
    }

    public <T> Optional<T> getOptional(T input) {
        return Optional.ofNullable(input);
    }

    private void getCharacters() {
        File folder = new File("src/main/java/se/linda/mutant_creator/characters");
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