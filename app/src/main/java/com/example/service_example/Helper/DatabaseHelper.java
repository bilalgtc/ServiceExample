package com.example.service_example.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String db_name="userdata_tb";

    public DatabaseHelper( Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table user_records(id integer primary key autoincrement, name TEXT,email TEXT, mobile TEXT, password TEXT )";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS user_records";
        db.execSQL(qry);
    }

    public boolean addRecord(String name, String email, String mobile, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("password", password);

        long id = db.insert(" user_records ", null, contentValues);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from user_records";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }
}
