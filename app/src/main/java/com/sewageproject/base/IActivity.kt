package com.sewageproject.base

import android.os.Bundle
import io.reactivex.annotations.Nullable

interface IActivity {
    /**
     * 初始化 View, 如果 [.setLayoutId] 返回 0, 则不会调用 [Activity.setContentView]
     *
     */
     fun getResourceId(): Int
    /**
     * 初始化布局
     */
    fun initView(@Nullable savedInstanceState: Bundle?)
    /**
     * 初始化数据
     */
   fun initData()
    /**
     * 初始化监听
     */
    fun initListener()
    /**
     * 是否使用 EventBus
     *
     * @return
     */
    fun  isRegisterEventBus():Boolean
    /**
     * 是否全屏
     * @return
     */
    fun isFull(): Boolean
}