package com.myhuanghai.mvpdemo.module_home.ui;

import android.os.Bundle;
import android.util.Log;

import com.myhuanghai.mvpdemo.R;
import com.myhuanghai.mvpdemo.base.BaseActivity;
import com.myhuanghai.mvpdemo.module_home.bean.MyListBean;
import com.myhuanghai.mvpdemo.module_home.contract.MainContract;
import com.myhuanghai.mvpdemo.module_home.presenter.MainPresenter;

/**
 * 欢迎页
 * */
public class HelloActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }


    @Override
    public void showDialog() {
        Log.i("huanghai","showDialog");
    }

    @Override
    public void onSucceed(MyListBean data) {
        Log.i("huanghai",data.toString());
    }

    @Override
    public void onFail(String err) {
        Log.i("huanghai","onFail-->"+err);

    }

    @Override
    public void hideDialog() {
        Log.i("huanghai","hideDialog");
    }
}
