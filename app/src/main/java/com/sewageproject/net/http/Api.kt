package com.sewageproject.net.http

import com.sewageproject.base.BaseBean
import com.sewageproject.base.BaseListBean
import com.sewageproject.net.bean.User
import com.sewageproject.ui.fragment.bean.CountCountSumBean
import com.sewageproject.ui.fragment.bean.CountWarnBean
import com.sewageproject.ui.fragment.bean.CountWorkInfoListBean
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
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

    //查询告警统计
    @GET("count/countWarn/queryCurrentWarnMonth")
    suspend fun countWarn(): BaseBean<CountWarnBean>

    //维养查询
    @GET("count/countRepair/queryCurrentRepairMonth")
    suspend fun countRepair(): BaseBean<CountWarnBean>

    //查询当月巡检统计
    @GET("count/countInspection/queryCurrentInspectionMonth")
    suspend fun countInspection(): BaseBean<CountWarnBean>

    //水情 汇总9个数据
    @GET("count/countSum/query")
    suspend fun countCountSum(): BaseBean<CountCountSumBean>

    //水情 查询工作信息
    @GET("count/workInfo/list")
    suspend fun countWorkInfoList(): BaseBean<CountWorkInfoListBean>
}