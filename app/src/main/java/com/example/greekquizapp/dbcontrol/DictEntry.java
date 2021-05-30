package com.example.greekquizapp.dbcontrol;

import android.os.Parcel;

import java.io.Serializable;

public class DictEntry implements Serializable {

    private String source, target;
    private int id;



    public DictEntry(int id, String source, String target)
    {
        this.source = source;
        this.target = target;
        this.id = id;

    }





    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }
    public int getId() {
        return id;
    }



}