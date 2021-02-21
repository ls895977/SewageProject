package com.sewageproject.ui.model;
import com.sewageproject.base.BaseModel;
import com.sewageproject.net.bean.BaseResponse;
import com.sewageproject.ui.constant.LoginContract;
import java.util.HashMap;
import java.util.Map;
public class LoginModel extends BaseModel implements LoginContract.Model {


    /**
     * 账号密码登录
     *
     * @param username 用户名
     * @param password 密码
     */
//    @Override
//    public HttpObservable<BaseResponse<String>> sysLogin(String username, String password) {
//        Map<String, String> map = new HashMap<>();
//        map.put("username", username);
//        map.put("password", password);
//        return HttpClient.getApi().sysLogin(parsJson(map));
//    }
}
