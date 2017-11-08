package com.cars.mvpsenon.mvprr.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Fragment父类
 * @param <T>
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    public T mPresenter;
    public Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mContext =  getActivity();
        ButterKnife.bind(this,view);
        initPresenter();
        if (mPresenter != null) {
            mPresenter.mContext = mContext;
        }
        init();
        return view;
    }

    public abstract void initPresenter();

    public abstract int getLayoutId();

    public abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

}
