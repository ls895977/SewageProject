package com.sewageproject.net

import com.sewageproject.net.bean.BaseResult
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
interface TranslateService {
     /**
      * 账号密码登录
      */
     @POST("sys/login")
     suspend fun requestDailyWord(@Body requestBody: RequestBody): BaseResult<String>


     companion object {
         private const val BASE_URL = "http://jwushui.seater.cn:81/jeecg-boot/"
         private var service: TranslateService? = null
         /**
          * 通过Retrofit的动态代理生成TranslateService实现类
          */
         fun getApi(): TranslateService {
             if (null == service) {
                 val httpLoggingInterceptor =
                     HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
                 val client = OkHttpClient.Builder()
                     .addInterceptor(httpLoggingInterceptor)
                     .build()
                 val retrofit = Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .client(client)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                 service = retrofit.create(TranslateService::class.java)
             }
             return service!!
         }
     }
 }