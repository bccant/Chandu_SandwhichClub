package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        /* Sandwich Name Details */
        final String SD_NAME_DETAILS = "name";

        /* Sandwich Name */
        final String SD_NAME = "mainName";

        /* Alias List */
        final String SD_ALIAS = "alsoKnownAs";

        /* Sandwich origin place */
        final String SD_ORIGIN = "placeOfOrigin";

        /* Sandwich description */
        final String SD_DESC = "description";

        /* Sandwich image */
        final String SD_IMAGE = "image";

        /* Sandwich ingredients */
        final String SD_ING = "ingredients";

        JSONObject sandwichJO = new JSONObject(json);

        JSONObject sand_name = sandwichJO.getJSONObject(SD_NAME_DETAILS);

        String mainName = sand_name.getString(SD_NAME);
        JSONArray alsoKnownArray = sand_name.getJSONArray(SD_ALIAS);
        List<String> alsoKnownAs = jsonArrayToList(alsoKnownArray);

        String placeOfOrigin = sandwichJO.getString(SD_ORIGIN);
        String sdDesc = sandwichJO.getString(SD_DESC);
        String sdImage = sandwichJO.getString(SD_IMAGE);

        JSONArray sdIngredients = sandwichJO.getJSONArray(SD_ING);
        List<String> sandIngred = jsonArrayToList(sdIngredients);

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, sdDesc, sdImage, sandIngred);
    }

    public static List<String> jsonArrayToList(JSONArray rawArray) throws JSONException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < rawArray.length(); i++) {
            list.add(rawArray.getString(i));
        }

        return list;
    }
}
