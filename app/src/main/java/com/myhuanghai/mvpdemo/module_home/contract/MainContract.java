package com.myhuanghai.mvpdemo.module_home.contract;

import com.myhuanghai.mvpdemo.base.BaseModel;
import com.myhuanghai.mvpdemo.base.BasePresenter;
import com.myhuanghai.mvpdemo.base.BaseView;
import com.myhuanghai.mvpdemo.module_home.bean.MyListBean;

import rx.Observable;

/**
 * 契约类
 */
public interface MainContract {

    interface View extends BaseView {

        void showDialog();

        void onSucceed(MyListBean data);

        void onFail(String err);

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<MyListBean> getData();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGank();
    }
}
