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
import se.linda.mutant_creator.fxFunctions.gridMaker;

import java.io.IOException;

public class mainApplication extends Application {
    private Button statsButton = new Button("Change Stats");
    private Button newChar = new Button("Make Character");
    private Button testInfor = new Button("Test");
    private Button equipment = new Button("Equipment");
    private GridPane mainGrid = new gridMaker(10,10).getGrid();
    public static MakeChar player;
    public static Text character = new Text("");

    private GridPane makeGrid() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        return grid;
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
        equipment.setOnAction(EventHandler -> {
            if (player == null) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Character cant be empty");
                error.show();
            } else {
            equipmentApplication equipment = new equipmentApplication();
            try {
                equipment.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        });
        testInfor.setOnAction(actionEvent -> {
            System.out.println(player.getName());
            System.out.println(player.getPlayer().getKlass());
            System.out.println(player.getPlayer().getSelectedTalent());
            System.out.println(player.getPlayer().getEquipment().toString());
        });
    }

    private void addButtons(GridPane grid) {
        grid.add(newChar,0,1);
        grid.add(statsButton,0,2);
        grid.add(equipment,0,3);
        grid.add(testInfor,0,4);
    }

    private void addText(GridPane grid) {
        grid.add(new Text("Active Character: "),0,0);
        grid.add(character, 1, 0);
    }

    private void populateGrid(GridPane grid) {
        addText(grid);
        addButtons(grid);
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        populateGrid(grid);
        buttonFuctions();
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        setStage(stage, mainGrid, 340,275,"Main");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
