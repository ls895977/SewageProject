package com.sewageproject.base

import android.app.Application
import android.content.Context
import com.yechaoa.yutilskt.YUtils.init

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        init(this)
    }

    companion object {
        @JvmStatic
        var application: Context? = null
            private set
    }
}