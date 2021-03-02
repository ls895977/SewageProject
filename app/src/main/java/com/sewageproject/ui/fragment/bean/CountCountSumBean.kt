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
    val plantAreaId:String,
    //水情 水情监控-实时数据
    val canUse: Boolean,
    val idWaterInDai: String,
    val idWaterOutDai: String,
    val name: String,
    val online: Boolean,
    val plantAreaTypeCanUse: Boolean,
    val plantAreaTypeId: String,
    val plantAreaTypeName: String,
    val uid: String,
    val vars: Vars,
    val varsDict: VarsDict,
   //监控-》镇级数据

    val address: Any,
    val code: Any,
    val createBy: String,
    val designScale: Double,
    val hasSheet: Int,
    val headUserCodeAccount: Any,
    val imgUris: Any,
    val latitude: Double,
    val locateTypes: String,
    val longitude: Double,
    val phoneNumber: Any,
    val plantAreaAllTypeId: String,
    val plantAreaDataList: Any,
    val plantAreaType: String,
    val plantAreaTypeIdStr: Any,
    val remark: Any,
    val shortName: String,
    val sysOrgCode: String,
    val troubleIs: Boolean,
    val troubleNum: Int,
    val updateBy: String,
    val updateTime: String,
    val warnIs: Boolean,
    val waterDeviceList: Any
)