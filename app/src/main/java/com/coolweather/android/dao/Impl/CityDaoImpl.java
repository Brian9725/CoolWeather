package com.coolweather.android.dao.Impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.CityDao;
import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.domain.City;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {

    private static final String INSERT_CITY = "INSERT INTO City (cityName, cityCode, provinceId) VALUES (?, ?, ?)";

    private static final String SELECT_CITIES_BY_PROVINCE_ID = "SELECT * FROM City WHERE provinceId = ?";

    @Override
    public void insertCity(City city) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_CITY,
                new String[] {city.getCityName(), String.valueOf(city.getCityCode()), String.valueOf(city.getProvinceId())});
    }

    @Override
    public List<City> selectAllCitiesByProvinceId(int vProvinceId) {
        List<City> allCities = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_CITIES_BY_PROVINCE_ID,
                new String[] {String.valueOf(vProvinceId)});
        try {
            if(cursor != null) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String cityName = cursor.getString(cursor.getColumnIndex("cityName"));
                    int cityCode = cursor.getInt(cursor.getColumnIndex("cityCode"));
                    int provinceId = cursor.getInt(cursor.getColumnIndex("provinceId"));
                    City city = new City(id, cityName, cityCode, provinceId);
                    allCities.add(city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return allCities;
    }
}
