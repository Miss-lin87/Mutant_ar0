package se.linda.mutant_creator.fxPages;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import se.linda.mutant_creator.Player_functions.MakeChar;
import se.linda.mutant_creator.Player_functions.baseFunctions.Basestats;
import se.linda.mutant_creator.Player_functions.baseFunctions.Equipment;
import se.linda.mutant_creator.Player_functions.baseFunctions.Talent;
import se.linda.mutant_creator.enums.*;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.functions.funcs;
import se.linda.mutant_creator.fxFunctions.Grid;
import se.linda.mutant_creator.fxFunctions.stageSetter;

import java.io.IOException;
import java.util.*;

import static se.linda.mutant_creator.enums.stats.*;

public class makeCharPage extends Application {
    private final Grid grid = new Grid();
    private final GridPane mainGrid = grid.getGrid(5,5, false);
    private int statPoints = 6;
    private int skillPoints = 10;
    //Texts
    private Text Styrka = new Text(STYRKA.name);
    private Text Kyla = new Text(KYLA.name);
    private Text Skärpa = new Text(SKARPA.name);
    private Text Känsla = new Text(KANSLA.name);
    private final Text statPointsText = new Text(String.valueOf(statPoints));
    private final Text skillPointsText = new Text(String.valueOf(skillPoints));
    //Maps
    private EnumMap<stats, Integer> statsMap = new EnumMap<>(Map.of(
            STYRKA, 2,
            KYLA, 2,
            SKARPA, 2,
            KANSLA, 2));
    private final HashMap<fardigheter, Integer> skillsMap = new HashMap<>();
    private HashMap<specFardigheter, Integer> specSkill = new HashMap<>();
    private String bestStat = "";
    private final TextField name = new TextField();
    private final Menu klasserMenu = new Menu("Klasser");
    private final Menu talentsMenu = new Menu("Talanger");
    private final Button submit = new Button("Submit");
    private final Button info = new Button("?");
    private final Button close = new Button("Cancel");
    private final Alert warning = new Alert(Alert.AlertType.ERROR);
    private converters con = new converters();
    private boolean nameTaken = false;


    public static void main(String[] args) {
        launch(args);
    }

    private void setHighlight(boolean OnOff, Text... text) {
        boolean highlight = OnOff;
        Color highlightColor = OnOff ? Color.GREEN : Color.BLACK;
        for (Text T : text) {
            T.setUnderline(highlight);
            T.setFill(highlightColor);
        }
    }

    private void bestStatVisibility(stats stat) {
        setHighlight(false, Styrka, Kyla, Skärpa, Känsla);
        switch (stat) {
            case STYRKA -> setHighlight(true, Styrka);
            case KYLA -> setHighlight(true, Kyla);
            case SKARPA -> setHighlight(true, Skärpa);
            case KANSLA -> setHighlight(true, Känsla);
        }
        bestStat = stat.name;
    }

