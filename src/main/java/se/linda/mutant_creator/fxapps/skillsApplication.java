package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import se.linda.mutant_creator.fxFunctions.gridMaker;

public class skillsApplication extends Application {
    private GridPane grid = new gridMaker(10,10).getGrid();

    private void populateGrid() {
        grid.addRow(0, new javafx.scene.text.Text("Skills"));
        grid.addColumn(0, new javafx.scene.text.Text("Test"));
        grid.addColumn(1, new javafx.scene.text.Text("Test2"));
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
        setStage(primaryStage, grid, 340,275, "skills");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
