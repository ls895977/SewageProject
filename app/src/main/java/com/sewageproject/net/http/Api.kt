package com.sewageproject.net.http

import com.sewageproject.base.BaseBean
import com.sewageproject.net.bean.User
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by yechaoa on 2020/2/4.
 * Describe :
 */
interface Api {

    companion object {
        const val BASE_URL = "http://jwushui.seater.cn:81/jeecg-boot/"
    }
    //登录
    @POST("sys/login")
    suspend fun login(@Body requestBody: RequestBody): BaseBean<User>
}