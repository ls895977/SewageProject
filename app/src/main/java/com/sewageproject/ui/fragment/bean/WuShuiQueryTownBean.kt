package com.sewageproject.ui.fragment.bean

data class WuShuiQueryTownBean(
    val current: Int,
    val orders: MutableList<Any>,
    val pages: Int,
    val records: MutableList<Record>,
    val searchCount: Boolean,
    val size: Int,
    val total: Int
)

data class Vars(
    val waterIn: WaterIn,
    val waterOut: WaterOut
)

class VarsDict(
)

data class WaterIn(
    val dataTime: String,
    val inAllWater: String,
    val inCod: String,
    val inNh: String,
    val inPh: String
)

data class WaterOut(
    val dataTime: String,
    val outAllWater: String,
    val outAn: String,
    val outAp: String,
    val outCod: String,
    val outInstantWater: String,
    val outNh: String,
    val outPh: String,
    val outTodayWater: String
)