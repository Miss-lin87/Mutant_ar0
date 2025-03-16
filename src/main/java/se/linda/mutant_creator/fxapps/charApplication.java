package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.fxFunctions.gridMaker;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.Objects;

public class charApplication extends Application {
    private TextField name = new TextField();
    private Menu klasserMenu = new Menu("Klasser");
    private Menu talentsMenu = new Menu("Talanger");
    private Button submit = new Button("Submit");
    private gridMaker grid = new gridMaker(10,10);
    private Alert warning = new Alert(Alert.AlertType.ERROR);

    public static void main(String[] args) {
        launch(args);
    }

    private VBox makeKlassMenu() {
        MenuBar mb = new MenuBar();
        for (klasser klass: klasser.values()) {
            MenuItem temp = new MenuItem(klass.getName());
            temp.setOnAction(EventHandler -> {
                klasserMenu.setText(klass.getName());
            });
            klasserMenu.getItems().add(temp);
        }
        mb.getMenus().add(klasserMenu);
        return new VBox(mb);
    }

    private VBox makeTalentMenu() {
        MenuBar mb = new MenuBar();
        for (talanger talang : talanger.values()) {
            MenuItem temp = new MenuItem(talang.getName());
            temp.setOnAction(EventHandler -> {
                talentsMenu.setText(talang.getName());
            });
            talentsMenu.getItems().add(temp);
        }
        mb.getMenus().add(talentsMenu);
        return new VBox(mb);
    }

    private void submitFunction(Stage stage) {
        submit.setOnAction(EventHandler -> {
            if (Objects.equals(klasserMenu.getText(), "Klasser")) {
                warning.setContentText("Please select a class");
                warning.show();
            } else if (name.getText().isBlank()) {
                warning.setContentText("Name cant be empty");
                warning.show();
            } else {
                mainApplication.player = new MakeChar(name.getText(), new converters().stringTOklass(klasserMenu.getText()));
                mainApplication.character.setText(mainApplication.player.getName());
                stage.close();
            }
        });
    }

    private void menuFunction(GridPane mainGrid) {
        klasserMenu.setOnHidden(EventHandler -> {
            extendView(mainGrid);
        });
    }

    private void extendView(GridPane grid) {
        grid.add(new Text("Select Talent: "),0,3);
        grid.add(makeTalentMenu(),1,3);
    }

    private void pupulateGrid(GridPane grid) {
        grid.add(new Text("Make a new Character"),0,0);
        grid.add(new Text("Klass: "),0,1);
        grid.add(makeKlassMenu(),1,1);
        grid.add(new Text("Name: "),0,2);
        grid.add(name,1,2);
        grid.add(submit,1,0);
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        submitFunction(stage);
        menuFunction(grid);
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane mainGrid = grid.getGrid();
        pupulateGrid(mainGrid);
        setStage(stage, mainGrid,450,350,"New Character");
    }
}