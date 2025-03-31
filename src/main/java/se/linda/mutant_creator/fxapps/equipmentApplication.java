package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;

import java.io.IOException;

public class equipmentApplication extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10, false);
    private Text header = new Text("Equipment");

    public static void main(String[] args) {
        launch(args);
    }

    private void populateGrid(GridPane mainGrid) {
        mainGrid.add(header, 0, 0);
        mainGrid.add(new Text(mainApplication.player.getBackpack().toString()), 0, 1);
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        populateGrid(mainGrid);
        setStage(primaryStage,mainGrid,300,275,"Equipment");
    }
}