package com.cars.mvpsenon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cars.mvpsenon.buildermode.MyBuilder;
import com.socks.library.KLog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * 用户登录界面
 */
public class MyLoginActivity extends AppCompatActivity {

    private static String TAG = "msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login_button)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
//                init();
//                bug();
                MyBuilder myBuilder = new  MyBuilder.Builder()
                        .setAge(22)
                        .setName("xiaohu")
                        .setHeight(174)
                        .setWeight(120)
                        .setSex("男")
                        .builder();
                KLog.e(myBuilder.toString());
                MyBuilder builder = new  MyBuilder.Builder()
                        .setName("dajiuzi")
                        .setSex("男")
                        .builder();
                KLog.e(builder.toString());
                break;

        }
    }

    public String bug() {
//      这段代码会报空指针异常
        String str = null;
//        Log.e("BugClass", "get string length:" + str.length());
        return "真棒！！！\n" +
                "bug被修复了";
    }

    private void init() {
        final ArrayList<String> list = new ArrayList<>();
        list.add("Hello World\n");
        list.add("第二条数据\n");
        list.add("第三条数据\n");

        Flowable<Integer> stream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "emit 1");
                emitter.onNext(1);
                Log.e(TAG, "emit 2");
                emitter.onNext(2);
                Log.e(TAG, "emit 3");
                emitter.onNext(3);
                Log.e(TAG, "emit complete");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR);
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG, "onSubscribe");
//                s.request(Long.MAX_VALUE);  //注意这句代码
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError: ", t);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
                Toast.makeText(MyLoginActivity.this, "真棒！！！\n更新成功了", Toast.LENGTH_SHORT).show();
            }
        };

        stream.subscribe(subscriber);
    }


}
