package com.example.greekquizapp;

import java.util.ArrayList;

public class Question {

    private String  question, correct, ans2, ans3, ans4, correctAnswer;
    private ArrayList<String>Answers=new ArrayList<>();

    Question(String q, String c, String a2, String a3, String a4){
        this.question=q;
        this.correct=c;
        this.ans2=a2;
        this.ans3=a3;
        this.ans4=a4;
        Answers.add(c);
        Answers.add(a2);
        Answers.add(a3);
        Answers.add(a4);

    }

    public String getQuestion(){
        return question;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public String getCorrect(){
        return correct;
    }

    public String getAns2(){
        return ans2;
    }
    public String getAns3(){
        return ans3;
    }
    public String getAns4(){
        return ans4;
    }

    public String printQuestion(){
        if(correct.equals(Answers.get(0))){
            correctAnswer="A";
        }
        if(correct.equals(Answers.get(1))){
            correctAnswer="B";
        }
        if(correct.equals(Answers.get(2))){
            correctAnswer="C";
        }
        if(correct.equals(Answers.get(3))){
            correctAnswer="D";
        }
        String st="A: "+ Answers.get(0) +"B: "+ Answers.get(1)+ "C: "+ Answers.get(2)+ "D: "+ Answers.get(2);
        return st;
    }

}
