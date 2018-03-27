package com.coolweather.android.dao.Impl;

import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.CityDao;
import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.domain.City;

public class CityDaoImpl implements CityDao {

    private static final String INSERT_CITY = "INSERT INTO City (cityName, cityCode, provinceCode) VALUES (?, ?, ?";

    @Override
    public void insertCity(City city) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_CITY,
                new String[] {city.getCityName(), String.valueOf(city.getCityCode()), String.valueOf(city.getProvinceCode())});
    }

}
