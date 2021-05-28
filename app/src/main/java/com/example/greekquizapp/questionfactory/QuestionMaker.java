package com.example.greekquizapp.questionfactory;
import android.content.Context;

import com.example.greekquizapp.dbcontrol.DbHelper;
import com.example.greekquizapp.dbcontrol.DictEntry;

import java.util.ArrayList;
import java.util.Random;

public class QuestionMaker {


    private DbHelper db;
    private DictEntry[] entries;
    private boolean source;

    public QuestionMaker(DbHelper db, DictEntry[] entries, boolean source) {
        this.db = db;
        this.entries = entries;
        this.source = source;

    }

    public Question createQuestion(int number) {
        DictEntry entry = entries[number];
        String column = source ? "target" : "source";
        ArrayList<String> options = new ArrayList<>();
        String question = entry.getSource();
        // the answer
        options.add(entry.getTarget());
        for (int i = 0; i < 3; i++) {
            String option = db.getRandomWord(column);
            while (options.contains(option))
                option = db.getRandomWord(column);
            options.add(option);

        }
        return new Question(question, options.get(0), options.get(1), options.get(2), options.get(3));


    }
}
