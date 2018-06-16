package com.example.johnla.alphavantagestockapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnla on 6/16/18.
 */

public class DataParser implements JsonDeserializer<DailyInfo> {

    @Override
    public DailyInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        DailyInfo result = new DailyInfo();

        try {
            final HashMap<String, String> valueMap = readServiceUrlMap(json.getAsJsonObject());
            if(valueMap != null) {
                //result.dailyInfoValues = valueMap;
            }
        } catch (JsonSyntaxException jse) {
            // TODO put a warning log in here
            return null;
        }

        return result;
    }

    private HashMap<String, String> readServiceUrlMap(final JsonObject jsonObject) throws JsonSyntaxException {
        if(jsonObject == null) {
            return null;
        }
        Gson gson = new Gson();
        HashMap<String, String> valueMap = new HashMap<>();
        Log.d("JOHN", "Deserializing");

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = gson.fromJson(entry.getValue(), String.class);
            valueMap.put(key, value);
        }

        return valueMap;
    }
}