    private void lowerMaxStat() {
        for (stats stat : statsMap.keySet()) {
            if (statsMap.get(stat) == 5 && !con.getKlassList(stat).contains(klasserMenu.getText())) {
                statsMap.put(stat, 4);
                setStatPointValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+stat.name()))))).setText("4");
                statPointsText.setText(String.valueOf(statPoints));
            }
        }
    }

    private VBox makeKlassMenu() {
        MenuBar mb = new MenuBar();
        for (klasser klass: klasser.values()) {
            MenuItem temp = new MenuItem(klass.getName());
            temp.setOnAction(EventHandler -> {
                if (Objects.equals(klasserMenu.getText(),"Klasser")) {
                    bestStatVisibility(new Basestats(klass).getBeststat());
                    klasserMenu.setText(klass.getName());
                    addSpecSkill(mainGrid.getRowCount(), 4);
                } else {
                    klasser klazz = con.stringTOEnum(klasserMenu.getText(), klasser.values());
                    bestStatVisibility(new Basestats(klass).getBeststat());
                    removeSpecialSkill(con.findSpecSkill(klazz));
                    klasserMenu.setText(klass.getName());
                    addSpecSkill(mainGrid.getRowCount(), 4);
                    lowerMaxStat();
                }
                if (talentsMenu.isDisable()) {
                    extendView();
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
                    extendView();
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
                mainPage.player = new MakeChar(name.getText(),
                        con.stringTOEnum(klasserMenu.getText(), klasser.values()),
                        skillsMap,
                        statsMap,
                        specSkill,
                        new Equipment(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getEquipment());
                mainPage.character.setText(mainPage.player.getName());
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
            } else {
                String temp = new Talent(con.stringTOEnum(klasserMenu.getText(), klasser.values())).getDescription(con.stringTOEnum(talentsMenu.getText(), talanger.values()));
                tip.setText(temp);
                info.setTooltip(tip);
            }
        });
        close.setOnAction(EventHandler -> {
            stage.close();
        });
        name.setOnKeyReleased(KeyEvent -> {
            String tempName = name.getText();
            List<String> names = new funcs().getCharNames();
            if (names.contains(tempName)) {
                nameTaken = true;
                name.setStyle("-fx-text-fill: red;");
            } else {
                nameTaken = false;
                name.setStyle("-fx-text-fill: black;");
            }
        });
    }

    private void extendView() {
        if (talentsMenu.isDisable()) {
            mainGrid.add(new Text("Select Talent: "),0,7);
            talentsMenu.setDisable(false);
            mainGrid.add(makeTalentMenu(),1, 7);
            mainGrid.add(info, 2, 7);
        } else if (submit.isDisable() && !talentsMenu.isDisable()) {
            submit.setDisable(false);
            mainGrid.add(submit,1, 9);
        }
    }

    private void removeSpecialSkill(specFardigheter specskill) {
        int index = mainGrid.getChildren().indexOf(mainGrid.lookup("#" + specskill.toString()));
        mainGrid.getChildren().remove(index+2);
        mainGrid.getChildren().remove(index+1);
        mainGrid.getChildren().remove(index);
        mainGrid.getChildren().remove(index-1);
        specSkill.remove(specskill);
        skillPointsText.setText(String.valueOf(skillPoints));
    }

    private void addSpecSkill(int row, int column) {
        Text specTemp = new Text("1");
        specFardigheter specSkillName = con.findSpecSkill(con.stringTOEnum(klasserMenu.getText(), klasser.values()));
        specTemp.setId(specSkillName.toString());
        mainGrid.add(new Text(specSkillName.toString()),column,row);
        mainGrid.add(specTemp,column+1, row);
        mainGrid.add(makeSpecSkillButton("+", specSkillName,1),column+2, row);
        mainGrid.add(makeSpecSkillButton("-", specSkillName,-1),column+3, row);
        specSkill.put(specSkillName, 1);
        setSkillPointsValue();
        skillPointsText.setText(String.valueOf(skillPoints));
    }

    private void addSkills(int row, int column) {
        mainGrid.add(new Text("Points Remaining: "), column, row);
        for (fardigheter skill : fardigheter.values()) {
            row++;
            Text tempValue = new Text("0");
            tempValue.setId(skill.name());
            mainGrid.add(new Text(skill.name()), column, row);
            mainGrid.add(tempValue,column+1, row);
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
            int tempInt = Math.max(specSkill.get(skill)+value, 1);
            if (skillPoints > 0 && tempInt < 4 || value < 0 && tempInt < 4 && skillPoints > -1) {
                specSkill.put(skill, tempInt);
                setSkillPointsValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+skill.toString()))))).setText(String.valueOf(tempInt));
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
            int maxStat = stat.name.equals(bestStat) ? 6 : 5;
            int tempInt = Math.max(statsMap.get(stat)+value, 2);
            if (statPoints > 0 && tempInt < maxStat || value < 0 && tempInt < maxStat && statPoints > -1) {
                statsMap.put(stat, tempInt);
                setStatPointValue();
                ((Text) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(Objects.requireNonNull(mainGrid.lookup("#"+stat.name()))))).setText(String.valueOf(tempInt));
                statPointsText.setText(String.valueOf(statPoints));
            }
        });
        return temp;
    }

    private void setStatPointValue() {
        int temp = 14;
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
        temp -= Math.max(specSkill.get(con.findSpecSkill(con.stringTOEnum(klasserMenu.getText(), klasser.values()))),0);
        skillPoints = temp;
    }

    private void popColumFour() {
        addSkills(0, mainGrid.getColumnCount());
        addSkillButtons(0, mainGrid.getColumnCount());
    }

    private void popColumThree() {
        grid.addNode(mainGrid, 0,2, statPointsText);
        grid.addNodes(mainGrid,2,3,
                makeStatsButton("-", STYRKA, -1),
                makeStatsButton("-", KYLA, -1),
                makeStatsButton("-", SKARPA, -1),
                makeStatsButton("-", KANSLA, -1)
        );
    }

    private void popColumTwo() {
        grid.addNodes(mainGrid,2,2,
                makeStatsButton("+", STYRKA,1),
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
                new Text("Stat Points Remaining: "),
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

    private void pupulateGrid(Stage stage) {
        popColumZero();
        popColumOne();
        popColumTwo();
        popColumThree();
        popColumFour();
        submitFunction(stage);
        buttonFunction(stage);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stageSetter set = new stageSetter();
        setVisibility();
        pupulateGrid(stage);
        set.setStage(stage, mainGrid, 525, 450, "New Character");
    }
}