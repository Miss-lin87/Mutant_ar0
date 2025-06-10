package se.linda.mutant_creator.fxfunctions;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StageSetter {
    private static Scene mainScene;

    public static void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        mainScene = new Scene(grid, V, V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    public static Scene getMainScene() {
        return mainScene;
    }
}