package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxFunctions.stageSetter;
import java.io.IOException;

public class equipmentPage extends Application {
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(10,10, false);
    private final Text header = new Text("Equipment");

    public static void main(String[] args) {
        launch(args);
    }

    private void populateGrid(Stage stage) {
        grid.addNodes(mainGrid, 0,0,
                header,
                new Text(mainPage.player.getBackpack().toString()),
                grid.closeButton(stage));
        mainGrid.add(header, 0, 0);
        mainGrid.add(new Text(mainPage.player.getBackpack().toString()), 0, 1);
    }

    @Override
    public void start(Stage mainStage) throws IOException {
        populateGrid(mainStage);
        stageSetter set = new stageSetter();
        set.setStage(mainStage,mainGrid,300,275,"Equipment");
    }
}