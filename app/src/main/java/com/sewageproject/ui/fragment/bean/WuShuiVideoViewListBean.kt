package com.sewageproject.ui.fragment.bean

data class WuShuiVideoViewListBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: MutableList<Record3>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Record3(
    val id: Int,
    val name: String,
    val videoList: List<Video>,
    var status:Boolean
)

data class Video(
    val ch: Int,
    val id: Int,
    val name: String,
    var url:String
)