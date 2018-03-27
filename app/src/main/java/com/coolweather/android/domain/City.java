package com.coolweather.android.domain;

public class City {

    private int id;

    private String cityName;

    private int cityCode;

    private int provinceCode;

    public City() {};

    public City(int id, String cityName, int cityCode, int provinceCode) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

}
