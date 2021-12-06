package com.example.streamingservicesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class SuggestionsActivity extends AppCompatActivity {
    ListView ssView, gView;
    private Button resultsButton;
    String streamServices[]
            = { "Amazon Prime Video", "Disney+", "HBO Max", "Hulu", "Netflix", "Paramount+", "Peacock"};
    String genres[] = { "Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery",
            "Romance", "Thriller"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        ssView = findViewById(R.id.streamListView);
        gView= findViewById(R.id.genreListView);
        resultsButton = findViewById(R.id.button);

        ssView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, streamServices));
        gView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,genres));

        ssView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        gView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultsIntent = new Intent(SuggestionsActivity.this, ResultsActivity.class);
                startActivity(resultsIntent);
            }
        });
    }
}