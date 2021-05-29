package com.example.greekquizapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.greekquizapp.R;

public class ScoreView extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        final TextView correctText = (TextView) findViewById(R.id.correct);
        final TextView wrongText = (TextView) findViewById(R.id.wrong);
        Button mainMenu = findViewById(R.id.mainMenu);
        final Intent main = new Intent(this, MainActivity.class);
        int correct = getIntent().getIntExtra("correct",0);
        int wrong  = getIntent().getIntExtra("wrong",0);

        correctText.setText("Σωστά / True: " + Integer.toString(correct));
        wrongText.setText("Λάθος / False: " + Integer.toString(wrong));
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(main);
            }
        });

    }
}
