package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import se.linda.mutant_creator.Main;
import se.linda.mutant_creator.fxFunctions.gridMaker;

import java.util.List;

public class savedChars extends Application {
    private GridPane mainGrid = new gridMaker(10,10, false).getGrid();
    private Popup popup = new Popup();
    private List<String> characters = new Main().getCharNames();

    public static void main(String[] args) {
        launch(args);
    }

    private void populateGrid() {
        addButtons();
    }

    private void addButtons() {
        for (String character: characters) {
            Button temp = new Button(character);
            mainGrid.add(temp, mainGrid.getColumnCount(), mainGrid.getRowCount());
        }
    }

    private void buttonFunction(Button button, String character) {
        //TODO
    }

    private void setStage(Stage stage){
        Scene scene = new Scene(mainGrid, 300, 275);
        stage.setTitle("Saved Characters");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        populateGrid();
        setStage(stage);
    }
}