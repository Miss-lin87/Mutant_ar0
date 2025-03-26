package se.linda.mutant_creator.fxFunctions;

import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.linda.mutant_creator.Player_functions.MakeChar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveChar {
    private String name;
    private MakeChar player;
    private JSONArray jsonArray;

    public SaveChar(String name, MakeChar player) throws IOException {
        this.player = player;
        this.name = name;
        this.jsonArray = new JSONArray();
    }

    private void fillFile(MakeChar player) throws JSONException {
        JSONObject tempData = new JSONObject();
        tempData.put("Name", player.getName());
        tempData.put("Klass", player.getPlayer().getKlass().getName());
        tempData.put("Basestats", player.getPlayer().getBasestats().toString());
        this.jsonArray.put(tempData);
    }

    public void save() throws IOException {
        try {
            File temp = new File("src/main/java/se/linda/mutant_creator/characters/" + this.name + ".json");
            if (temp.createNewFile()) {
                FileWriter file = new FileWriter("src/main/java/se/linda/mutant_creator/characters/" + this.name + ".json");
                BufferedWriter write = new BufferedWriter(file);
                fillFile(this.player);
                write.write(jsonArray.toString());
                write.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getJArray() throws IOException {
        return this.jsonArray;
    }
}