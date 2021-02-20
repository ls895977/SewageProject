package com.sewageproject.base;

import android.util.Log;

import com.google.gson.Gson;
import com.sewageproject.net.Api;
import com.sewageproject.net.bean.BaseResponse;
import com.sewageproject.net.network.RetrofitFactory;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class BaseModel {

    Map<String, String> map = new HashMap<>();
    public Gson gson;
    public RequestBody parsJson(Map<String, String> map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }

    public RequestBody parsObjJson(Map<String, Object> map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }

    public RequestBody parsObjJson(@NotNull Object map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }
    /**
     * @1 获取HttpAPi对象(这里创建了Retrofit对象)
     */
    public Api getMyApi() {
        return RetrofitFactory.getInstance().getHttpApi();
    }
    /**
     * @param observable
     * @param subscriber
     * @2 发起数据请求
     */
    public <T> void toDataRequest(Observable<BaseResponse<T>> observable, DisposableObserver<BaseResponse<T>> subscriber) {
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }
}
