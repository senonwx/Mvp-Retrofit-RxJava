package com.cars.mvpsenon.contract;

import com.cars.mvpsenon.data.Login;
import com.cars.mvpsenon.mvprr.base.BasePresenter;
import com.cars.mvpsenon.mvprr.base.BaseView;
import java.util.HashMap;

/**
 * Created by senon on 2017/10/19.
 */

public interface LoginContract {

    interface View extends BaseView {

        void result(Login data);

    }

    abstract class Presenter extends BasePresenter<View> {

        public Presenter(View view) {
            super(view);
        }

        public abstract void login(HashMap<String,String> login);
    }
}
