package com.sewageproject.ui.fragment.work.bean

import java.math.BigDecimal

data class MyPatrolBean(
    val `data`: MutableList<Data>,
    val pageNo: Int,
    val pageSize: Int
)

data class Data(
    val completeRate: String,
    val inspectionStaffId: String,
    val inspectionStaffName: String,
    val orderYearAndMonth: String,
    val pathId: Int,
    val pathName: String,
    val periodMsg: String
){
 fun getCompleteRate():Int{
   var rate =0
   if(completeRate!=null&&completeRate.isNotEmpty()){
    rate= completeRate.toBigDecimal().setScale(0,BigDecimal.ROUND_HALF_UP).intValueExact()

   }
  return rate
 }
}