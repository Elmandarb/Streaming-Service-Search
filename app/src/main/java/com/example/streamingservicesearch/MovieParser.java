package com.example.streamingservicesearch;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

import com.example.streamingservicesearch.MovieModel;

public class MovieParser {

    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "MovieParser";

    public static List<MovieModel> getResponse(String json) {
        Gson gson = new Gson();
        Type responseType = new TypeToken<List<MovieModel>>() {}.getType();
        List<MovieModel> response = gson.fromJson(json, responseType);
        return response;
    }

    public static int getTotalMatches(String json) {
        int totalMatches = 0;

        try {
            // convert the raw string into a Java JSONObject
            JSONArray response = new JSONArray(json);

            // deserialize an integer
            totalMatches = response.length();

        } catch (JSONException e) {
            Log.e(TAG, "getTotalMatches: error parsing JSON", e);
        }

        return totalMatches;
    }
}

