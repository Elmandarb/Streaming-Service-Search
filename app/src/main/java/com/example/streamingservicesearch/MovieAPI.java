package com.example.streamingservicesearch;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieAPI {
    private static final String baseApiUrl = "https://streaming-availability.p.rapidapi.com/search/basic?country=us&service=netflix&type=movie&genre=18&page=1&output_language=en&language=en"; //Just searching netflix rn
    private static final String apiKey = "87d2ffd533msh44188d25d496f68p13a53bjsn3131b3909eae";


    public static String searchMovies(String input) {

        // piece together a valid url, starting with the base
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        // and adding on a few more parts
        urlBuilder.addQueryParameter("apiKey", apiKey);
        urlBuilder.addQueryParameter("title", input);

        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        return getResponse(url);

    }

    private static String getResponse(String url) {
        // form the Request with the url
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client = new OkHttpClient();
        try {
            // ask the server for a response
            Response response = client.newCall(request).execute();
            // `response` also contains metadata: success/fail, travel time, etc.
            // only need the body of the result (as a string)
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
