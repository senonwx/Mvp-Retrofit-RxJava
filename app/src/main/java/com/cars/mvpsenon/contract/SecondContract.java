package com.cars.mvpsenon.contract;


import com.cars.mvpsenon.data.City;
import com.cars.mvpsenon.mvprr.base.BasePresenter;
import com.cars.mvpsenon.mvprr.base.BaseView;

public interface SecondContract {
    interface View extends BaseView {
        void result(City city);
    }

    abstract class Presneter extends BasePresenter<View> {

        public Presneter(View view) {
            super(view);
        }

        public abstract void getCity(String city);
    }
}
