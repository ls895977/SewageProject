package com.sewageproject.ui.constant;

import com.sewageproject.base.BaseView;
import com.sewageproject.net.bean.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

public interface LoginContract {
    interface View extends BaseView {

    }
    interface Model{
        /**
         * 账号密码登录
         * @param username 用户名
         * @param password 密码
         */
//        DisposableObserver<BaseResponse> sysLogin(String username, String password);
    }

    interface Presenter {
        /**
         * 账号密码登录
         */
        void sysLogin(String username,String password);
    }
}
