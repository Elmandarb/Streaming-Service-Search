package com.example.streamingservicesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import com.example.streamingservicesearch.MovieSearchAsyncTask;

public class ResultsActivity extends AppCompatActivity {

    public static final String SEARCH_KEY = "SEARCH";
    TextView searchResultsText;
    TextView movieDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent newIntent = getIntent();
        String name = newIntent.getStringExtra(ResultsActivity.SEARCH_KEY);
        searchResultsText = findViewById(R.id.search_results_text);
        movieDescription = findViewById(R.id.movie_description);

        searchResultsText.setText("You searched for " + name);
        movieDescription.setText("Searching...");

        MovieSearchAsyncTask task = new MovieSearchAsyncTask();
        task.setMovieListener(new MovieSearchAsyncTask.MovieListener() {
            @Override
            public void onMovieCallback(List<MovieModel> models) {
                //responseText.setText("Number of matches: " + response);
                MovieModel response = models.get(1);
                searchResultsText.setText(response.getTitle());
                movieDescription.setText(response.getDescription());
            }
            task.execute(SEARCH_KEY); //How do I give my MovieSearchAsyncTask the name?
        });

        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swap = new Intent(ResultsActivity.this, SearchActivity.class);
                startActivity(swap);
            }
        });
    }
}