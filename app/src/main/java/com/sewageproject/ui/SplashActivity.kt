package com.sewageproject.ui
import android.os.Bundle
import android.os.CountDownTimer
import com.sewageproject.R
import com.sewageproject.base.BaseMvpActivity
import com.sewageproject.databinding.ActivityMainBinding
import com.sewageproject.ui.presenter.SplashPresenter
import com.sewageproject.utils.ActStartUtils


class SplashActivity : BaseMvpActivity<ActivityMainBinding,SplashPresenter>() {

    override fun getResourceId(): Int {
        return R.layout.activity_splash
    }

    override fun initView(savedInstanceState: Bundle?) {
        timer.start()
    }
    private val timer: CountDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }
        override fun onFinish() {
            ActStartUtils.startAct(this@SplashActivity,LoginActivity::class.java)
            finish()
        }
    }
    override fun initData() {

    }

    override fun initListener() {}
    override fun createPresenter(): SplashPresenter {
        return SplashPresenter()
    }

}