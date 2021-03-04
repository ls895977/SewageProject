package com.sewageproject.ui.fragment.bean

data class PatPlantAreaAllTypeListBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record2>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Record2(
    val canUse: Int,
    val canUse_dictText: String,
    val code: String,
    val createBy: String,
    val createTime: String,
    val id: String,
    val name: String,
    val updateBy: Any,
    val updateTime: Any,
    var status:Boolean
)