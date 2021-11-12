package com.example.streamingservicesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    public static final String SEARCH_KEY = "SEARCH";
    TextView searchResultsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent newIntent = getIntent();
        String name = newIntent.getStringExtra(ResultsActivity.SEARCH_KEY);
        searchResultsText = findViewById(R.id.search_results_text);
        searchResultsText.setText("You searched for " + name);

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