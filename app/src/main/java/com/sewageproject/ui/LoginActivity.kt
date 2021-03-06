package com.sewageproject.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import androidx.lifecycle.Observer
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.SigninactivityBinding
import com.sewageproject.ui.model.LoginModel
import com.sewageproject.utils.ActStartUtils
import com.sewageproject.utils.SPUtils
import com.sewageproject.utils.SpConstant
import com.yechaoa.yutilskt.ToastUtil
import com.yechaoa.yutilskt.YUtils

/**
 * 登录
 */
class LoginActivity :
    BaseVmActivity<SigninactivityBinding, LoginModel>() {
    override fun statusBarDark(): Boolean {
        return false
    }

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<LoginModel> = LoginModel::class.java

    override fun getViewBinding(): SigninactivityBinding {
        return SigninactivityBinding.inflate(layoutInflater)
    }

    override fun setListener() {
        mBinding.ivEyE.setOnClickListener {
            if (mBinding.ivEyE.isSelected) {
                mBinding.ivEyE.isSelected = false
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                mBinding.etPassword.transformationMethod = method
            } else {
                mBinding.ivEyE.isSelected = true
                val method = HideReturnsTransformationMethod.getInstance()
                mBinding.etPassword.transformationMethod = method
            }
        }
        mBinding.tvRadio.setOnClickListener {
            mBinding.tvRadio.isSelected = !mBinding.tvRadio.isSelected
        }
        mBinding.tvCommit.setOnClickListener {
            mBinding.etUsername.error = null
            mBinding.etPassword.error = null
            val username = mBinding.etUsername.text.toString().trim()
            val password = mBinding.etPassword.text.toString().trim()
            if (username.isBlank()) {
                ToastUtil.show("账号不能为空！")
                return@setOnClickListener
            }
            if (password.isBlank()) {
                ToastUtil.show("密码不能为空！")
                return@setOnClickListener
            }
            if(mBinding.tvRadio.isSelected){
                SPUtils.getInstance().put(SpConstant.USER_PHONE,username)
                SPUtils.getInstance().put(SpConstant.USER_PWD,password)
            }else{
                SPUtils.getInstance().put(SpConstant.USER_PHONE,"")
                SPUtils.getInstance().put(SpConstant.USER_PWD,"")
            }
            YUtils.showLoading(this, "登录中...")
            mViewModel.login(username, password)

        }

    }

    override fun initView() {
        mBinding.tvRadio.isSelected=true
        if (!SPUtils.getInstance().getString(SpConstant.USER_PHONE).isNullOrBlank()) {
            mBinding.etUsername.setText(SPUtils.getInstance().getString(SpConstant.USER_PHONE))
            mBinding.etPassword.setText(SPUtils.getInstance().getString(SpConstant.USER_PWD))
        }
    }

    override fun observe() {
        super.observe()
        mViewModel.loginState.observe(this, Observer {
            YUtils.hideLoading()
            if (it) {
                ActStartUtils.startAct(this, MainActivity::class.java)
                finish()
            } else {
                ToastUtil.show("登录失败!")
            }
        })
    }
}

