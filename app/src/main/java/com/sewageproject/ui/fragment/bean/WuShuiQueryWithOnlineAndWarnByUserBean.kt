package com.sewageproject.ui.fragment.bean

data class WuShuiQueryWithOnlineAndWarnByUserBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record1>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Record1(
    val address: Any,
    val canUse: Int,
    val code: Any,
    val createBy: String,
    val createTime: String,
    val designScale: Int,
    val hasSheet: Int,
    val headUserCodeAccount: Any,
    val id: Int,
    val idWaterInDai: Any,
    val idWaterOutDai: Any,
    val imgUris: String,
    val latitude: Double,
    val locateTypes: String,
    val longitude: Double,
    val name: String,
    val online: Boolean,
    val phoneNumber: Any,
    val plantAreaAllTypeId: String,
    val plantAreaDataList: Any,
    val plantAreaType: String,
    val plantAreaTypeIdStr: Any,
    val remark: Any,
    val shortName: String,
    val sysOrgCode: String,
    val troubleIs: Boolean,
    val troubleNum: Any,
    val uid: String,
    val updateBy: String,
    val updateTime: String,
    val warnIs: Boolean,
    val warnNum: Any,
    val waterDeviceList: Any
)