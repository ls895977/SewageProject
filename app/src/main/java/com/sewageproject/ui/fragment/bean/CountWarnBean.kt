package com.sewageproject.ui.fragment.bean

data class CountWarnBean(
    val content: Content,
    val sum: Int
)

data class Content(
    val Blackout: Int,
    val DeviceFault: Int,
    val High: Int,
    val Low: Int
)