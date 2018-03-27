package com.coolweather.android.dao.Impl;

import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.dao.ProvinceDao;
import com.coolweather.android.domain.Province;

public class ProvinceDaoImpl implements ProvinceDao {

    private static final String INSERT_PROVINCE = "INSERT INTO Province (provinceName, provinceCode) VALUES (?, ?)";

    @Override
    public void insertProvince(Province province) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_PROVINCE,
                new String[] {province.getProvinceName(), String.valueOf(province.getProvinceCode())});
    }

}
