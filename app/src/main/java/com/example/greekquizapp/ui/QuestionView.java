package com.example.greekquizapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.greekquizapp.R;
import com.example.greekquizapp.dbcontrol.DbHelper;
import com.example.greekquizapp.dbcontrol.DictEntry;
import com.example.greekquizapp.questionfactory.Question;
import com.example.greekquizapp.questionfactory.QuestionMaker;

import java.util.ArrayList;

public class QuestionView extends Activity {
    private  DictEntry []  entries;
    private DbHelper db;
    private boolean source;
    private final int questionPool = 20;
    private boolean answerChosen;
    private int correct, wrong;
    private ArrayList<Button> buttons;
    private String lastAnswer, correctAnswer;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        lastAnswer = "";
        answerChosen = false;
        correct = 0;  wrong = 0;
        buttons = new ArrayList<>();

        name = getIntent().getStringExtra("name");

        entries = (DictEntry[]) getIntent().getSerializableExtra("entries");
        source = getIntent().getBooleanExtra("source",true);
        db = new DbHelper(this);
        db.fillDbFromArray(entries);
        super.onCreate(savedInstanceState);
        final int[] questionNumber = {1};
        final QuestionMaker questionMaker = new QuestionMaker(db,entries,source);

        setContentView(R.layout.question);
        final TextView question = findViewById(R.id.question);

        final Button option1 = findViewById(R.id.option1);
        final Button option2 = findViewById(R.id.option2);
        final Button option3 = findViewById(R.id.option3);
        final Button option4 = findViewById(R.id.option4);
        Button next = findViewById(R.id.next);

        buttons.add(option1);
        buttons.add(option2);
        buttons.add(option3);
        buttons.add(option4);


        Question q = questionMaker.createQuestion(0);
        correctAnswer = q.getAnswer();
        final ArrayList<String> answers = q.getOptions();
        question.setText(q.getQuestion());
        option1.setText(answers.get(0));
        option2.setText(answers.get(1));
        option3.setText(answers.get(2));
        option4.setText(answers.get(3));

        for(int i = 0; i < 4; i++)
        {
            final Button b = buttons.get(i);
            final int tempI = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    chooseOption(tempI);

                }
            });
        }



        final Intent score = new Intent(this,ScoreView.class);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerChosen) {
                    answerChosen = false;

                    if(lastAnswer == correctAnswer) correct++;
                    else wrong++;

                    if (questionNumber[0] >= questionPool ) {
                        score.putExtra("correct",correct);
                        score.putExtra("wrong",wrong);
                        score.putExtra("entries", entries);

                        score.putExtra("name",name);

                        startActivity(score);


                    }
                    else {
                        for (Button b : buttons) {
                            b.setBackgroundResource(android.R.drawable.btn_default);
                            b.setTextColor(Color.BLACK);
                        }

                        Question q = questionMaker.createQuestion(questionNumber[0]);
                        correctAnswer = q.getAnswer();
                        ArrayList<String> options = q.getOptions();
                        question.setText(q.getQuestion());

                        for (int i = 0; i < 4; i++)
                            buttons.get(i).setText(options.get(i));

                        questionNumber[0]++;
                    }
                }
            }
        });
    }
    private void chooseOption(int number)
    {
        answerChosen = true;
        for(int i = 0; i < 4; i++)
        {
            Button b = buttons.get(i);
            if(i == number)
            {
                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);
                lastAnswer = b.getText().toString();
            }
            else{
                b.setBackgroundResource(android.R.drawable.btn_default);
                b.setTextColor(Color.BLACK);
            }
        }
    }
}
