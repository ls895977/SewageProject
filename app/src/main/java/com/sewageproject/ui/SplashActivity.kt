package com.sewageproject.ui
import android.os.CountDownTimer
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivitySplashBinding
import com.sewageproject.ui.model.SplashViewModel
import com.sewageproject.utils.ActStartUtils
class SplashActivity : BaseVmActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun initView() {
        timer.start()
    }

    private val timer: CountDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            ActStartUtils.startAct(this@SplashActivity, LoginActivity::class.java)
            finish()
        }
    }

    override fun initData() {

    }

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }
}