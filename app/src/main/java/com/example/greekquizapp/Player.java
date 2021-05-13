package com.example.greekquizapp;

public class Player {
    private String name;
    private int points;

    public Player(String name){
        this.name=name;
        points=0;
    }

    public void setPoints(int points){
        this.points=points;
    }

    public int getPoints(){
        return points;
    }

    public String getName(){
        return name;
    }

}
