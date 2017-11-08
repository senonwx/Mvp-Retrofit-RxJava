package com.cars.mvpsenon.mvprr.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.tencent.bugly.beta.Beta;

/**
 *
 */

public class BaseApplication extends Application {

    private static Context mContext;//全局上下文对象

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        setStrictMode();
        // 设置是否开启热更新能力，默认为true
        Beta.enableHotfix = true;
        // 设置是否自动下载补丁
        Beta.canAutoDownloadPatch = true;
        // 设置是否提示用户重启
        Beta.canNotifyUserRestart = true;
        // 设置是否自动合成补丁
        Beta.canAutoPatch = true;
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        com.tencent.bugly.Bugly.init(this, "f0ab571284", true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        android.support.multidex.MultiDex.install(base);


        // 安装tinker
        com.tencent.bugly.beta.Beta.installTinker();
    }

    @TargetApi(9)
    protected void setStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
    }
    public static Context getContext() {
        return mContext;
    }

}
