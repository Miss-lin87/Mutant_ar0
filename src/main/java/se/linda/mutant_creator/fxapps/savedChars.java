package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class savedChars extends Application {
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

    private void populateGrid(GridPane grid) {
        addButtons(grid);
    }

    private void addButtons(GridPane grid) {
        int rowcount = 0;
        int columCount = 0;
        for (String character: charNames) {
            if (rowcount < maxRowCount) {
                Button temp = new Button(character);
                grid.add(temp, columCount, rowcount);
                rowcount ++;
            } else {
                columCount ++;
                rowcount = 0;
                Button temp = new Button(character);
                grid.add(temp, columCount, rowcount);
            }
        }
    }

    private void buttonFunction(Button button, String character) {
        button.setOnAction(EventHandler -> {
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
        populateGrid(mainGrid);
        setStage(mainGrid, stage);
    }
}