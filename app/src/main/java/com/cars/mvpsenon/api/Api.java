package com.cars.mvpsenon.api;


import com.cars.mvpsenon.mvprr.base.BaseApi;

/**
 *
 */

public class Api {

//    private String baseUrl = "http://gc.ditu.aliyun.com/";//阿里云根据地区名获取经纬度接口
    private String baseUrl = "http://192.168.0.160:8080/CarMon/service/";

    private volatile static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        BaseApi baseApi = new BaseApi();
        apiService = baseApi.getRetrofit(baseUrl).create(ApiService.class);
    }
}
