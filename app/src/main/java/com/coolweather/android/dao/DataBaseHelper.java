package com.coolweather.android.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String CREATE_PROVINCE =
            "CREATE TABLE Province ( " +
                    "id integer PRIMARY KEY, " +
                    "provinceName text, " +
                    "provinceCode integer) ";

    private static final String DROP_PROVINCE = "DROP TABLE IF EXISTS Province";

    private static final String CREATE_CITY =
            "CREATE TABLE City ( " +
                    "id integer PRIMARY KEY, " +
                    "cityName text, " +
                    "cityCode integer, " +
                    "provinceCode integer)";

    private static final String DROP_CITY = "DROP TABLE IF EXISTS City";
    
    private static final String CREATE_COUNTRY =
            "CREATE TABLE Country ( " +
                    "id integer PRIMARY KEY, " +
                    "countryName text, " +
                    "weatherId text, " +
                    "cityId integer)";

    private static final String DROP_COUNTRY = "DROP TABLE IF EXISTS Country";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_PROVINCE);
        db.execSQL(DROP_CITY);
        db.execSQL(DROP_COUNTRY);
        onCreate(db);
    }

}
