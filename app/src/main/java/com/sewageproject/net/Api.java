package com.sewageproject.net;
import com.sewageproject.net.bean.BaseResponse;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    /**
     * 账号密码登录
     */
    @POST("sys/login")
    Observable<BaseResponse> sysLogin(@Body RequestBody requestBody);
}

