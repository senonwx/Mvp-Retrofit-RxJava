package com.cars.mvpsenon.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DeMon on 2017/9/23.
 */

public class City {
    @SerializedName("lon")
    public double lon;
    @SerializedName("level")
    public int level;
    @SerializedName("address")
    public String address;
    @SerializedName("cityName")
    public String cityName;
    @SerializedName("alevel")
    public int alevel;
    @SerializedName("lat")
    public double lat;

    public double getLon() {
        return lon;
    }

    public int getLevel() {
        return level;
    }

    public String getAddress() {
        return address;
    }

    public String getCityName() {
        return cityName;
    }

    public int getAlevel() {
        return alevel;
    }

    public double getLat() {
        return lat;
    }
}
