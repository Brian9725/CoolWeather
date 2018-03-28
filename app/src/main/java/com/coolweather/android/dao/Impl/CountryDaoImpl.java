package com.coolweather.android.dao.Impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.CountryDao;
import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.domain.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDao {

    private static final String INSERT_COUNTRY = "INSERT INTO Country (countryName, weatherId, cityId) VALUES (?, ?, ?)";

    private static final String SELECT_ALL_COUNTRIES_BY_CITY_ID = "SELECT * FROM Country WHERE cityId = ?";

    @Override
    public void insertCountry(Country country) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_COUNTRY,
                new String[] {country.getCountryName(), country.getWeatherId(), String.valueOf(country.getCityId())});
    }

    @Override
    public List<Country> selectAllCountriesByCityI(int vCityId) {
        List<Country> allCountries = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_COUNTRIES_BY_CITY_ID,
                new String[] {String.valueOf(vCityId)});
        try {
            if(cursor != null) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String countryName = cursor.getString(cursor.getColumnIndex("countryName"));
                    String weatherId = cursor.getString(cursor.getColumnIndex("weatherId"));
                    int cityId = cursor.getInt(cursor.getColumnIndex("cityId"));
                    Country country = new Country(id, countryName, weatherId, cityId);
                    allCountries.add(country);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return allCountries;
    }
}
