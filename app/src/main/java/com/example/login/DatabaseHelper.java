package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Student.db";
    public static final String TABLE_NAME ="Student";
    public static final String COL_1 ="id";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE  TABLE " + TABLE_NAME + "( id  INTEGER  PRIMARY KEY  AUTOINCREMENT, username TEXT , password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP  TABLE IF EXISTS " + TABLE_NAME );

    }
    public boolean insertdata(String username,String password ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,username);
        contentValues.put(COL_3,password);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result== -1)
            return  false;
        else
            return  true;
    }
    public Cursor getRegister(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select*from "+TABLE_NAME,null);
        return cursor;
    }
}
