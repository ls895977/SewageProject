package com.sewageproject.ui.presenter

import com.sewageproject.base.BasePresenter
import com.sewageproject.ui.constant.LoginContract
import com.sewageproject.ui.constant.LoginContract.Presenter
import com.sewageproject.ui.model.LoginModel

class LoginPresenter : BasePresenter<LoginContract.View?>(), Presenter {
    private val model: LoginModel = LoginModel()
    /**
     * 账号密码登录
     * @param username
     * @param password
     */
    override fun sysLogin(username: String, password: String) {
        model.sysLogin(username,password)
    }

}