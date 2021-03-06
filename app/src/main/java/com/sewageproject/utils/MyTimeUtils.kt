package com.sewageproject.utils

import java.text.SimpleDateFormat
import java.util.*

object  MyTimeUtils {
    //年月日时分秒格式
     fun getTimes(date: Date): String? {
        val format = SimpleDateFormat("yyyy-MM")
        return format.format(date)
    }
    //年月
    fun getTimesYe(date: Date): String? {
        val format = SimpleDateFormat("yyyy年MM")
        return format.format(date)
    }
}