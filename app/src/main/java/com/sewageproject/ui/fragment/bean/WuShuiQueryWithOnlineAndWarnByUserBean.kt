package com.sewageproject.ui.fragment.bean

data class WuShuiQueryWithOnlineAndWarnByUserBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)