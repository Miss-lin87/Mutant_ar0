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
import se.linda.mutant_creator.Player_functions.baseFunctions.Fardigheter;
import se.linda.mutant_creator.enums.*;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.fxFunctions.Grid;

import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static se.linda.mutant_creator.enums.stats.*;

public class charApplication extends Application {
    //Texts
    private Text Styrka = new Text(STYRKA.name);
    private Text Kyla = new Text(KYLA.name);
    private Text Skärpa = new Text(SKARPA.name);
    private Text Känsla = new Text(KANSLA.name);
    //Maps
    private EnumMap<stats, Integer> statsMap = new EnumMap<>(Map.of(STYRKA, STYRKA.getValue(),
            KYLA, KYLA.getValue(),
            SKARPA, SKARPA.getValue(),
            KANSLA, KANSLA.getValue()));
    private final HashMap<fardigheter, Integer> skillsMap = new HashMap<>();
    private final TextField name = new TextField();
    private final Menu klasserMenu = new Menu("Klasser");
    private final Menu talentsMenu = new Menu("Talanger");
    private final Button submit = new Button("Submit");
    private final Button info = new Button("?");
    private final Button close = new Button("Cancel");
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(5,5, true);
    private final Alert warning = new Alert(Alert.AlertType.ERROR);
    private int statPoints = 6;
    private int skillPoints = 10;
    private final Text statPointsText = new Text(String.valueOf(statPoints));
    private final Text skillPointsText = new Text(String.valueOf(skillPoints));
    private int specSkillValue = 1;
    private converters con = new converters();

    public static void main(String[] args) {
        launch(args);
    }

    private VBox makeKlassMenu() {
        MenuBar mb = new MenuBar();
        for (klasser klass: klasser.values()) {
            MenuItem temp = new MenuItem(klass.getName());
            temp.setOnAction(EventHandler -> {
                klasserMenu.setText(klass.getName());
                if (talentsMenu.isDisable()){
                    extendView(mainGrid);
                } else {
                    makeTalentMenu();
                }
            });
            klasserMenu.getItems().add(temp);
        }
        mb.getMenus().add(klasserMenu);
        return new VBox(mb);
    }

    private VBox makeTalentMenu() {
        MenuBar mb = new MenuBar();
        talentsMenu.getItems().clear();
        for (talanger talang : new Talent(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getTalents()) {
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
                mainApplication.player = new MakeChar(name.getText(), con.stringTOEnum(klasserMenu.getText(), klasser.values()));
                mainApplication.player.getPlayer().setSelectedTalent(con.stringTOEnum(talentsMenu.getText(), talanger.values()));
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
                info.Tooltip(tip);
            } else {
                String temp = new Talent(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getDescription(con.stringTOEnum(talentsMenu.getText(), talanger.values()));
                tip.setText(temp);
                info.setTooltip(tip);
            }
        });
        close.setOnAction(EventHandler -> {
            stage.close();
        });
    }


    private void extendView() {
        if (talentsMenu.isDisable()) {
            mainGrid.add(new Text("Select Talent: "),0,7);
            talentsMenu.setDisable(false);
            mainGrid.add(makeTalentMenu(),1, 7);
            mainGrid.add(info, 2, 7);
            addSpecSkill(mainGrid.getRowCount(), 5);
        } else if (submit.isDisable() && !talentsMenu.isDisable()) {
            submit.setDisable(false);
            mainGrid.add(submit,1, 9);
        }
    }

