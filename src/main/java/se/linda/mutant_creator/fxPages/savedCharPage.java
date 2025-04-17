package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.minidev.json.parser.ParseException;
import se.linda.mutant_creator.fxControllers.savedController;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxFunctions.stageSetter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class savedCharPage extends Application {
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(10,10, false);
    private final int maxRowCount = 5;
    private final List<String> charNames = new ArrayList<>();

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

    private void populateGrid(Stage stage) {
        addButtons(stage);
    }

    private void addButtons(Stage stage) {
        int rowcount = 0;
        int columCount = 0;
        for (String character: charNames) {
            if (rowcount < maxRowCount) {
                Button temp = new Button(character);
                buttonFunction(temp, character);
                mainGrid.add(temp, columCount, rowcount);
                rowcount ++;
            } else {
                columCount ++;
                rowcount = 0;
                Button temp = new Button(character);
                buttonFunction(temp, character);
                mainGrid.add(temp, columCount, rowcount);
            }
        }
        grid.addNodes(mainGrid,mainGrid.getRowCount(), 0,
                grid.closeButton(stage));
    }

    private void buttonFunction(Button button, String characterName) {
        FXMLLoader playerPage = new FXMLLoader(getClass().getResource("/fxPages/Character.fxml"));
        button.setOnAction(_ -> {
            Scene scene;
            try {
                playerPage.setController(new savedController(characterName));
                scene = new Scene(playerPage.load(), 400,740);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void start(Stage stage) {
        stageSetter set = new stageSetter();
        getCharacters();
        populateGrid(stage);
        set.setStage(stage, mainGrid, 320, 275, "Saved Characters");
    }

    public static void main(String[] args) {
        launch();
    }
}