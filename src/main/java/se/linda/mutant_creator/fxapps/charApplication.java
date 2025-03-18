package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.Player_functions.baseFunctions.Talent;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.talanger;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.fxFunctions.gridMaker;

import java.io.IOException;
import java.util.Objects;

public class charApplication extends Application {
    private TextField name = new TextField();
    private Menu klasserMenu = new Menu("Klasser");
    private Menu talentsMenu = new Menu("Talanger");
    private Button submit = new Button("Submit");
    private Button info = new Button("?");
    private Button close = new Button("Cancel");
    private GridPane grid = new gridMaker(10,10).getGrid();
    private Alert warning = new Alert(Alert.AlertType.ERROR);

    public static void main(String[] args) {
        launch(args);
    }

    private VBox makeKlassMenu(GridPane mainGrid) {
        MenuBar mb = new MenuBar();
        for (klasser klass: klasser.values()) {
            MenuItem temp = new MenuItem(klass.getName());
            temp.setOnAction(EventHandler -> {
                klasserMenu.setText(klass.getName());
                if (talentsMenu.isDisable()){
                    extendView(mainGrid);
                } else {
                    makeTalentMenu(mainGrid);
                }
            });
            klasserMenu.getItems().add(temp);
        }
        mb.getMenus().add(klasserMenu);
        return new VBox(mb);
    }

    private VBox makeTalentMenu(GridPane mainGrid) {
        MenuBar mb = new MenuBar();
        talentsMenu.getItems().clear();
        for (talanger talang : new Talent(new converters().stringTOklass(klasserMenu.getText())).getTalents()) {
            MenuItem temp = new MenuItem(talang.getName());
            temp.setOnAction(EventHandler -> {
                talentsMenu.setText(talang.getName());
                if (submit.isDisable()){
                    extendView(mainGrid);
                }
            });
            talentsMenu.getItems().add(temp);
        }
        mb.getMenus().add(talentsMenu);
        return new VBox(mb);
    }

    private void submitFunction(Stage stage) {
        submit.setOnAction(EventHandler -> {
            if (name.getText().isBlank()) {
                warning.setContentText("Name cant be empty");
                warning.show();
            } else if (Objects.equals(klasserMenu.getText(), "Klasser")) {
                warning.setContentText("Please select a class");
                warning.show();
            } else if (Objects.equals(talentsMenu.getText(), "Talanger")) {
                warning.setContentText("Please select a talent");
                warning.show();
            } else {
                mainApplication.player = new MakeChar(name.getText(), new converters().stringTOklass(klasserMenu.getText()));
                mainApplication.player.getPlayer().setSelectedTalent(new converters().stringTOtalang(talentsMenu.getText()));
                mainApplication.character.setText(mainApplication.player.getName());
                stage.close();
            }
        });
    }

    private void buttonFunction(Stage stage) {
        info.hoverProperty().addListener(observable -> {
            Tooltip tip = new Tooltip();
            tip.setShowDelay(Duration.ZERO);
            if (Objects.equals(talentsMenu.getText(), "Talanger")) {
                tip.setText("");
                info.setTooltip(tip);
            } else{
                String temp = new Talent(new converters().stringTOklass(klasserMenu.getText())).getDescription(new converters().stringTOtalang(talentsMenu.getText()));
                tip.setText(temp);
                info.setTooltip(tip);
            }
        });
        close.setOnAction(EventHandler -> {
            stage.close();
        });
    }

    private void extendView(GridPane grid) {
        if (talentsMenu.isDisable()) {
            grid.add(new Text("Select Talent: "),0,3);
            talentsMenu.setDisable(false);
            grid.add(makeTalentMenu(grid),1,3);
            grid.add(info, 2,3);
        } else if (submit.isDisable() && !talentsMenu.isDisable()) {
            submit.setDisable(false);
            grid.add(submit,1,4);
        }
    }

    private void pupulateGrid(GridPane grid) {
        talentsMenu.setDisable(true);
        submit.setDisable(true);
        grid.add(new Text("Make a new Character"),0,0);
        grid.add(close,1,0);
        grid.add(new Text("Name: "),0,1);
        grid.add(name,1,1);
        grid.add(new Text("Klass: "),0,2);
        grid.add(makeKlassMenu(grid),1,2);
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        submitFunction(stage);
        buttonFunction(stage);
        Scene mainScene = new Scene(grid,V,V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        pupulateGrid(grid);
        setStage(stage, grid,450,350,"New Character");
    }
}