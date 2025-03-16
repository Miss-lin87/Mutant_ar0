package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.enums.stats;

import java.io.IOException;

public class StatsApplication extends Application {
    private Text Styrka = new Text("");
    private Text Kyla = new Text("");
    private Text Skärpa = new Text("");
    private Text Känsla = new Text("");
    private int rawPoints = 6;
    private Text totalPoints = new Text("");
    private Button submit = new Button("Submit");

    private void makeGrid(GridPane grid) {
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(25,25,25,25));
    }

    private void uppdateText(stats stat) {
        switch (stat) {
            case STYRKA -> Styrka.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
            case KYLA -> Kyla.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
            case SKÄRPA -> Skärpa.setText((String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat))));
            case KÄNSLA -> Känsla.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
        }
    }

    private Text converter(stats stat) {
        Text temp = null;
        switch (stat) {
            case STYRKA -> temp = Styrka;
            case KYLA -> temp = Kyla;
            case SKÄRPA -> temp = Skärpa;
            case KÄNSLA -> temp = Känsla;
        }
        return temp;
    }

    private void baseGrid(GridPane grid) {
        int placement = 1;
        for (stats stat : stats.values()) {
            Text disStat = new Text(stat.toString() + ": ");
            grid.add(disStat,0,placement);
            grid.add(converter(stat),1,placement);
            uppdateText(stat);
            placement ++;
        }
        grid.add(submit,0,placement+1);
    }

    private void addButtons(GridPane grid) {
        int placement = 1;
        for (stats stat : stats.values()) {
            grid.add(createButton(stat,"+",1),2,placement);
            grid.add(createButton(stat,"-",-1), 3, placement);
            placement ++;
        }
    }

    private Button createButton(stats stat, String label, int value) {
        Button temp = new Button(label);
        temp.setOnAction(actionEvent -> {
            if (rawPoints != 0 && value > 0) {
                mainApplication.player.getPlayer().getBasestats().setStat(stat, value);
                converter(stat).setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
                rawPoints = 14 - mainApplication.player.getPlayer().getBasestats().getTotal();
                totalPoints.setText(String.valueOf(rawPoints));
        } else if (rawPoints > -1 && value < 0) {
                mainApplication.player.getPlayer().getBasestats().setStat(stat, value);
                converter(stat).setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
                rawPoints = 14 - mainApplication.player.getPlayer().getBasestats().getTotal();
                totalPoints.setText(String.valueOf(rawPoints));
            }
        });
        return temp;
    }

    private void addText (GridPane grid) {
        grid.add(new Text("Total points left: "),0,0);
        grid.add(totalPoints,1,0);
        totalPoints.setText(String.valueOf(rawPoints));
    }

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        makeGrid(grid);
        baseGrid(grid);
        addText(grid);
        addButtons(grid);
        Scene scene = new Scene(grid, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main() {
        launch();
    }
}