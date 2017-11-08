package com.cars.mvpsenon.prestener;


import com.cars.mvpsenon.api.Api;
import com.cars.mvpsenon.contract.LoginContract;
import com.cars.mvpsenon.data.Login;
import com.cars.mvpsenon.mvprr.progress.ObserverOnNextListener;
import java.util.HashMap;

/**
 * Created by senon on 2017/10/19.
 */

public class LoginPresenter extends LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login(HashMap<String, String> login) {
        mModel.Subscribe(mContext, Api.getApiService().login(login), new ObserverOnNextListener() {
            @Override
            public void onNext(Object o) {
                getView().result((Login) o);
            }
        });
    }
}
