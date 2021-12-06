package com.example.streamingservicesearch;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import com.example.streamingservicesearch.MovieParser;
import com.example.streamingservicesearch.MovieModel;

public class MovieSearchAsyncTask extends AsyncTask<String, Void, List<MovieModel>> {

// AsyncTask is a templated (generic) class: AsyncTask<PARAMS, PROGRESS, RESULT>

// PARAMS is the datatype that we pass to execute()
//      a String representing an ingredient to search for recipes that use it
//      (from user input in MainActivity)
// PROGRESS is the datatype we use to report updates
//      not used in this lab -> Void (null)
// RESULT is the datatype that we send back on completion of this task
//      a List of RecipeModel (List<RecipeModel>) that represents all the results for the ingredient


    // instance of a RecipeListener (concrete implementation)
    private MovieListener listener;

    // setter
    public void setListener(MovieListener listener) {
        this.listener = listener;
    }


    @Override
    protected List<MovieModel> doInBackground(String... params) {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for
        Log.d("SearchAsyncTask", "doInBackground: " + searchTerm);

        //Get response
        String responseJson = MovieAPI.searchMovies(searchTerm);
        // can't go further until the search comes back with results


        // success? :)
        if (responseJson != null) {
            // get useful data from the response
            List<MovieModel> movieModelList = MovieParser.getResponse(responseJson);
            return movieModelList;
        }
        // no success :(
        return null;
    }

    @Override
    protected void onPostExecute(List<MovieModel> movieModels) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(movieModels);
        Log.d("SearchAsyncTask", "onPostExecute: " + movieModels);
        listener.onMovieCallback(movieModels);
    }

    public interface MovieListener {
        void onMovieCallback(List<MovieModel> models);
    }

    private MovieListener movieListener;
    public void setMovieListener(MovieListener movieListener) {
        this.movieListener = movieListener;
    }
}
