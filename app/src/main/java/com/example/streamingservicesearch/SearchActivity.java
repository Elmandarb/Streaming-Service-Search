package com.example.streamingservicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    EditText searchEditText;
    Button navigateButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = findViewById(R.id.search_edit_text);
        navigateButton = findViewById(R.id.navigate_button);
        backButton = findViewById(R.id.back_button);

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = searchEditText.getText().toString();
                Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
                intent.putExtra(ResultsActivity.SEARCH_KEY, name);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, Homepage.class);
                startActivity(intent);
            }
        });
    }
}
