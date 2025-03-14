package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import se.linda.mutant_creator.Main;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.enums.klasser;

import java.io.IOException;
import java.util.Objects;

public class charApplication extends Application {
    private TextField name = new TextField();
    private Menu klasserMenu = new Menu("Klasser");
    private Button submit = new Button("Submit");

    public static void main(String[] args) {
        launch(args);
    }

    public void makeGrid(GridPane grid) {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
    }

    public void makeMenu() {
        for (klasser klass: klasser.values()) {
            MenuItem temp = new MenuItem(klass.getName());
            temp.setOnAction(EventHandler -> {
                klasserMenu.setText(klass.getName());
            });
            klasserMenu.getItems().add(temp);
        }
    }

    private klasser converter(String klass) {
        klasser temp = null;
        switch (klass) {
            case "Krossare" -> temp = klasser.KROSSARE;
            case "Skrotskalle" -> temp = klasser.SKROTSKALLE;
            case "Zonstrykare" -> temp = klasser.ZONSTRYKARE;
            case "Fixare" -> temp = klasser.FIXARE;
            case "Mutant med hund" -> temp = klasser.MUTANT_MED_HUND;
            case "Krönikör" -> temp = klasser.KRÖNIKÖR;
            case "Boss" -> temp = klasser.BOSS;
            case "Slav" -> temp = klasser.SLAV;
        }
        return temp;
    }

    private void submitFunction(Stage stage) {
        submit.setOnAction(EventHandler -> {
            if (Objects.equals(klasserMenu.getText(), "Klasser")) {
                Alert warning = new Alert(Alert.AlertType.ERROR);
                warning.setContentText("Please select a class");
                warning.show();
            } else if (name.getText().isBlank()) {
                Alert nameWarning = new Alert(Alert.AlertType.ERROR);
                nameWarning.setContentText("Name cant be empty");
                nameWarning.show();
            } else {
                mainApplication.player = new MakeChar(name.getText(), converter(klasserMenu.getText()));
                stage.close();
            }
        });
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        makeGrid(grid);
        makeMenu();
        MenuBar mb = new MenuBar();
        mb.getMenus().add(klasserMenu);
        VBox box = new VBox(mb);
        grid.add(box,0,0);
        grid.add(name,0,1);
        grid.add(submit,4,4);
        Scene scene = new Scene(grid, 320, 240);
        submitFunction(stage);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }
}