package se.linda.mutant_creator.fxFunctions;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxapps.savedCharApp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class savedCharsController extends Application {
    @FXML
    public Label name = new Label("Test");
    @FXML
    public Text palyerName = new Text("Linda");
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

    public static void main(String[] args) {
        launch(args);
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

    private void buttonFunction(Button button, String character) {
        button.setOnAction(EventHandler -> {
            FXMLLoader hello = new FXMLLoader(savedCharsController.class.getResource("src/main/resources/se/linda/mutant_creator/Character.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(hello.load(), 320,240);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        });
    }

    private void setStage(GridPane grid, Stage stage) {
        Scene scene = new Scene(grid, 300, 275);
        stage.setTitle("Saved Characters");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        getCharacters();
        populateGrid();
        setStage(mainGrid, stage);
    }
}