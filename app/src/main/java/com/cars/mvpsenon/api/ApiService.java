package com.cars.mvpsenon.api;


import com.cars.mvpsenon.data.City;
import com.cars.mvpsenon.data.Login;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiService {

    @GET("geocoding")
    Observable<String> getLocation(@Query("a") String a);//获取的请求结果为String

    @GET("geocoding")
    Observable<City> getCity(@Query("a") String a);//获取的请求结果为实体类型

    @POST("sys/login")
    Observable<Login> login(@QueryMap Map<String, String> map);// 登录的请求

}
