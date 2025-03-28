package se.linda.mutant_creator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.functions.funcs;
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

    @Override
    public void start(Stage stage) throws Exception {
        populateGrid();
        buttonFunction(stage);
        setStage(stage);
    }
}