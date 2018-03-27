package com.coolweather.android.dao.Impl;

import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.CountryDao;
import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.domain.Country;

public class CountryDaoImpl implements CountryDao {

    private static final String INSERT_COUNTRY = "INSERT INTO Country (countryName, weatherId, cityId) VALUES (?, ?, ?)";

    @Override
    public void insertCountry(Country country) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_COUNTRY,
                new String[] {country.getCountryName(), country.getWeatherId(), String.valueOf(country.getCityId())});
    }

}
