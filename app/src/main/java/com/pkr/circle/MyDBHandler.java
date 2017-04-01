package com.pkr.circle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhilashagupta on 22/03/17.
 */

public class MyDBHandler {

    MyHelper myhelper;
    SQLiteDatabase sqliteDB;

    public MyDBHandler(Context context){
        myhelper = new MyHelper(context, "nerNew", null, 1);
    }

    public void open(){
        sqliteDB = myhelper.getWritableDatabase();
    }

    public void insertData(String state,String place,String spot, int rating, String reviews, String description,String activity,String latitude,String longitude){
        ContentValues cv = new ContentValues();
        cv.put("state",state);
        cv.put("place",place);
        cv.put("spot",spot);
        cv.put("rating",rating);
        cv.put("reviews",reviews);
        cv.put("description",description);
        cv.put("activity",activity);
        sqliteDB.insert("nerNew", null, cv);

        try
        {
            sqliteDB.insert("nerNew", null, cv);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Cursor queryName(){
        Cursor c = null;

        c = sqliteDB.query("nerNew", null, null, null, null, null, null, null);
        return c;

    }

    public void deleteData(){
        sqliteDB.delete("nerNew", null, null);
        //sqliteDB.execSQL();
    }



    public void close(){
        sqliteDB.close();
    }

    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table nerNew(_id integer primary key,state text,place text,spot text,rating integer,reviews text,description text,activity text,latitude text, longitude text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
