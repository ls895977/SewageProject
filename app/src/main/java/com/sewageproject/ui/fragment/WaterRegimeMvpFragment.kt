package com.sewageproject.ui.fragment

import android.view.View
import com.bumptech.glide.Glide
import com.sewageproject.R
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.WaterregimefragmentBinding
import com.sewageproject.ui.fragment.adapter.SewageListAdapter
import com.sewageproject.ui.fragment.adapter.WaterDataAdapter
import com.sewageproject.ui.fragment.bean.SewageListBean
import com.sewageproject.ui.fragment.bean.WaterDataBean
import com.sewageproject.ui.fragment.viewmodel.WaterRegimeViewModel
import com.sewageproject.utils.GlideUtils
import com.sewageproject.utils.SPUtils

/**
 * 水情
 */
class WaterRegimeMvpFragment :
    BaseVmFragment<WaterregimefragmentBinding, WaterRegimeViewModel>() {
    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<WaterRegimeViewModel> = WaterRegimeViewModel::class.java
    override fun getViewBinding(): WaterregimefragmentBinding {
        return WaterregimefragmentBinding.inflate(layoutInflater)
    }

    /**
     * 初始化view相关
     */
    override fun initView() {
        binding?.waterTitle?.leftBack?.visibility = View.GONE
        binding?.waterTitle?.tvTitle?.text = "水情"
        binding?.waterTitle?.ivRight?.let {
            context?.let { it1 ->
                GlideUtils.headPortrait(
                    it1, it,
                    SPUtils.getInstance().myUserInfo.userInfo.avatar
                )
            }
        }

    }

    override fun initData() {
        val waterData: MutableList<WaterDataBean> = ArrayList()
        waterData.add(WaterDataBean("200", "在线站点"))
        waterData.add(WaterDataBean("60", "离线站点"))
        waterData.add(WaterDataBean("60", "报警总数"))
        waterData.add(WaterDataBean("500", "站点总数"))
        waterData.add(WaterDataBean("60", "巡检提醒"))
        waterData.add(WaterDataBean("60", "保障站点"))
        waterData.add(WaterDataBean("60", "当日出水量（吨）"))
        waterData.add(WaterDataBean("60", "当月出水量（吨）"))
        waterData.add(WaterDataBean("60", "累积出水量（吨）"))
        binding?.waterDataRecyclerView?.adapter = WaterDataAdapter(waterData)
        val sewageList: MutableList<SewageListBean> = ArrayList()
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        binding?.sewageListRecyclerView?.adapter = SewageListAdapter(sewageList)

    }
}