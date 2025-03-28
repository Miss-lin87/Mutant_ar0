package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.Grid;

public class skillsApplication extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10, false);

    private void populateGrid() {
        mainGrid.addRow(0, new javafx.scene.text.Text("Skills"));
        mainGrid.addColumn(0, new javafx.scene.text.Text("Test"));
        mainGrid.addColumn(1, new javafx.scene.text.Text("Test2"));
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        populateGrid();
        setStage(primaryStage, mainGrid, 340,275, "skills");
    }
}
