package com.example.greekquizapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greekquizapp.R;
import com.example.greekquizapp.dbcontrol.DbHelper;
import com.example.greekquizapp.dbcontrol.DictEntry;

public class MainActivity extends AppCompatActivity {
    private final int entryPool = 50;
    private  DictEntry []  entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1 = findViewById(R.id.gr);
        Button b2 = findViewById(R.id.en);
        final Intent intent = new Intent(this,QuestionView.class);
        final DbHelper db = new DbHelper(this);
        if(getIntent().getBooleanExtra("dbCreated",false))
        {
            entries =  (DictEntry[]) getIntent().getSerializableExtra("entries");
            db.fillDbFromArray(entries);
        }else {
            db.fillDbFromFile();
            entries = new DictEntry[entryPool];
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entries = db.getWordList(entryPool,true);
                intent.putExtra("source", true);
                intent.putExtra("entries",entries);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entries = db.getWordList(entryPool,false);
                intent.putExtra("source", false);
                intent.putExtra("entries",entries);
                startActivity(intent);
            }
        });


    }
}