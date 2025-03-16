package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.Player_functions.MakeChar;

import java.io.IOException;

public class mainApplication extends Application {
    private Button statsButton = new Button("Change Stats");
    private Button newChar = new Button("Make Character");
    private Button testInfor = new Button("Test");
    public static MakeChar player;
    public static Text character = new Text("");

    private void makeGrid(GridPane grid) {
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));
    }

    private void buttonFuctions() {
        statsButton.setOnAction(actionEvent -> {
            if (player == null) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Character cant be empty");
                error.show();
            } else {
                StatsApplication stats = new StatsApplication();
                try {
                    stats.start(new Stage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        newChar.setOnAction(actionEvent -> {
            charApplication newplayer = new charApplication();
            try {
                newplayer.start(new Stage());
            } catch (IOException g) {
                throw new RuntimeException(g);
            }
        });

        testInfor.setOnAction(actionEvent -> {
            System.out.println(player.getName());
        });
    }

    private void addButtons(GridPane grid) {
        grid.add(statsButton,0,1);
        grid.add(newChar,0,2);
        grid.add(testInfor,0,3);
    }

    private void addText(GridPane grid) {
        grid.add(new Text("Active Character: "),0,0);
        grid.add(character, 1, 0);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        makeGrid(grid);
        addButtons(grid);
        buttonFuctions();
        addText(grid);
        Scene scene = new Scene(grid, 320, 240);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
