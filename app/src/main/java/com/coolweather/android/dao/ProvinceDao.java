package com.coolweather.android.dao;

import com.coolweather.android.domain.Province;

import java.util.List;

public interface ProvinceDao {

    void insertProvince(Province province);

    List<Province> selectAllProvinces();

}
