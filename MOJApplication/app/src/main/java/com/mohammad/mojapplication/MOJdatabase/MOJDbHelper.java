package com.mohammad.mojapplication.MOJdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mohammad.mojapplication.MOJdatabase.MOJDbSchema.EmiratesIDTable;
import com.mohammad.mojapplication.MOJdatabase.MOJDbSchema.UserTable;
import com.mohammad.mojapplication.MOJdatabase.MOJDbSchema.UserTable.Cols;


/**
 * Created by user on 10/28/2015.
 */
public class MOJDbHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "moj.db";

    public MOJDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ UserTable.NAME+"(_id integer primary key autoincrement,"+
                Cols.ID+ ","  +
                Cols.NAME + ","+
                Cols.MOBILE+","+
                Cols.ADDRESS + ","+
                Cols.USER_NAME+","+
                Cols.PASS +")");

        db.execSQL("create table "+ EmiratesIDTable.NAME+"(_id integer primary key autoincrement,"+
                EmiratesIDTable.Cols.ID+ ","  +
                EmiratesIDTable.Cols.NAME + ","+
                EmiratesIDTable.Cols.MOBILE+","+
                EmiratesIDTable.Cols.ADDRESS + ","+
                EmiratesIDTable.Cols.DOB +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
