package com.cars.mvpsenon.prestener;


import com.cars.mvpsenon.api.Api;
import com.cars.mvpsenon.contract.SecondContract;
import com.cars.mvpsenon.data.City;
import com.cars.mvpsenon.mvprr.progress.ObserverOnNextListener;


public class SecondPresenter extends SecondContract.Presneter {

    public SecondPresenter(SecondContract.View view) {
        super(view);
    }

    @Override
    public void getCity(String city) {
        mModel.Subscribe(mContext, Api.getApiService().getCity(city), new ObserverOnNextListener<City>() {
            @Override
            public void onNext(City city) {
                getView().result(city);
            }
        });
    }
}
