package com.example.greekquizapp.questionfactory;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question, answer;
    private ArrayList<String> options;

    public Question(String q, String answer, String option1, String option2, String option3)
    {
        question = q;
        this.answer = answer;
        options = new ArrayList<>();
        options.add(answer);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        Collections.shuffle(options);

    }
    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
    public String getAnswer()
    {
        return answer;
    }

}