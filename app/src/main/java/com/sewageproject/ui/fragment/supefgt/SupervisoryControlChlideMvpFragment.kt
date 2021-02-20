package com.sewageproject.ui.fragment.supefgt

import android.os.Bundle
import com.sewageproject.R
import com.sewageproject.base.BaseMvpFragment
import com.sewageproject.base.BasePresenter
import com.sewageproject.databinding.SupervisorycontrolchlidefragmentBinding
import com.sewageproject.ui.fragment.adapter.SupervisoryControlAdapter
import com.sewageproject.ui.fragment.bean.SupervisoryControlBean

class SupervisoryControlChlideMvpFragment :
    BaseMvpFragment<SupervisorycontrolchlidefragmentBinding,BasePresenter<*>?>() {
    override fun statusBarDark(): Boolean {
        return false
    }
    override fun getResourceId(): Int {
        return  R.layout.supervisorycontrolchlidefragment
    }


    override fun initData() {
       val dataList:MutableList<SupervisoryControlBean> = ArrayList()
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        dataList.add(SupervisoryControlBean())
        binding?.superRecyclerView?.adapter= SupervisoryControlAdapter(dataList)

    }
    override fun initListener() {
        binding?.mySmartRefreshLayout?.setOnRefreshListener {
            binding?.mySmartRefreshLayout?.finishRefresh(2000)
        }
        binding?.mySmartRefreshLayout?.setOnLoadMoreListener {
            binding?.mySmartRefreshLayout?.finishLoadMore(2000)
        }
    }

    /**
     * create presenter
     * @return presenter
     */
    override fun createPresenter(): BasePresenter<*>? {
      return null
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}