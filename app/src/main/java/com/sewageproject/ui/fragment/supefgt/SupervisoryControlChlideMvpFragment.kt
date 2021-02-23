package com.sewageproject.ui.fragment.supefgt

import android.os.Bundle
import com.sewageproject.R
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.SupervisorycontrolchlidefragmentBinding
import com.sewageproject.ui.fragment.adapter.SupervisoryControlAdapter
import com.sewageproject.ui.fragment.bean.SupervisoryControlBean
import com.sewageproject.ui.fragment.supefgt.viewmodel.SupervisoryControlChlideViewModel

class SupervisoryControlChlideMvpFragment :
    BaseVmFragment<SupervisorycontrolchlidefragmentBinding, SupervisoryControlChlideViewModel>() {
    override fun initData() {
       val dataList:MutableList<SupervisoryControlBean> = ArrayList()
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        binding?.superRecyclerView?.adapter= SupervisoryControlAdapter(dataList)

    }

    override fun setListener() {
        binding?.mySmartRefreshLayout?.setOnRefreshListener {
            binding?.mySmartRefreshLayout?.finishRefresh(2000)
        }
        binding?.mySmartRefreshLayout?.setOnLoadMoreListener {
            binding?.mySmartRefreshLayout?.finishLoadMore(2000)
        }
    }

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<SupervisoryControlChlideViewModel> = SupervisoryControlChlideViewModel::class.java
    /**
     * 初始化view相关
     */
    override fun initView() {
    }

    override fun getViewBinding(): SupervisorycontrolchlidefragmentBinding {
     return SupervisorycontrolchlidefragmentBinding.inflate(layoutInflater)
    }
}