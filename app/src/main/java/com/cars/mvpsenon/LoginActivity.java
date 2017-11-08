package com.cars.mvpsenon;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cars.mvpsenon.contract.LoginContract;
import com.cars.mvpsenon.data.Login;
import com.cars.mvpsenon.mvprr.base.BaseActivity;
import com.cars.mvpsenon.prestener.LoginPresenter;
import java.util.HashMap;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_tv)
    TextView loginTv;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }

    @Override
    public void result(Login data) {

        loginTv.setText(loginTv.getText().toString()+data.getCode()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getMsg()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getFullName()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getOrgId()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getSex()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getTele()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getUserId()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getUserName()+"\n");
        loginTv.setText(loginTv.getText().toString()+data.getData().getUserType()+"\n");

    }



    @OnClick({R.id.login_tv, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_tv:

                break;
            case R.id.login_btn:
                HashMap<String,String> map = new HashMap<>();
                map.put("userName","admin");
                map.put("pwd","123");
                mPresenter.login(map);
                break;
        }
    }
}
