package com.cars.mvpsenon.contract;


import com.cars.mvpsenon.mvprr.base.BasePresenter;
import com.cars.mvpsenon.mvprr.base.BaseView;

public interface MainContract {

    interface View extends BaseView {
        void result(String s);
    }

    abstract class Presenter extends BasePresenter<View> {
        public Presenter(View view) {
            super(view);
        }
        public abstract void getLocation(String city);
    }
}