    private void addSpecSkill(int row, int column) {
        Text specTemp = new Text("1");
        specTemp.setId(new Fardigheter(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills().name());
        mainGrid.add(new Text(new Fardigheter(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills().name()),column,row);
        mainGrid.add(specTemp,column+1, row);
        mainGrid.add(makeSpecSkillButton("+", new Fardigheter(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills(),1),column+2, row);
        mainGrid.add(makeSpecSkillButton("-", new Fardigheter(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills(),-1),column+3, row);
    }

    private void addSkills(int row, int column) {
        mainGrid.add(new Text("Points Remaining: "), column, row);
        for (fardigheter skill : fardigheter.values()) {
            row++;
            Text tempValue = new Text("0");
            tempValue.setId(skill.name());
            mainGrid.add(new Text(skill.name()), column, row);
            mainGrid.add(tempValue,column+1,row);
            skillsMap.put(skill, 0);
        }
    }

    private void addSkillButtons(int row, int column) {
        mainGrid.add(skillPointsText, column, row);
        for (fardigheter skill : fardigheter.values()) {
            row ++;
            mainGrid.add(makeSkillButtons("+", skill, 1),column,row);
            mainGrid.add(makeSkillButtons("-", skill, -1),column+1,row);
        }
    }

    private Button makeSpecSkillButton(String label, specFardigheter skill, int value) {
        Button temp = new Button(label);
        temp.setOnAction(EventHandler -> {
            int tempInt = Math.max(specSkillValue+value, 1);
            if (specSkillValue < 3 && value > 0 || specSkillValue > 1 && value < 0) {
                specSkillValue = tempInt;
                setSkillPointsValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+skill.name()))))).setText(String.valueOf(specSkillValue));
                skillPointsText.setText(String.valueOf(skillPoints));
            }
        });
        return temp;
    }

    private Button makeSkillButtons(String Label, fardigheter skill, int value) {
        Button temp = new Button(Label);
        temp.setOnAction(EventHandler -> {
            int tempInt = Math.max(skillsMap.get(skill)+value, 0);
            if (skillPoints > 0 && tempInt < 4 || value < 0 && tempInt < 4 && skillPoints > -1) {
                skillsMap.put(skill, tempInt);
                setSkillPointsValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+skill.name()))))).setText(String.valueOf(tempInt));
                skillPointsText.setText(String.valueOf(skillPoints));
            }
        });
        return temp;
    }

    private Button makeStatsButton(String Label, stats stat, int value) {
        Button temp = new Button(Label);
        temp.setOnAction(EventHandler -> {
            int tempInt = Math.max(statsMap.get(stat)+value, 2);
            if (statPoints > 0 && tempInt < 5 || value < 0 && tempInt < 5 && statPoints > -1) {
                statsMap.put(stat, tempInt);
                setStatPointValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+stat.name()))))).setText(String.valueOf(tempInt));
                statPointsText.setText(String.valueOf(statPoints));
            }
        });
        return temp;
    }

    private void setStatPointValue() {
        int temp = 6;
        for (int value : statsMap.values()) {
            temp -= value;
        }
        statPoints = temp;
    }

    private void setSkillPointsValue() {
        int temp = 10;
        for (int value : skillsMap.values()) {
            temp -= value;
        }
        temp -= specSkillValue;
        skillPoints = temp;
    }

    private void popColumFour() {
        addSkills(0, mainGrid.getColumnCount());
        addSkillButtons(0, mainGrid.getColumnCount());
    }

    private void popColumThree() {
        grid.addNodes(mainGrid,2,3,
                makeStatsButton("-", STYRKA, -1),
                makeStatsButton("-", KYLA, -1),
                makeStatsButton("-", SKARPA, -1),
                makeStatsButton("-", KANSLA, -1)
        );
    }

    private void popColumTwo() {
        grid.addNodes(mainGrid,2,2,
                makeStatsButton("+",STYRKA,1),
                makeStatsButton("+", KYLA, 1),
                makeStatsButton("+", SKARPA, 1),
                makeStatsButton("+", KANSLA, 1)
        );
    }

    private Text makeStatText(stats stat) {
        Text tempValue = new Text(statsMap.get(stat).toString());
        tempValue.setId(stat.name());
        return tempValue;
    }

    private void popColumOne() {
        Text strValue = makeStatText(STYRKA);
        Text kylaValue = makeStatText(KYLA);
        Text skarValue = makeStatText(SKARPA);
        Text kanValue = makeStatText(KANSLA);
        grid.addNodes(mainGrid,0,1,
                new Text("New Character"),
                name,
                strValue, kylaValue, skarValue, kanValue,
                makeKlassMenu());
    }

    private void popColumZero() {
        grid.addNodes(mainGrid, 1,0,
                new Text("Name: "),
                Styrka, Kyla, Skärpa, Känsla,
                new Text("Klass: "));
    }

    private void setVisibility() {
        talentsMenu.setDisable(true);
        submit.setDisable(true);
    }

    private void pupulateGrid() {
        popColumZero();
        popColumOne();
        popColumTwo();
        popColumThree();
        popColumFour();
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
        setVisibility();
        pupulateGrid();
        setStage(stage, mainGrid,650,525,"New Character");
    }
}