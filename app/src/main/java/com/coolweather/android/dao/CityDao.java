package com.coolweather.android.dao;

import com.coolweather.android.domain.City;

import java.util.List;

public interface CityDao {

    void insertCity(City city);

    List<City> selectAllCitiesByProvinceId(int vProvinceId);

}
