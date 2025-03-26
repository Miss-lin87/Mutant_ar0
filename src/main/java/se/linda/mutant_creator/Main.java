package se.linda.mutant_creator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.gridMaker;
import se.linda.mutant_creator.fxapps.mainApplication;
import se.linda.mutant_creator.fxapps.savedChars;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private GridPane mainGrid = new gridMaker(10,10, false).getGrid();
    private Button charCreator = new Button("Character Creator");
    private Button savedChars = new Button("Saved Characters");
    private Text welcome = new Text("Welcome \n select an option");
    private List<String> charNames = new ArrayList<>();

    private void getCharacters() {
        File folder = new File("src/main/java/se/linda/mutant_creator/characters");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                charNames.add(file.getName().substring(0, file.getName().indexOf(".json")));
            }
        }
    }

    private void buttonFunction(Stage stage) {
        charCreator.setOnAction(EventHander -> {
            mainApplication main = new mainApplication();
            try {
                stage.close();
                main.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        savedChars.setOnAction(EventHandler -> {
            getCharacters();
            savedChars saved = new savedChars();
            try {
                saved.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void populateGrid() {
        mainGrid.add(welcome, 0, 0);
        mainGrid.add(charCreator, 0, 1);
        mainGrid.add(savedChars, 0, 2);
    }

    private void setStage(Stage stage) {
        Scene scene = new Scene(mainGrid, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Mutant Character Creator");
        stage.show();
    }

    public List<String> getCharNames(){
        return this.charNames;
    }

    @Override
    public void start(Stage stage) throws Exception {
        populateGrid();
        buttonFunction(stage);
        setStage(stage);
    }
}