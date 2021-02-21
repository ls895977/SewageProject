package com.sewageproject.ui.presenter;
import com.sewageproject.base.BasePresenter;
import com.sewageproject.ui.constant.LoginContract;
import com.sewageproject.ui.model.LoginModel;
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginModel model;
    public LoginPresenter(){
        model=new LoginModel();
    }
    /**
     * 账号密码登录
     * @param username
     * @param password
     */
    @Override
    public void sysLogin(String username, String password) {

    }
}
