package com.cars.mvpsenon.mvprr.base;

import android.content.Context;

import com.cars.mvpsenon.mvprr.progress.ObserverOnNextListener;
import com.cars.mvpsenon.mvprr.progress.ProgressObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * M层父类
 */

public class BaseModel<T> {
    /**
     * 封装线程管理和订阅的过程
     */
    public void Subscribe(Context context, final Observable observable, ObserverOnNextListener<T> listener) {
        final Observer<T> observer = new ProgressObserver<T>(context, listener);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
