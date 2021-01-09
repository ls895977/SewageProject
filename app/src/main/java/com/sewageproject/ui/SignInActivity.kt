package com.sewageproject.ui

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import com.sewageproject.R
import com.sewageproject.base.BaseActivity
import com.sewageproject.databinding.SigninactivityBinding


/**
 * 登录
 */
class SignInActivity :
    BaseActivity<SigninactivityBinding>() {
    override fun statusBarDark(): Boolean {
        return false
    }

    override fun getResourceId(): Int {
        return R.layout.signinactivity
    }

    override fun initView() {}
    override fun initData() {}
    override fun initListener() {
        binding?.ivEyE?.setOnClickListener {
            if(binding?.ivEyE?.isSelected==true){
                binding?.ivEyE?.isSelected=false
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                binding?.etPassword?.transformationMethod = method
            }else{
                binding?.ivEyE?.isSelected=true
                val method = HideReturnsTransformationMethod.getInstance()
                binding?.etPassword?.transformationMethod=method
            }
        }
        binding?.tvRadio?.setOnClickListener {
            binding?.tvRadio?.isSelected = binding?.tvRadio?.isSelected != true
        }
        binding?.tvCommit?.setOnClickListener {
            toNextPage(MainActivity::class.java)
            finish()
        }
    }
}