package se.linda.mutant_creator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxfunctions.Grid;
import se.linda.mutant_creator.fxpages.MainPage;
import se.linda.mutant_creator.fxpages.SavedCharPage;

public class Main extends Application {
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(10,10,false);
    private final Button charCreator = new Button("Character Creator");
    private final Button savedChars = new Button("Saved Characters");
    private final Text welcome = new Text("Welcome\nSelect an option");

    private void buttonFunction() {
        charCreator.setOnAction(_ -> {
            MainPage main = new MainPage();
            try {
                main.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        savedChars.setOnAction(_ -> {
            SavedCharPage saved = new SavedCharPage();
            try {
                saved.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void populateGrid(Stage stage) {
        grid.addNodes(mainGrid,0,0,
                welcome,
                charCreator,
                savedChars,
                grid.closeButton(stage));
    }

    private void setStage(Stage stage) {
        Scene scene = new Scene(mainGrid, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Mutant Character Creator");
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        populateGrid(stage);
        buttonFunction();
        setStage(stage);
    }
}