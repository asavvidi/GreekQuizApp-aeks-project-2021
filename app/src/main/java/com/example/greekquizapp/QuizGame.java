package com.example.greekquizapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class QuizGame extends AppCompatActivity {
    ArrayList<Question>questions;
    private int numOfQuestions=15;

    Question q1=new Question("What is the correct translation for telephone?","τηλέφωνο","ποδήλατο","ομπρέλα","νερό");
    Question q2=new Question("How do you say 'Good Morning?' ","Καλημέρα","Καλό Απόγευμα","Αντίο","Καλησπέρα");
    Question q3=new Question("How do you say 'Good Afternoon?' ","καλησπέρα","καλημέρα","Αντίο","Καλό Απόγευμα");
    Question q4=new Question("How do you say 'Good evening?' ","καλησπέρα","ευχαριστώ","παρακαλώ","κλειδιά");
    Question q5=new Question("What is the correct translation for 'Please'? ","Παρακαλώ","συγνώμη","γεια","αριστερά");
    Question q6=new Question("What is the correct translation for 'Thank you very much'? ","Ευχαριστώ πολύ","συγνώμη","Στην υγειά μας","Δεν ξέρω");
    Question q7=new Question("How do you say 'Sorry' ?","Συγνώμη","παρακαλώ","Δεν ξέρω","ευχαριστώ");
    Question q8=new Question("Ho do you say 'Hello'? ","γεια","ευχαριστώ","παρακαλώ","αμάξι");
    Question q9=new Question("How do you say 'Good Bye'? ","Αντίο","καλησπέρα","αριστερά","κλειδιά");
    Question q10=new Question("What is the correct translation for 'right'? ","δεξιά","αριστερά","τρία","τρένο");
    Question q11=new Question("How do you say 'water'? ","νερό","μπωλ","γάλα","πιάτο");
    Question q12=new Question("What is the correct translation for 'hospital'? ","νοσοκομείο","σπίτι","νερό","ασπιρίνη");
    Question q13=new Question("How do you say 'taxi'? ","ταξί","κρεβάτι","αυτοκίνητο","νοσοκομείο");
    Question q14=new Question("What is the correct translation for 'credit card'? ","πιστωτική κάρτα","φάκελος","βιβλίο","εφημερίδα");
    Question q15=new Question("How do you say 'car'? ","αυτοκινητό","τρένο","μαχαίρι","πλοίο");
   /* Question q16=new Question();
    Question q17=new Question();
    Question q18=new Question();
    Question q19=new Question();
    Question q20=new Question();*/

    Button optionA, optionB, optionC, optionD;
    TextView questionNumber, theQuestion;
    Question randomQuestion;
    Random rand=new Random();
    int randomNumber;
    CountDownTimer countDownTimer;
    int time=20;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        
        optionA=findViewById(R.id.buttonAnswer1);
        optionB=findViewById(R.id.buttonAnswer2);
        optionC=findViewById(R.id.buttonAnswer3);
        optionD=findViewById(R.id.buttonAnswer4);

        questionNumber=findViewById(R.id.questionNumberView);
        theQuestion=findViewById(R.id.questionView);

       /* Collections.shuffle(questions);
        randomNumber=rand.nextInt(questions.size());
        randomQuestion=questions.get(randomNumber);
        questions.remove(randomQuestion);

        optionA.setClickable(false);
        optionB.setClickable(false);
        optionC.setClickable(false);
        optionD.setClickable(false);
        */













    }
}
