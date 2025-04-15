package se.linda.mutant_creator.fxFunctions;

import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.linda.mutant_creator.Player_functions.MakeChar;

import java.io.*;
import java.lang.reflect.Field;
import java.security.Key;
import java.util.Map;

public class SaveChar {
    private String name;
    private MakeChar player;
    private JSONArray jsonArray;

    public SaveChar(String name, MakeChar player) throws IOException {
        this.player = player;
        this.name = name;
        this.jsonArray = new JSONArray();
    }

    private boolean checkAvilability(String name) {
        File folder = new File("src/main/java/se/linda/mutant_creator/characters");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                return true;
            }
        }
        return false;
    }

    public void fillFile() throws JSONException {
        for (Field F : player.getClass().getDeclaredFields()) {
            JSONObject tempData = new JSONObject();
            tempData.put(F.getName(), player.getFieldValue(F));
            this.jsonArray.put(tempData);
        }
    }

    public void save() throws IOException {
        try {
            File temp = new File("src/main/java/se/linda/mutant_creator/characters/" + this.name + ".json");
            if (temp.createNewFile()) {
                FileWriter file = new FileWriter("src/main/java/se/linda/mutant_creator/characters/" + this.name + ".json");
                BufferedWriter write = new BufferedWriter(file);
                fillFile();
                write.write(this.jsonArray.toString());
                write.close();
            } else {
                throw new IOException();
            }
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public JSONArray getJArray() {
        return this.jsonArray;
    }
}