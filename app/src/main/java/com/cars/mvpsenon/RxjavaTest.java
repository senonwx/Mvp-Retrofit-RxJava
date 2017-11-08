package com.cars.mvpsenon;


import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：senon on 2017/10/31 10:46
 * 邮箱：a1083911695@163.com
 */

public class RxjavaTest {

    public static void main(String[] args) {

        fun1();
    }

    private static void fun1(){
//        Observable<String> sender = Observable.fromArray("Hello World\n","第二条数据\n","第三条数据\n");
        final ArrayList<String> list = new ArrayList<>();
        list.add("Hello World\n");
        list.add("第二条数据\n");
        list.add("第三条数据\n");
        Observable<Object> sender = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onNext(list);
//                e.onError(new Exception("error\n"));
                System.out.print("发送线程"+Thread.currentThread().getName()+"\n");
                e.onComplete();
            }
        });
        sender.subscribeOn(Schedulers.newThread());
//        sender.observeOn(AndroidSchedulers.mainThread());
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                System.out.print("接收线程"+Thread.currentThread().getName()+"\n");
//                System.out.print(d.toString()+"\n");
//            }
//
//            @Override
//            public void onNext(@NonNull Object o) {
//                System.out.print(o.toString()+"\n");
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                System.out.print(e.toString());
//
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.print("onComplete"+"\n");
//            }
//        };
//        sender.subscribe(observer);
//        Observable.just(list).flatMap(new Function<ArrayList<String>, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(@NonNull ArrayList<String> list) throws Exception {
//                return null;
//            }
//        });
        Observable.just(list).flatMap(new Function<ArrayList<String>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(@NonNull ArrayList<String> list) throws Exception {
                return Observable.fromIterable(list);
            }
        })
                .filter(new Predicate<Object>() {

                    @Override
                    public boolean test(@NonNull Object o) throws Exception {
                        String s = (String) o;
                        if(s.equals("Hello World\n")){
                            return false;
                        }
                        return true;
                    }
                })
                .take(1)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println((String)o);
                    }
                });
    }

}
