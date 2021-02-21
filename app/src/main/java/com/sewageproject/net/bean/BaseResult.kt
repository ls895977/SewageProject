package com.sewageproject.net.bean

data class  BaseResult<T>(val code: String, val message: String, val result: T)
