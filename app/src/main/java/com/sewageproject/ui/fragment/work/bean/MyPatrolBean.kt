package com.sewageproject.ui.fragment.work.bean

data class MyPatrolBean(
    val `data`: List<Data>,
    val daysOfMonth: Int
)

data class Data(
    val inspectionScheOrderId: Any,
    val inspectionStaffId: String,
    val inspectionStaffName: String,
    val orderYearAndMonth: String,
    val scheObjs: List<ScheObj>
)

data class ScheObj(
    val completeRate: Double,
    val id: Any,
    val inspectionAreaType: String,
    val inspectionPeriodType: String,
    val oncePerDay: Boolean,
    val pathId: Int,
    val pathName: String,
    val plantAreaId: Any,
    val plantAreaName: Any,
    val twicePerDay: Boolean,
    val validEndTime: Any,
    val validStartTime: Any
)