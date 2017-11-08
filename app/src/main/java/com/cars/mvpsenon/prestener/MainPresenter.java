package com.cars.mvpsenon.prestener;


import com.cars.mvpsenon.api.Api;
import com.cars.mvpsenon.contract.MainContract;
import com.cars.mvpsenon.mvprr.progress.ObserverOnNextListener;


public class MainPresenter extends MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void getLocation(String city) {
        mModel.Subscribe(mContext, Api.getApiService().getLocation(city), new
                ObserverOnNextListener() {
            @Override
            public void onNext(Object o) {
                getView().result(o + "");
            }
        });
    }
}
