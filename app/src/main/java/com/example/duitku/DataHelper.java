package com.example.duitku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "keuangan.db";
    private static final int DATABASE_VERSION = 1;


    public DataHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE uang(id INTEGER PRIMARY KEY AUTOINCREMENT, tanggal DATE, uang_makan INTEGER, uang_kebutuhan INTEGER, uang_urgent INTEGER, tabungan INTEGER, sisa INTEGER);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
