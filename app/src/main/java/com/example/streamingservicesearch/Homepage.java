package com.example.streamingservicesearch;

import androidx.appcompat.app.AppCompatActivity;
/*
import android.content.Intent;
import android.view.View;
import android.widget.Button; */
import android.os.Bundle;


public class Homepage extends AppCompatActivity {
   /*
    private Button randomButton;
    private Button searchButton;
    private Button suggestionButton;
    private Button historyButton; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Button movement functionality
       /*
        randomButton = findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ranIntent = new Intent(Homepage.this, random.class);
                startActivity(ranIntent);
            }
        });
        searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(Homepage.this, search.class);
                startActivity(searchIntent);
            }
        });
        suggestionButton = findViewById(R.id.suggestion_button);
        suggestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sugIntent = new Intent(Homepage.this, suggestion.class);
                startActivity(sugIntent);
            }
        });
        historyButton = findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(Homepage.this, history.class);
                startActivity(historyIntent);
            }
        }); */
    }
}