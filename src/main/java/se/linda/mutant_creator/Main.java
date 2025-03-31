package se.linda.mutant_creator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxapps.mainApplication;
import se.linda.mutant_creator.fxFunctions.savedCharsController;

public class Main extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10,false);
    private Button charCreator = new Button("Character Creator");
    private Button savedChars = new Button("Saved Characters");
    private Text welcome = new Text("Welcome \n select an option");

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
            savedCharsController saved = new savedCharsController();
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

    @Override
    public void start(Stage stage) throws Exception {
        populateGrid();
        buttonFunction(stage);
        setStage(stage);
    }
}