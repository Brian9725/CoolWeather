package com.coolweather.android.dao;

import com.coolweather.android.domain.Country;

import java.util.List;

public interface CountryDao {

    void insertCountry(Country country);

    List<Country> selectAllCountriesByCityI(int vCityId);

}
