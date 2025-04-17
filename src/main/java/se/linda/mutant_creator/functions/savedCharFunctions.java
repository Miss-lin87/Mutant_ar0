package se.linda.mutant_creator.functions;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class savedCharFunctions {
    private final List<String> charNames = new ArrayList<>();
    private final String path = "src/main/java/se/linda/mutant_creator/characters/%s.json";
    private final JSONParser parser = new JSONParser();
    private FileReader reader;

    private void getCharacters() {
        File folder = new File("src/main/java/se/linda/mutant_creator/characters");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                charNames.add(file.getName().substring(0, file.getName().indexOf(".json")));
            }
        }
    }

    public List<String> getCharNames() {
        getCharacters();
        return charNames;
    }

    private JSONArray getRawData(String name) throws ParseException, FileNotFoundException {
        this.reader = new FileReader(path.formatted(name));
        return (JSONArray) parser.parse(reader);
    }

    public JSONObject getTypeData(String name, String Key) throws ParseException, FileNotFoundException {
        this.reader = new FileReader(path.formatted(name));
        int index = -1;
        for (Object object : (JSONArray) parser.parse(reader)) {
            JSONObject jsonObject = (JSONObject) object;
            if (jsonObject.containsKey(Key)) {
                index = getRawData(name).indexOf(object);
            }
        }
        return (JSONObject) getRawData(name).get(index);
    }

    public <T> Map<T, Integer> makeMap(String input, T[] enums) {
        converters con = new converters();
        Map<T, Integer> map = new HashMap<>();
        String[] tempString = input
                .replace("{","")
                .replace("}","")
                .split(", ");
        for (String S : tempString) {
            map.put(con.stringTOEnum(S.split("=")[0], enums), Integer.valueOf(S.split("=")[1]));
        }
        return map;
    }
}