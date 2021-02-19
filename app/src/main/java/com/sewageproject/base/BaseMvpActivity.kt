package com.sewageproject.base

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.sewageproject.R
import com.sewageproject.view.LoadingDialog
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent

abstract class BaseMvpActivity<V : ViewDataBinding, P : BasePresenter<*>?> : BaseActivity(), BaseView {
    var binding: V? = null
    private var mPresenter: P? = null
    var loadingDialog: LoadingDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, getResourceId())
        mPresenter = createPresenter()
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).statusBarDarkFont(statusBarDark()).keyboardEnable(true)
            .navigationBarColor(R.color.white).init()
    }
    override fun <B : Any?> getActLifeRecycle(): LifecycleTransformer<B> {
        return bindUntilEvent(ActivityEvent.DESTROY)
    }
    /**
     * 创建Presenter
     * @return presenter
     */
    protected abstract fun createPresenter(): P
    override fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(this)
            loadingDialog!!.setCancelable(true)
        }
        loadingDialog!!.show()
        loadingDialog!!.startRotate()
    }

    override fun hideLoading() {
        if (loadingDialog != null) {
            loadingDialog!!.dismiss()
            //            loadingDialog.stopRotate();
            loadingDialog = null
        }
    }

    override fun onDestroy() {
        if (mPresenter != null) {
            mPresenter?.detachView()
        }
        super.onDestroy()
    }

    /**
     * 显示键盘
     * @param et 输入焦点
     */
    fun showInput(et: EditText) {
        et.requestFocus()
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT)
    }

    /**
     * 隐藏键盘
     */
    protected fun hideInput() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val v = window.peekDecorView()
        if (null != v) {
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}