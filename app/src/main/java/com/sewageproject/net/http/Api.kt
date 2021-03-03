package com.sewageproject.net.http

import com.sewageproject.base.BaseBean
import com.sewageproject.base.BaseListBean
import com.sewageproject.net.bean.User
import com.sewageproject.ui.fragment.bean.*
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by yechaoa on 2020/2/4.
 * Describe :
 */
interface Api {

    companion object {
        const val BASE_URL = "http://jwushui.seater.cn:81/jeecg-boot/"
        const val BASE_IMGURL="http://jwushui.seater.cn:81/jeecg-boot/sys/common/static/"
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

    //水情 水情监控-实时数据
    @GET("wushui/plantAreaWaterState/queryTown")
    suspend fun wuShuiQueryTown(@Query("pageSize")pageSize:String,@Query("pageNo")pageNo:String ): BaseBean<WuShuiQueryTownBean>

    //监控 带在线状态,报警数跟告警数)(权限)（监控-》镇级和村级）
    //plantAreaAllTypeId 站点类型id
    //plantAreaType  站点级别
    //online 是否在线
    //troubleIs 是否报障中
    //warnIs 是否告警中
    @GET("wushui/plantArea/queryWithOnlineAndWarnByUser")
    suspend fun wuShuiQueryWithOnlineAndWarnByUser(@Query("pageSize")pageSize:String,
                                                   @Query("pageNo")pageNo:String ,
                                                   @Query("plantAreaType")plantAreaType:String,
                                                   @Query("plantAreaAllTypeId")plantAreaAllTypeId:String,
                                                   @Query("online")online:Boolean,
                                                   @Query("troubleIs")troubleIs:Boolean,
                                                   @Query("warnIs")warnIs:Boolean
                                                         ): BaseBean<WuShuiQueryWithOnlineAndWarnByUserBean>
    @GET("wushui/plantArea/queryWithOnlineAndWarnByUser")
    suspend fun wuShuiQueryWithOnlineAndWarnByUser(@Query("pageSize")pageSize:String,
                                                   @Query("pageNo")pageNo:String ,
                                                   @Query("plantAreaType")plantAreaType:String
    ): BaseBean<WuShuiQueryWithOnlineAndWarnByUserBean>
//    WuShuiQueryWithOnlineAndWarnByUserBean
    //站点类型  =>监控=筛选=站点类型
    @GET("pat/PlantAreaAllType/list")
    suspend fun patPlantAreaAllTypeList(@Query("pageSize")pageSize:String,
                                                   @Query("pageNo")pageNo:String ,
                                                   @Query("plantAreaType")plantAreaType:String
    ): BaseBean<PatPlantAreaAllTypeListBean>
}