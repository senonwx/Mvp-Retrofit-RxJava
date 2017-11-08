package com.cars.mvpsenon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;

    private List<Fragment> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        for (int i = 1; i <= 5; i++) {
            AFragment aFragment = new AFragment();
            Bundle args = new Bundle();
            args.putInt("code", i);
            aFragment.setArguments(args);
            mData.add(aFragment);
        }
        vp.setAdapter(new AFragmentAdapter(getSupportFragmentManager(), mData));
    }


}
