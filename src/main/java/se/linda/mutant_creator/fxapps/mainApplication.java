package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class mainApplication extends Application {
    private Button statsButton = new Button("Change Stats");

    private void makeGrid(GridPane grid) {
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));
    }

    private void addButtons() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
