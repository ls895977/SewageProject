package com.sewageproject.ui.fragment.bean

data class WuShuiQueryTownBean(
    val current: Int,
    val orders: List<Any>,
    val pages: Int,
    val records: List<Record>,
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
    val dataTime: Any,
    val inAllWater: Any,
    val inCod: Any,
    val inNh: Any,
    val inPh: Any
)

data class WaterOut(
    val dataTime: Any,
    val outAllWater: Any,
    val outAn: Any,
    val outAp: Any,
    val outCod: Any,
    val outInstantWater: Any,
    val outNh: Any,
    val outPh: Any,
    val outTodayWater: Any
)