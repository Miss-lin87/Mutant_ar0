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
import se.linda.mutant_creator.Player_functions.baseFunctions.Färdigheter;
import se.linda.mutant_creator.Player_functions.baseFunctions.Talent;
import se.linda.mutant_creator.enums.fardigheter;
import se.linda.mutant_creator.enums.klasser;
import se.linda.mutant_creator.enums.specFardigheter;
import se.linda.mutant_creator.enums.talanger;
import se.linda.mutant_creator.functions.converters;
import se.linda.mutant_creator.fxFunctions.gridMaker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class charApplication extends Application {
    private TextField name = new TextField();
    private Menu klasserMenu = new Menu("Klasser");
    private Menu talentsMenu = new Menu("Talanger");
    private Button submit = new Button("Submit");
    private Button info = new Button("?");
    private Button close = new Button("Cancel");
    private GridPane grid = new gridMaker(10,10, false).getGrid();
    private Alert warning = new Alert(Alert.AlertType.ERROR);
    private int mainRowCount = 0;
    private int mainColumnCount = 0;
    private HashMap<fardigheter, Integer> skillsMap = new HashMap<>();
    private int skillPoints = 10;
    private Text pointsText = new Text(String.valueOf(skillPoints));
    private int specSkillValue = 1;

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
        for (talanger talang : new Talent(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getTalents()) {
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
                mainApplication.player = new MakeChar(name.getText(), new converters().stringTOEnum(klasserMenu.getText(), klasser.values()));
                mainApplication.player.getPlayer().setSelectedTalent(new converters().stringTOEnum(talentsMenu.getText(), talanger.values()));
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
                String temp = new Talent(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getDescription(new converters().stringTOEnum(talentsMenu.getText(), talanger.values()));
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
            grid.add(new Text("Select Talent: "),0,mainRowCount);
            talentsMenu.setDisable(false);
            grid.add(makeTalentMenu(grid),1,mainRowCount);
            grid.add(info, 2,mainRowCount);
            addSpecSkill(grid);
        } else if (submit.isDisable() && !talentsMenu.isDisable()) {
            submit.setDisable(false);
            grid.add(submit,1, mainRowCount+2);
        }
    }

    private void addSpecSkill(GridPane grid) {
        Text specTemp = new Text("1");
        int position = grid.getRowCount();
        specTemp.setId(new Färdigheter(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills().name());
        grid.add(new Text(new Färdigheter(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills().name()),mainColumnCount-1,position);
        grid.add(specTemp,mainColumnCount, position);
        grid.add(makeSpecSkillButton("+", new Färdigheter(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills(),1),mainColumnCount+1, position);
        grid.add(makeSpecSkillButton("-", new Färdigheter(new converters().stringTOEnum(klasserMenu.getText(), klasser.values())).getSpecSkills(),-1),mainColumnCount+2, position);
    }

    private void addSkills(GridPane grid) {
        int line = 1;
        int column = grid.getColumnCount()-1;
        for (fardigheter skill : fardigheter.values()) {
            Text tempValue = new Text("0");
            tempValue.setId(skill.name());
            grid.add(new Text(skill.name()),column,line);
            grid.add(tempValue,column+1,line);
            skillsMap.put(skill, 0);
            line++;
        }
    }

    private void addSkillButtons(GridPane grid) {
        int position = 1;
        for (fardigheter skill : fardigheter.values()) {
            grid.add(makeSkillButtons("+", skill, 1),mainColumnCount+1,position);
            grid.add(makeSkillButtons("-", skill, -1),mainColumnCount+2,position);
            position ++;
        }
    }

    private Button makeSpecSkillButton(String label, specFardigheter skill, int value) {
        Button temp = new Button(label);
        temp.setOnAction(EventHandler -> {
            int tempInt = Math.max(specSkillValue+value, 1);
            if (specSkillValue < 4 && value > 0 || specSkillValue > 1 && value < 0) {
                specSkillValue = tempInt;
                setSkillPointsValue();
                ((Text) grid.getChildren().get(grid.getChildren().indexOf(Objects.requireNonNull(grid.lookup("#"+skill.name()))))).setText(String.valueOf(specSkillValue));
                pointsText.setText(String.valueOf(skillPoints));
            }
            //specSkillValue = Math.max(specSkillValue+value, 1);
            //setSkillPointsValue();
            //((Text) grid.getChildren().get(grid.getChildren().indexOf(Objects.requireNonNull(grid.lookup("#"+skill.name()))))).setText(String.valueOf(specSkillValue));
            //pointsText.setText(String.valueOf(skillPoints));
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
                ((Text) grid.getChildren().get(grid.getChildren().indexOf(Objects.requireNonNull(grid.lookup("#"+skill.name()))))).setText(String.valueOf(tempInt));
                pointsText.setText(String.valueOf(skillPoints));
            }
        });
        return temp;
    }

    private void setSkillPointsValue() {
        int temp = 10;
        for (int value : skillsMap.values()) {
            temp -= value;
        }
        temp -= specSkillValue;
        skillPoints = temp;
    }

    private void pupulateGrid(GridPane grid) {
        talentsMenu.setDisable(true);
        submit.setDisable(true);
        grid.add(new Text("Make a new Character"),0, grid.getRowCount());
        grid.add(close,1,grid.getRowCount()-1);
        grid.add(new Text("Name: "),0, grid.getRowCount());
        grid.add(name,1,grid.getRowCount()-1);
        grid.add(new Text("Klass: "),0, grid.getRowCount());
        grid.add(makeKlassMenu(grid),1, grid.getRowCount()-1);
        grid.add(new Text("Skill Points"),2, 0);
        grid.add(pointsText,3,0);
        mainRowCount = grid.getRowCount();
        mainColumnCount = grid.getColumnCount();
        addSkills(grid);
        addSkillButtons(grid);
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
        setStage(stage, grid,550,475,"New Character");
    }
}