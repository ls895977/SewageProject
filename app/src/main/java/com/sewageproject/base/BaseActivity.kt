package com.sewageproject.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.sewageproject.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

abstract class BaseActivity<V : ViewDataBinding> : AppCompatActivity() {
    var binding: V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getResourceId())
        ImmersionBar.with(this).statusBarDarkFont(statusBarDark()).keyboardEnable(true)
            .navigationBarColor(R.color.white).init()
        EventBus.getDefault().register(this)
        initView()
        initData()
        initListener()
    }
     @Subscribe
     open fun mainEvent(event: MainEventBean?) {

     }

    fun onBack(v: View){
         finish()
    }
    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        binding = null
        super.onDestroy()
    }
    open fun toNextPage(cls: Class<*>?) {
        val intent = Intent()
        intent.setClass(this, cls!!)
        startActivity(intent)
    }
    open fun toNextPage(cls: Class<*>?, bundle: Bundle?) {
        val intent = Intent()
        intent.putExtras(bundle!!)
        intent.setClass(this, cls!!)
        startActivity(intent)
    }

    open fun toNextPage(cls: Class<*>?, requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls!!)
        startActivityForResult(intent, requestCode)
    }

    open fun toNextPage(cls: Class<*>?, bundle: Bundle?, requestCode: Int) {
        val intent = Intent()
        intent.putExtras(bundle!!)
        intent.setClass(this, cls!!)
        startActivityForResult(intent, requestCode)
    }
    /**
     * 设置布局id
     * @return
     */
    protected abstract fun getResourceId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun initListener()

    /**
     * 状态栏字体深色或亮色
     *
     *
     * isDarkFont true 深色
     */
    protected open fun statusBarDark(): Boolean {
        return true
    }
}