package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.mutant_creator.enums.stats;
import se.linda.mutant_creator.fxFunctions.Grid;

import java.io.IOException;

public class StatsApplication extends Application {
    private Text Styrka = new Text("");
    private Text Kyla = new Text("");
    private Text Skärpa = new Text("");
    private Text Känsla = new Text("");
    private int rawPoints = 6;
    private Text totalPoints = new Text("");
    private Button submit = new Button("Submit");
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(10, 10, false);

    private void uppdateText(stats stat) {
        switch (stat) {
            case STYRKA -> Styrka.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
            case KYLA -> Kyla.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
            case SKARPA -> Skärpa.setText((String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat))));
            case KANSLA -> Känsla.setText(String.valueOf(mainApplication.player.getPlayer().getBasestats().getStat(stat)));
        }
    }

    private Text converter(stats stat) {
        Text temp = null;
        switch (stat) {
            case STYRKA -> temp = Styrka;
            case KYLA -> temp = Kyla;
            case SKARPA -> temp = Skärpa;
            case KANSLA -> temp = Känsla;
        }
        return temp;
    }

    private void baseGrid(GridPane grid) {
        int placement = 1;
        for (stats stat : stats.values()) {
            Text disStat = new Text(stat.toString() + ": ");
            grid.add(disStat, 0, placement);
            grid.add(converter(stat), 1, placement);
            uppdateText(stat);
            placement++;
        }
        grid.add(submit, 0, placement + 1);
    }

    private void addButtons(GridPane grid) {
        int placement = 1;
        for (stats stat : stats.values()) {
            grid.add(createButton(stat, "+", 1), 2, placement);
            grid.add(createButton(stat, "-", -1), 3, placement);
            placement++;
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

    private void addText(GridPane grid) {
        grid.add(new Text("Total points left: "), 0, 0);
        grid.add(totalPoints, 1, 0);
        totalPoints.setText(String.valueOf(rawPoints));
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
        baseGrid(grid);
        addText(grid);
        addButtons(grid);
        Scene mainScene = new Scene(grid, V, V1);
        stage.setTitle(title);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        setStage(stage, mainGrid, 340, 275, "Stats");
    }
}