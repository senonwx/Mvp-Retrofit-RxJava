package com.cars.mvpsenon.mvprr.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Activity父类层
 * @param <T>
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T mPresenter;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initPresenter();
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        init();
    }

    public abstract void initPresenter();

    public abstract int getLayoutId();

    public abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
