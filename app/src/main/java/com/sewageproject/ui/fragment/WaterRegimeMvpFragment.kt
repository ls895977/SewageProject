package com.sewageproject.ui.fragment

import android.os.Bundle
import android.view.View
import com.sewageproject.R
import com.sewageproject.base.BaseMvpFragment
import com.sewageproject.base.BasePresenter
import com.sewageproject.databinding.WaterregimefragmentBinding
import com.sewageproject.ui.fragment.adapter.SewageListAdapter
import com.sewageproject.ui.fragment.adapter.WaterDataAdapter
import com.sewageproject.ui.fragment.bean.SewageListBean
import com.sewageproject.ui.fragment.bean.WaterDataBean
import kotlinx.android.synthetic.main.titlebar.view.*

/**
 * 水情
 */
class WaterRegimeMvpFragment :
    BaseMvpFragment<WaterregimefragmentBinding, BasePresenter<*>?>() {
    override fun statusBarDark(): Boolean {
        return false
    }

    override fun getResourceId(): Int {
        return R.layout.waterregimefragment
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding?.waterTitle?.leftBack?.visibility= View.GONE
        binding?.waterTitle?.tvTitle?.text="水情"
        binding?.waterTitle?.ivRight?.setBackgroundResource(R.mipmap.ic_heard)
    }

    override fun initData() {
        val waterData: MutableList<WaterDataBean> = ArrayList()
        waterData.add(WaterDataBean("200","在线站点"))
        waterData.add(WaterDataBean("60","离线站点"))
        waterData.add(WaterDataBean("60","报警总数"))
        waterData.add(WaterDataBean("500","站点总数"))
        waterData.add(WaterDataBean("60","巡检提醒"))
        waterData.add(WaterDataBean("60","保障站点"))
        waterData.add(WaterDataBean("60","当日出水量（吨）"))
        waterData.add(WaterDataBean("60","当月出水量（吨）"))
        waterData.add(WaterDataBean("60","累积出水量（吨）"))
        binding?.waterDataRecyclerView?.adapter= WaterDataAdapter(waterData)

        val sewageList: MutableList<SewageListBean> = ArrayList()
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        binding?.sewageListRecyclerView?.adapter= SewageListAdapter(sewageList)

    }
    override fun initListener() {}

    override fun createPresenter(): BasePresenter<*>? {
        return null
    }

}