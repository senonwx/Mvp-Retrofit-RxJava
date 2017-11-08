package com.cars.mvpsenon.mvprr.progress;

/**
 * 请求成功监听
 */

public interface ObserverOnNextListener<T> {
    void onNext(T t);
}
