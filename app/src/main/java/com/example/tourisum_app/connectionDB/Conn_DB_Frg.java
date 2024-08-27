package com.example.tourisum_app.connectionDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Conn_DB_Frg extends SQLiteOpenHelper {
    public Context context;
    public static String database_name="BookPlan1.db";
    public static final int database_version=1;
    public static final String table_name="BookPlan";
    public static final String col1="name";
    public static final String col2= "phoneNr";
    public static final String col3="place";
    private static final String COLUMN_ID = "id";
    public static final String col4="date";
    public static final String col5="utr_nr";

    public Conn_DB_Frg(@Nullable Context context) {
        super(context, database_name, null, database_version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+table_name+ "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col1+" TEXT, "+
                col2+" TEXT, "+
                col3+" TEXT,"+
                col4+" TEXT,"+
                col5+" TEXT );";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    //add bookplan data
    public void add(String name,String phoneNr,String place,String date,String utr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, name);
        cv.put(col2, phoneNr);
        cv.put(col3, place);
        cv.put(col4, date);
        cv.put(col5,utr);
        long result = db.insert(table_name, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to book.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Booked succsefully.", Toast.LENGTH_LONG).show();

        }

    }



 }

