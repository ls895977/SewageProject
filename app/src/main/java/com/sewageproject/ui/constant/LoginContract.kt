package com.sewageproject.ui.constant
import com.sewageproject.base.BaseView
interface LoginContract {
    interface View : BaseView
    interface Model {
        /**
         * 账号密码登录
         * @param username 用户名
         * @param password 密码
         */
        fun sysLogin(username: String, password: String)
    }

    interface Presenter {
        /**
         * 账号密码登录
         */
        fun sysLogin(username: String, password: String)
    }
}