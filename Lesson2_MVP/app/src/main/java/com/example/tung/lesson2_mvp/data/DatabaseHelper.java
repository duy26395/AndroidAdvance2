package com.example.tung.lesson2_mvp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tung on 5/19/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db;
    public Cursor cursor;

    static final String DATABASE_NAME = "college";
    static final String TABLE_NAME = "student";
    static final int DATABASE_VERSION = 1;

    static final String CREATE_DB_QUERY =
            " CREATE TABLE " + TABLE_NAME +
                    " (" + Student.COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + Student.COLUMN_NAME + " TEXT NOT NULL, "
                    + Student.COLUMN_PHONE + " TEXT NOT NULL);";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
