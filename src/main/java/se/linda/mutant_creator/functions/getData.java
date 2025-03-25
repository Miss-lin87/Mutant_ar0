package se.linda.mutant_creator.functions;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class getData {
    private JSONParser parser;
    private FileReader reader;

    public getData(String path) throws FileNotFoundException {
        this.parser = new JSONParser();
        this.reader = new FileReader(path);
    }

    public JSONObject getRawData() throws ParseException {
        JSONArray data = (JSONArray) parser.parse(reader);
        return (JSONObject) data.toArray()[0];
    }

    public String getSpecificData(String Key) throws ParseException {
        return (String) getRawData().get(Key);
    }
}