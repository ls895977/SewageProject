package com.sewageproject.ui.fragment

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.sewageproject.R
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.VideofragmentBinding
import com.sewageproject.ui.fragment.adapter.SewageRightAdapter
import com.sewageproject.ui.fragment.adapter.sewageLeftAdapter
import com.sewageproject.ui.fragment.bean.SewageLeftBean
import com.sewageproject.ui.fragment.bean.SewageRightBean
import com.sewageproject.ui.fragment.viewmodel.VideoViewModel
import java.util.*

/**
 * 视频
 */
class VideoMvpFragment :
    BaseVmFragment<VideofragmentBinding, VideoViewModel>() {
    val urlAD = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4"

    override fun initView() {
    }

    var dataList1: MutableList<SewageLeftBean>? = null
    var sewageLeftAdapter: sewageLeftAdapter? = null
    override fun initData() {
        binding!!.detailPlayer.setUpLazy(urlAD, true, null, null, "这是title")
        //增加title
        binding!!.detailPlayer.titleTextView.visibility = View.GONE
        //设置返回键
        binding!!.detailPlayer.backButton.visibility = View.GONE
        //设置全屏按键功能
        binding!!.detailPlayer.fullscreenButton
            .setOnClickListener {
                binding!!.detailPlayer.startWindowFullscreen(
                    context, false, true
                )
            }
        //是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        binding!!.detailPlayer.isAutoFullWithSize = true
        //音频焦点冲突时是否释放
        binding!!.detailPlayer.isReleaseWhenLossAudio = false
        //全屏动画
        binding!!.detailPlayer.isShowFullAnimation = true
        //小屏时不触摸滑动
        binding!!.detailPlayer.setIsTouchWiget(false)
        dataList1 = ArrayList()
        dataList1?.add(SewageLeftBean("全部"))
        dataList1?.add(SewageLeftBean("站点1"))
        dataList1?.add(SewageLeftBean("站点2"))
        dataList1?.add(SewageLeftBean("站点3"))
        dataList1?.get(0)?.isStatus = true
        sewageLeftAdapter = sewageLeftAdapter(dataList1)
        binding!!.sewageLeftRecyclerView.adapter = sewageLeftAdapter
        sewageLeftAdapter!!.setOnItemClickListener { adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int ->
            dataList1?.get(position)?.isStatus = true
            dataList1?.get(postion)?.isStatus = false
            postion = position
            sewageLeftAdapter!!.notifyDataSetChanged()
        }
        val sewageRightData: MutableList<SewageRightBean> =
            ArrayList()
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        sewageRightData.add(SewageRightBean())
        binding!!.sewageRightRecyclerView.adapter = SewageRightAdapter(sewageRightData)
    }

    var postion = 0

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<VideoViewModel> = VideoViewModel::class.java

    override fun getViewBinding(): VideofragmentBinding {
      return  VideofragmentBinding.inflate(layoutInflater)
    }
}