package com.example.greekquizapp.dbcontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private final String fileName = "wordList.txt";
    private Context context;
    private final String tableName = "words";
    public DbHelper(Context context) {
        super(context, "words", null,1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, source TEXT, target TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void fillDbFromFile()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        BufferedReader reader;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!= null)
            {

                line = reader.readLine();
                if(line!=null) {
                    if(line.length() <= 1)
                        continue;
                    ContentValues values = new ContentValues();
                    String[] columns = line.split(" ", 2);
                    String s = columns[0];
                    String t = columns[1];
                    values.put("source", columns[0]);
                    values.put("target", columns[1]);
                    db.insert(tableName, null, values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fillDbFromArray(DictEntry [] entries)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        for(DictEntry e : entries) {
            ContentValues values = new ContentValues();
            values.put("source",e.getSource());
            values.put("target",e.getTarget());

            db.insert(tableName, null,values);
        }
    }
    // source == true for source -> target
    //          false  for target -> source
    public  DictEntry []  getWordList(int size, boolean source)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        DictEntry [] entries = new DictEntry[size];
        ArrayList<String> words = new ArrayList<>();
        String [] projection = {
                "id",
                "source",
                "target"
        };

        Cursor cursor;
        int i = 0;

        cursor = db.query(tableName, projection,null,null,null,null, "RANDOM()");
        while(i < size)
        {
            cursor.moveToNext();
            while(words.contains(cursor.getString(cursor.getColumnIndex("source"))))
                cursor.moveToNext();
            int sourceIndex = cursor.getColumnIndex("source");
            int targetIndex = cursor.getColumnIndex("target");
            DictEntry entry = source ? new DictEntry(cursor.getInt(0), cursor.getString(sourceIndex), cursor.getString(targetIndex)) :
                    new DictEntry(cursor.getInt(0), cursor.getString(targetIndex), cursor.getString(sourceIndex));

            entries[i] = entry;
            words.add(entry.getSource());
            i++;

        }

        return entries  ;
    }
    public String getRandomWord(String column)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select " + column +" from "+ tableName+ " order by random() limit 1 ",null);
        c.moveToFirst();

        return  c.getString(0);

    }
}
