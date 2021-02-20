package com.sewageproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.sewageproject.R
import com.sewageproject.utils.EventBusUtil
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.FragmentEvent
import org.greenrobot.eventbus.EventBus
abstract class BaseMvpFragment<V : ViewDataBinding,P : BasePresenter<*>?>: BaseFragment() {
    protected abstract fun getResourceId(): Int
    protected abstract fun initData()
    protected abstract fun initListener()
    protected abstract fun initView(savedInstanceState: Bundle?)
    protected open fun statusBarDark(): Boolean {
        return true
    }
    var binding: V? = null
     var mPresenter: P? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getResourceId(), null, false)
        mPresenter = createPresenter()
        ImmersionBar.with(this).statusBarDarkFont(statusBarDark()).keyboardEnable(true)
            .navigationBarColor(R.color.white).init()
        if (isRegisterEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBusUtil.register(this)
        }
        initView(savedInstanceState)
        initData()
        initListener()
        return binding?.root
    }
     fun isRegisterEventBus(): Boolean {
        return false
    }
    /**
     * create presenter
     * @return presenter
     */
    protected abstract fun createPresenter(): P

    open fun <B> getActLifeRecycle(): LifecycleTransformer<B>? {
        return bindUntilEvent(FragmentEvent.DESTROY)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }
    override fun onDestroyView() {
        if (isRegisterEventBus() && EventBus.getDefault()
                .isRegistered(this)
        ) {
            EventBusUtil.unregister(this)
        }
        binding = null
        if (mPresenter != null) {
            mPresenter?.detachView()
        }
        super.onDestroyView()
    }
}