package com.cars.mvpsenon;

import android.util.Log;
import android.widget.TextView;
import com.cars.mvpsenon.contract.LoginContract;
import com.cars.mvpsenon.data.Login;
import com.cars.mvpsenon.mvprr.base.BaseFragment;
import com.cars.mvpsenon.prestener.LoginPresenter;
import java.util.HashMap;
import butterknife.BindView;

public class AFragment extends BaseFragment<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.af_tv)
    TextView af_tv;

    @Override
    public void result(Login data) {
        af_tv.setText(af_tv.getText().toString()+data.getCode()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getMsg()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getFullName()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getOrgId()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getSex()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getTele()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getUserId()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getUserName()+"\n");
        af_tv.setText(af_tv.getText().toString()+data.getData().getUserType()+"\n");
    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_afragment;
    }

    @Override
    public void init() {
        HashMap<String,String> map = new HashMap<>();
        map.put("userName","admin");
        map.put("pwd","123");
        mPresenter.login(map);
        af_tv.setText(getArguments().getInt("code")+"");
        Log.e("MMMM      ",getArguments().getInt("code")+"");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
