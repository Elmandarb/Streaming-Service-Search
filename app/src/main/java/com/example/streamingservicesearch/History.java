package com.example.streamingservicesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class History extends AppCompatActivity {

    private Button watchlistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        watchlistButton = findViewById(R.id.watch_list);
        watchlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent watchIntent = new Intent(History.this, Watchlist.class);
                startActivity(watchIntent);
            }
        });
    }
}