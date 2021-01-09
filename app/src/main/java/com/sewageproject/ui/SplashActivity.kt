package com.sewageproject.ui
import android.os.CountDownTimer
import android.util.Log
import com.sewageproject.R
import com.sewageproject.base.BaseActivity
import com.sewageproject.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getResourceId(): Int {
        return R.layout.activity_splash
    }
    private val timer: CountDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }
        override fun onFinish() {
            toNextPage(SignInActivity::class.java)
            finish()
        }
    }

    override fun initView() {
        timer.start()
    }

    override fun initData() {

    }

    override fun initListener() {}

}