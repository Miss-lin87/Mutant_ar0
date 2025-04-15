package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.fxFunctions.SaveChar;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxFunctions.stageSetter;

import java.io.IOException;

public class mainPage extends Application {
    private Button newChar = new Button("Make Character");
    private Button equipment = new Button("Equipment");
    private Button save = new Button("Save");
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10,10, false);
    public static MakeChar player;
    public static Text character = new Text("");

    private void buttonFuctions() {
        newChar.setOnAction(actionEvent -> {
            makeCharPage newplayer = new makeCharPage();
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
            equipmentPage equipment = new equipmentPage();
            try {
                equipment.start(new Stage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        });
        save.setOnAction(ActionEvent -> {
            if (player == null) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Character cant be empty");
                error.show();
            } else {
                try {
                    SaveChar save = new SaveChar(player.getName(), player);
                    save.save();
                } catch (IOException e) {
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setContentText("Character already excists");
                    error.show();
                }
            }
        });
    }

    private void addButtons() {
        grid.addNodes(mainGrid,1,0,
                newChar,
                //statsButton,
                equipment,
                //testInfor,
                save);
    }

    private void addText() {
        mainGrid.add(new Text("Active Character: "),0,0);
        mainGrid.add(character, 1, 0);
    }

    private void populateGrid() {
        addText();
        addButtons();
        buttonFuctions();
    }

    @Override
    public void start(Stage stage) {
        stageSetter set = new stageSetter();
        populateGrid();
        set.setStage(stage, mainGrid, 340,275,"Main");
    }

    public static void main() {
        launch();
    }
}