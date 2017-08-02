package com.myhuanghai.mvpdemo.api;

import com.myhuanghai.mvpdemo.module_home.bean.MyListBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 *  Retrofit引擎封装
 *      用了单例模式，在构造方法中只初始化一次Retrofit和Okhttp。
 *      双重锁的方式获取单例，然后再根据需要获取ApiService，
 *      如果你有很多个不同源的API，那就可以创建多个getXXXXApiService。
 */
public interface ApiService {

    String BASE_URL="http://www.myhuanghai.com/tp5/public/index.php/";

    @GET("unity")
    Observable<MyListBean> getGank(@Path("page") String page);

}
