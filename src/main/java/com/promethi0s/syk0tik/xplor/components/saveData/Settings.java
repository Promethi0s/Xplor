package com.promethi0s.syk0tik.xplor.components.saveData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Settings {

    public int screenHeight, screenWidth, screenScale, screenBoundsBuffer;

    public Settings() {

        save();
        load();

    }

    @SuppressWarnings("unchecked")
    public void load() {

        File file = new File("settings");

        if (!file.exists()) {

            screenWidth = 1;
            screenHeight = 1;
            screenScale = 1;
            screenBoundsBuffer = 50;
            return;

        }

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            screenWidth = ((Long) jsonObject.get("screenWidth")).intValue();
            screenHeight = ((Long) jsonObject.get("screenHeight")).intValue();
            screenScale = ((Long) jsonObject.get("screenScale")).intValue();
            screenBoundsBuffer = ((Long) jsonObject.get("screenBoundsBuffer")).intValue();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void save() {

        JSONObject obj = new JSONObject();

        obj.put("screenWidth", 400);
        obj.put("screenHeight", 300);
        obj.put("screenScale", 2);
        obj.put("screenBoundsBuffer", 50);

        try {

            FileWriter file = new FileWriter("settings");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
