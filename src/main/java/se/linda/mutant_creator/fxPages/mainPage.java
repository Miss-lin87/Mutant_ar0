package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
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
    private final Button newChar = new Button("Make Character");
    private final Button equipment = new Button("Equipment");
    private final Button save = new Button("Save");
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(10,10, false);
    public static MakeChar player;
    public static Text character = new Text("");

    private void buttonFuctions() {
        newChar.setOnAction(_ -> {
            makeCharPage newplayer = new makeCharPage();
            try {
                newplayer.start(new Stage());
            } catch (IOException g) {
                throw new RuntimeException(g);
            }
        });
        equipment.setOnAction(_ -> {
            if (player == null) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Character cant be empty");
                error.show();
            } else {
                try {
                    new equipmentPage().start(new Stage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        save.setOnAction(_ -> {
            if (player == null) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Character cant be empty");
                error.show();
            } else {
                try {
                    new SaveChar(player.getName(), player).save();
                } catch (IOException e) {
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setContentText("Character already exists");
                    error.show();
                }
            }
        });
    }

    private void addButtons() {
        grid.addNodes(mainGrid,1,0,
                newChar,
                equipment,
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