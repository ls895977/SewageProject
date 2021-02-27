package com.sewageproject.ui.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import com.sewageproject.ui.fragment.bean.*

class WaterRegimeViewModel:BaseViewModel(){
    private val waterApi by lazy { RetrofitClient.getApiService() }
     val countWarnNum = MutableLiveData<Int>()
    /**
     * 报障完成率
     */
    fun countWarn(){
        launch( block = {
            countWarnNum.value=waterApi.countWarn().result().sum
        })
    }
      val countRepairNum = MutableLiveData<Int>()
    /**
     * 维养完成率
     */
    fun countRepair(){
        launch( block = {
            countRepairNum.value=waterApi.countRepair().result().sum
        })

    }
     val countInspectionNum = MutableLiveData<Int>()
    /**
     * 巡检完成率
     */
    fun countInspection(){
        launch( block = {
            countInspectionNum.value=waterApi.countInspection().result().sum
        })
    }
    val countCountSumData = MutableLiveData<MutableList<WaterDataBean>>()
    private val  countData:MutableList<WaterDataBean> =ArrayList()
    /**
     * 水情统计9个数据
     */
    fun countCountSum(){
            launch(
                block = {
                    val  countCountBean=waterApi.countCountSum().result()
                    if(countCountBean.records.isNotEmpty()){
                        countData.add(WaterDataBean(countCountBean.records[0].onlineNum.toString(), "在线站点"))
                        countData.add(WaterDataBean(countCountBean.records[0].offlineNum.toString(), "离线站点"))
                        countData.add(WaterDataBean(countCountBean.records[0].warnNum.toString(), "报警总数"))
                        countData.add(WaterDataBean(countCountBean.records[0].num.toString(), "站点总数"))
                        countData.add(WaterDataBean(countCountBean.records[0].inspectionNum.toString(), "巡检提醒"))
                        countData.add(WaterDataBean(countCountBean.records[0].errorNum.toString(), "保障站点"))
                        countData.add(WaterDataBean(countCountBean.records[0].outTodayWater.toString(), "当日出水量（吨）"))
                        countData.add(WaterDataBean(countCountBean.records[0].outMonthWater.toString(), "当月出水量（吨）"))
                        countData.add(WaterDataBean(countCountBean.records[0].outAllWater.toString(), "累积出水量（吨）"))
                    }
                    countCountSumData.value=countData
                }
            )
    }
    val countWorkInfoListBean = MutableLiveData<CountWorkInfoListBean>()
    /**
     * 水情查询工作信息多少条
     */
    fun countWorkInfoList(){
         launch(
             block = {
                 countWorkInfoListBean.value=  waterApi.countWorkInfoList().result()
             }
         )
    }
    val wuShuiQueryTownBean = MutableLiveData<WuShuiQueryTownBean>()
    /**
     * 水情监控-实时数据
     */
    fun wuShuiQueryTown(){
        launch(
                block = {

//                    wuShuiQueryTownBean.value=  waterApi.wuShuiQueryTown().result()
                }
        )
    }
}