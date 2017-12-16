package com.example.minan.asign;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "events.db";

    public static final String TABLE_EVENTS = "events";

    public static final String COLUMN_ID = "_id";
    public static final String COULMN_WORKNAME = "workname";
    public static final String COULMN_COURSE = "course";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_EVENTS + "("
                                       + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                                       + COULMN_WORKNAME + " TEXT "
                                       + COULMN_COURSE + " TEXT "
                                       + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "DROP TABLE IF EXISTS";

        db.execSQL(s + TABLE_EVENTS);

        onCreate(db);
    }

    //Add a new row to the database
    public void addEvent(Events events){
        ContentValues values = new ContentValues();
        values.put(COULMN_WORKNAME, events.get_workname());
        values.put(COULMN_COURSE, events.get_course());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EVENTS,null,values);
        db.close();
    }

    public void retrieveEvents(ArrayList<String> workList, ArrayList<String> courseList){
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_EVENTS;

        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString((c.getColumnIndex("workname")))!= null){
                workList.add(c.getString(c.getColumnIndex("workname")));
                courseList.add(c.getString(c.getColumnIndex("course")));
            }
        }

        db.close();
    }

    //Delete event from the database
    public void deleteEvent(String workName){
        SQLiteDatabase db = getWritableDatabase();

        String s = "DELETE FROM " + TABLE_EVENTS + " WHERE " + COULMN_WORKNAME + "=\"" + workName + "\";";

        db.execSQL(s);
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EVENTS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();


        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("workname")) != null){
                dbString += c.getString(c.getColumnIndex("workname"));
                dbString += "\n";
            }
        }
        db.close();;
        return dbString;
    }
}
