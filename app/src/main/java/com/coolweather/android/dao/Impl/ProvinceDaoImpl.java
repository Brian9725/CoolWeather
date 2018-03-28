package com.coolweather.android.dao.Impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.android.dao.DBUtil;
import com.coolweather.android.dao.ProvinceDao;
import com.coolweather.android.domain.Province;

import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    private static final String INSERT_PROVINCE = "INSERT INTO Province (provinceName, provinceCode) VALUES (?, ?)";

    private static final String SELECT_ALL_PROVINCE = "SELECT * FROM Province";

    @Override
    public void insertProvince(Province province) {
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        sqLiteDatabase.execSQL(INSERT_PROVINCE,
                new String[] {province.getProvinceName(), String.valueOf(province.getProvinceCode())});
    }

    @Override
    public List<Province> selectAllProvinces() {
        List<Province> allProvinces = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DBUtil.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_PROVINCE, null);
        try {
            if(cursor != null) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String provinceName = cursor.getString(cursor.getColumnIndex("provinceName"));
                    int provinceCode = cursor.getInt(cursor.getColumnIndex("provinceCode"));
                    Province province = new Province(id, provinceName, provinceCode);
                    allProvinces.add(province);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return allProvinces;
    }
}
