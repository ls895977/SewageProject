package com.sewageproject.ui.fragment.bean

  data class CountCountSumBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Record(
    val errorNum: Int,
    val inspectionNum: Int,
    val num: Int,
    val offlineNum: Int,
    val onlineNum: Int,
    val outAllWater: Double,
    val outMonthWater: Double,
    val outTodayWater: Double,
    val warnNum: Int,

    //水情 查询工作信息
    val createTime:String,
    val plantAreaName:String,
    val id:String,
    val content:String,
    val plantAreaId:String
)