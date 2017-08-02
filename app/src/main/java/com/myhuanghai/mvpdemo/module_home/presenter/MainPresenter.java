package com.myhuanghai.mvpdemo.module_home.presenter;

import com.myhuanghai.mvpdemo.module_home.bean.MyListBean;
import com.myhuanghai.mvpdemo.module_home.contract.MainContract;
import com.myhuanghai.mvpdemo.module_home.model.MainModel;
import rx.Subscriber;
import rx.Subscription;

/**
 * Presnter桥梁
 *      连接Model和View的桥梁
 */
public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

    @Override
    public void getGank() {

        Subscription subscribe = mModel.getData()
                .subscribe(new Subscriber<MyListBean>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(MyListBean data) {
                        mView.onSucceed(data);
                    }
                });


        addSubscribe(subscribe);
    }
}
