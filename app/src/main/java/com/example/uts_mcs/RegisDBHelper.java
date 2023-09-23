package com.example.uts_mcs;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RegisDBHelper extends SQLiteOpenHelper {

    public static final String dbName = "Regis.db";

    public RegisDBHelper(@Nullable Context context) {
        super(context, "Regis.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase RegisterDatabase) {
        RegisterDatabase.execSQL("CREATE TABLE userdata(name_user VARCHAR(20), email_user VARCHAR(50) PRIMARY KEY, password_user VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase RegisterDatabase, int oldVersion, int newVersion) {
        RegisterDatabase.execSQL("DROP TABLE IF EXISTS userdata");
    }

    public Boolean insertData(String name, String email, String password) {
        SQLiteDatabase RegisterDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_user", name);
        contentValues.put("email_user", email);
        contentValues.put("password_user", password);
        long result = RegisterDatabase.insert("userdata", null, contentValues);

        if (result == -1) return false;
        else return true;
    }

    public Boolean emailCheck(String email) {
        SQLiteDatabase RegisterDatabase = this.getWritableDatabase();
        Cursor cursor = RegisterDatabase.rawQuery("SELECT * FROM userdata WHERE email_user = ?", new String[] {email});

        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Boolean userDataCheck(String email, String password) {
        SQLiteDatabase RegisterDatabase = this.getWritableDatabase();
        Cursor cursor = RegisterDatabase.rawQuery("SELECT * FROM userdata WHERE email_user = ? AND password_user = ?", new String[] {email, password});

        if (cursor.getCount() > 0) return true;
        else return false;
    }
}
