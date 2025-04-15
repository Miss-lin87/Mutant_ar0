package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxFunctions.stageSetter;

import java.io.IOException;

public class equipmentPage extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10, false);
    private Text header = new Text("Equipment");

    public static void main(String[] args) {
        launch(args);
    }

    private void populateGrid(GridPane mainGrid) {
        mainGrid.add(header, 0, 0);
        mainGrid.add(new Text(mainPage.player.getBackpack().toString()), 0, 1);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        populateGrid(mainGrid);
        stageSetter set = new stageSetter();
        set.setStage(mainStage,mainGrid,300,275,"Equipment");
    }
}