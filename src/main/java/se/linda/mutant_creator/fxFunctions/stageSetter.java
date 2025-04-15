package se.linda.mutant_creator.fxFunctions;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class stageSetter {

    public void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }
}