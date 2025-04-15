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
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10, false);
    private int maxRowCount = 5;
    private List<String> charNames = new ArrayList<>();

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

    public static void main(String[] args) {
        launch();
    }

    private void populateGrid() {
        addButtons();
    }

    private void addButtons() {
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
    }

    private void buttonFunction(Button button, String characterName) {
        FXMLLoader playerPage = new FXMLLoader(getClass().getResource("/fxPages/Character.fxml"));
        button.setOnAction(EventHandler -> {
            Scene scene;
            try {
                playerPage.setController(new savedController(characterName));
                scene = new Scene(playerPage.load(), 320,240);
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
        populateGrid();
        set.setStage(stage, mainGrid, 320, 275, "Saved Characters");
    }
}