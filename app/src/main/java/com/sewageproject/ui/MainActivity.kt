package com.sewageproject.ui
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.sewageproject.R
import com.sewageproject.base.BaseActivity
import com.sewageproject.base.BaseMvpActivity
import com.sewageproject.base.BasePresenter
import com.sewageproject.databinding.ActivityMainBinding
import com.sewageproject.ui.fragment.SupervisoryControlFragment
import com.sewageproject.ui.fragment.VideoFragment
import com.sewageproject.ui.fragment.WaterRegimeFragment
import com.sewageproject.ui.fragment.WorkbenchFragment
import com.sewageproject.ui.presenter.MainPresenter
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.trello.rxlifecycle2.LifecycleTransformer
import java.util.*

class MainActivity : BaseMvpActivity<ActivityMainBinding, MainPresenter?>() {
    private val tv = arrayOfNulls<TextView>(4)
    private val im = arrayOfNulls<ImageView>(4)
    var fgtData: MutableList<Fragment> = ArrayList()
    override fun getResourceId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        im[0] = findViewById(R.id.ivShuiQi)
        im[1] = findViewById(R.id.ivJK)
        im[2] = findViewById(R.id.ivgzt)
        im[3] = findViewById(R.id.ivsp)
        tv[0] = findViewById(R.id.tvShuiQi)
        tv[1] = findViewById(R.id.tvJK)
        tv[2] = findViewById(R.id.tvgzt)
        tv[3] = findViewById(R.id.tvsp)
    }

    override fun initData() {
        fgtData.add(WaterRegimeFragment())
        fgtData.add(SupervisoryControlFragment())
        fgtData.add(WorkbenchFragment())
        fgtData.add(VideoFragment())
        supportFragmentManager.beginTransaction().add(R.id.myFrame, fgtData[0])
            .add(R.id.myFrame, fgtData[1]).hide(fgtData[1]).show(fgtData[0]).commit()
        setCurrent(0)
    }

    override fun initListener() {
        binding?.itemBut1?.setOnClickListener {
            setCurrent(0)
            GSYVideoManager.onPause()
        }
        binding?.itemBut2?.setOnClickListener {
            setCurrent(1)
            GSYVideoManager.onPause()
        }
        binding?.itemBut3?.setOnClickListener {
        }
        binding?.itemBut4?.setOnClickListener {
            setCurrent(2)
            GSYVideoManager.onPause()
        }
        binding?.itemBut5?.setOnClickListener {
            setCurrent(3)
            GSYVideoManager.onResume()
        }
    }

    var currentTabIndex = 0
   private fun setCurrent(indext: Int) {
        if (currentTabIndex != indext) {
            val trx: FragmentTransaction = supportFragmentManager.beginTransaction()
            trx.hide(fgtData[currentTabIndex])
            if (!fgtData[indext].isAdded) {
                trx.add(R.id.myFrame, fgtData[indext])
            }
            trx.show(fgtData[indext]).commit()
        }
        tv[currentTabIndex]!!.isSelected = false
        tv[indext]!!.isSelected = true
       im[currentTabIndex]!!.isSelected = false
       im[indext]!!.isSelected = true
        currentTabIndex = indext
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
    }

    override fun createPresenter(): MainPresenter? {
        return MainPresenter()
    }

}