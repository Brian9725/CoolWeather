package com.coolweather.android.dao;

import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.CoolWeatherApplication;

public class DBUtil {

    private static DataBaseHelper dataBaseHelper =
            new DataBaseHelper(CoolWeatherApplication.getContext(), "WeatherDB", null, 1);

    public static SQLiteDatabase getWritableDatabase() {
        return dataBaseHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getReadableDatabase() {
        return dataBaseHelper.getReadableDatabase();
    }

}
