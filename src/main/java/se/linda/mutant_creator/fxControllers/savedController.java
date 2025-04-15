package se.linda.mutant_creator.fxControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import net.minidev.json.parser.ParseException;
import se.linda.mutant_creator.contructors.fardighet;
import se.linda.mutant_creator.enums.fardigheter;
import se.linda.mutant_creator.enums.specFardigheter;
import se.linda.mutant_creator.functions.savedCharFunctions;
import se.linda.mutant_creator.functions.tempData;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static se.linda.mutant_creator.enums.equipment.*;
import static se.linda.mutant_creator.enums.stats.*;

public class savedController implements Initializable {
    private tempData player;
    @FXML private Text playerName;
    @FXML private Text playerklass;
    @FXML private Text playerStyrka;
    @FXML private Text playerKyla;
    @FXML private Text playerSkarpa;
    @FXML private Text playerKänsla;
    @FXML private Text patronerValue;
    @FXML private Text krubbValue;
    @FXML private Text vattenValue;
    @FXML private TableView<fardighet> skillsTable;
    @FXML private TableColumn<fardighet, String> nameColumn = new TableColumn<>("Name");
    @FXML private TableColumn<fardighet, String> valueColumn = new TableColumn<>("Value");

    public savedController(String name) throws FileNotFoundException, ParseException {
        this.player = new tempData(name);
    }

    private void setBaseInfo() {
        getPlayerName().setText(player.getName());
        getPlayerklass().setText(player.getKlass().getName());
    }

    private void setStats() {
        getPlayerStyrka().setText(String.valueOf(player.getCharStats().get(STYRKA)));
        getPlayerKyla().setText(String.valueOf(player.getCharStats().get(KYLA)));
        getPlayerKänsla().setText(String.valueOf(player.getCharStats().get(KANSLA)));
        getPlayerSkarpa().setText(String.valueOf(player.getCharStats().get(SKARPA)));
    }

    private void setSkillsTable() {
        for (fardigheter skill : player.getSkills().keySet()) {
            skillsTable.getItems().add(new fardighet(skill.getName(), String.valueOf(player.getSkills().get(skill))));
        }
        for (specFardigheter skill : player.getSpecSkill().keySet()) {
            skillsTable.getItems().add(new fardighet(skill.getName(), String.valueOf(player.getSpecSkill().get(skill))));
        }
    }

    private void setEquipment() {
        patronerValue.setText(String.valueOf(player.getBackpack().get(PATRONER)));
        krubbValue.setText(String.valueOf(player.getBackpack().get(KRUBB)));
        vattenValue.setText(String.valueOf(player.getBackpack().get(VATTEN)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.player = new tempData("Linda");
            setBaseInfo();
            setStats();
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("skillName"));
            valueColumn.setCellValueFactory(new PropertyValueFactory<>("skillValue"));
            setSkillsTable();
            setEquipment();
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Text getPlayerklass() {
        return playerklass;
    }

    public Text getPlayerStyrka() {
        return playerStyrka;
    }

    public Text getPlayerKyla() {
        return playerKyla;
    }

    public Text getPlayerSkarpa() {
        return playerSkarpa;
    }

    public Text getPlayerKänsla() {
        return playerKänsla;
    }

    public Text getPlayerName() {
        return playerName;
    }
}
