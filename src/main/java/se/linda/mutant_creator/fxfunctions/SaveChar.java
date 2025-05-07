package se.linda.mutant_creator.fxfunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.linda.mutant_creator.Constants;
import se.linda.mutant_creator.playerfunctions.MakeChar;
import java.io.*;
import java.lang.reflect.Field;

public class SaveChar {
    private final String name;
    private final MakeChar player;
    private final JSONArray jsonArray;

    public SaveChar(String name, MakeChar player) throws IOException {
        this.player = player;
        this.name = name;
        this.jsonArray = new JSONArray();
    }

    private boolean checkAvilability(String name) {
        File folder = new File(Constants.CHAR_PATH); //TO DO make constant
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
            File temp = new File(Constants.CHAR_SAVE_PATH.formatted(this.name));
            if (temp.createNewFile()) {
                FileWriter file = new FileWriter(Constants.CHAR_SAVE_PATH.formatted(this.name));
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