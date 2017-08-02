package com.myhuanghai.mvpdemo.module_home.model;

import com.myhuanghai.mvpdemo.api.ApiEngine;
import com.myhuanghai.mvpdemo.module_home.bean.MyListBean;
import com.myhuanghai.mvpdemo.module_home.contract.MainContract;
import com.myhuanghai.mvpdemo.rx.RxSchedulers;
import rx.Observable;

/**
 * Model处理数据
 *      Model分出来，而不在Presenter处理，
 *      其实也是为了简洁，当你要处理很多数据的时候，Presenter就会变得很乱了。
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<MyListBean> getData() {
        return ApiEngine.getInstance().getApiService()
                .getGank("1")
                .compose(RxSchedulers.<MyListBean>switchThread());
    }
}
