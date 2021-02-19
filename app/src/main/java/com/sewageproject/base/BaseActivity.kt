package com.sewageproject.base
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.sewageproject.utils.EventBusUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity: RxAppCompatActivity(), IActivity{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isRegisterEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBusUtil.register(this)
        }
        initView(savedInstanceState)
        initData()
        initListener()
    }


    fun onBack(v: View){
         finish()
    }
    /**
     * 每次启动activity都会调用此方法,此处主要为了解决快速点击跳转Activity重复打开的问题
     */
    @SuppressLint("RestrictedApi")
    override fun startActivityForResult(intent: Intent?, requestCode: Int, options: Bundle?) {
        if (checkDoubleClick(intent)) {
            super.startActivityForResult(intent, requestCode, options)
        }
    }

    override fun isFull(): Boolean {
        return true
    }

    override fun isRegisterEventBus(): Boolean {
        return false
    }
    /**
     * 状态栏字体深色或亮色
     * isDarkFont true 深色
     */
    protected open fun statusBarDark(): Boolean {
        return true
    }
    private var mActivityJumpTag //activity跳转tag
            : String? = null
    private var mClickTime //activity跳转时间
            : Long = 0
    /**
     * 检查是否重复跳转，不需要则重写方法并返回true
     */
    protected open fun checkDoubleClick(intent: Intent?): Boolean {

        // 默认检查通过
        var result = true
        // 标记对象
        val tag: String? = when {
            intent?.component != null -> { // 显式跳转
                intent.component!!.className
            }
            intent?.action != null -> { // 隐式跳转
                intent.action
            }
            else -> {
                return true
            }
        }
        if (tag == mActivityJumpTag && mClickTime >= SystemClock.uptimeMillis() - 500) {
            // 检查不通过
            result = false
        }

        // 记录启动标记和时间
        mActivityJumpTag = tag
        mClickTime = SystemClock.uptimeMillis()
        return result
    }
}