package se.linda.mutant_creator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;
import se.linda.mutant_creator.enums.equipment;
import se.linda.mutant_creator.enums.fardigheter;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.functions.savedCharFunctions;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxPages.mainPage;
import se.linda.mutant_creator.fxPages.savedCharPage;

public class Main extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10,false);
    private Button charCreator = new Button("Character Creator");
    private Button savedChars = new Button("Saved Characters");
    private Text welcome = new Text("Welcome \n select an option");

    private void buttonFunction(Stage stage) {
        charCreator.setOnAction(EventHander -> {
            mainPage main = new mainPage();
            try {
                main.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        savedChars.setOnAction(EventHandler -> {
            savedCharPage saved = new savedCharPage();
            try {
                saved.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void populateGrid() {
        grid.addNodes(mainGrid,0,0,
                welcome,
                charCreator,
                savedChars);
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