package com.sewageproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ImmersionBar
import com.sewageproject.R
import kotlinx.coroutines.CoroutineScope
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 *Created by wanghai
 *Date : 2020/12/23
 *Describe :
 */
abstract class BaseFragment<V : ViewDataBinding>: Fragment() {
    protected abstract fun getResourceId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun initListener()
    protected open fun statusBarDark(): Boolean {
        return true
    }

    var binding: V? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getResourceId(), null, false)
        ImmersionBar.with(this).statusBarDarkFont(statusBarDark()).keyboardEnable(true)
            .navigationBarColor(R.color.white).init()
        EventBus.getDefault().register(this)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initListener()
        initData()
    }

    override fun onDestroyView() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        binding = null
        super.onDestroyView()
    }
    @Subscribe
    open fun fragmenEvent(event: MainEventBean?) {
    }
}