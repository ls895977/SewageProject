package com.sewageproject.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.sewageproject.R
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivityMainBinding
import com.sewageproject.ui.fragment.SupervisoryControlMvpFragment
import com.sewageproject.ui.fragment.VideoMvpFragment
import com.sewageproject.ui.fragment.WaterRegimeMvpFragment
import com.sewageproject.ui.fragment.WorkbenchMvpFragment
import com.sewageproject.ui.model.MainViewModel
import com.shuyu.gsyvideoplayer.GSYVideoManager

class MainActivity : BaseVmActivity<ActivityMainBinding, MainViewModel>() {
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java
    private val tv = arrayOfNulls<TextView>(4)
    private val im = arrayOfNulls<ImageView>(4)
    var fgtData: MutableList<Fragment> = ArrayList()
    override fun initView() {
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
        fgtData.add(WaterRegimeMvpFragment())
        fgtData.add(SupervisoryControlMvpFragment())
        fgtData.add(WorkbenchMvpFragment())
        fgtData.add(VideoMvpFragment())
        supportFragmentManager.beginTransaction().add(R.id.myFrame, fgtData[0])
                .add(R.id.myFrame, fgtData[1]).hide(fgtData[1]).show(fgtData[0]).commit()
        setCurrent(0)
    }

    override fun setListener() {
        mBinding.itemBut1.setOnClickListener {
            setCurrent(0)
            GSYVideoManager.onPause()
        }
        mBinding.itemBut2.setOnClickListener {
            setCurrent(1)
            GSYVideoManager.onPause()
        }
        mBinding.itemBut3.setOnClickListener {
        }
        mBinding.itemBut4.setOnClickListener {
            setCurrent(2)
            GSYVideoManager.onPause()
        }
        mBinding.itemBut5.setOnClickListener {
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
}