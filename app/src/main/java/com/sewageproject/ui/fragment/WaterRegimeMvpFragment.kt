package com.sewageproject.ui.fragment
import android.view.View
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.WaterregimefragmentBinding
import com.sewageproject.ui.fragment.adapter.SewageListAdapter
import com.sewageproject.ui.fragment.adapter.WaterDataAdapter
import com.sewageproject.ui.fragment.bean.SewageListBean
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
   var pageNo=1
    override fun setListener() {
        binding?.mySmartRefreshLayout?.autoRefresh()
        //刷新的监听事件
        binding?.mySmartRefreshLayout?.setOnRefreshListener { _ ->
            pageNo=1
            mViewModel.countCountSum()
            mViewModel.countWarn()
            mViewModel.countRepair()
            mViewModel.countInspection()
            mViewModel.countWorkInfoList()
            mViewModel.wuShuiQueryTown(pageNo)
        }
        //加载的监听事件
        binding?.mySmartRefreshLayout?.setOnLoadMoreListener { refreshLayout ->
            pageNo++
            mViewModel.wuShuiQueryTown(pageNo)

            refreshLayout.finishLoadMoreWithNoMoreData() //全部加载完成,没有数据了调用此方法
        }
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
        val sewageList: MutableList<SewageListBean> = ArrayList()
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        sewageList.add(SewageListBean())
        binding?.sewageListRecyclerView?.adapter = SewageListAdapter(sewageList)
    }

    override fun observe() {
        mViewModel.countWarnNum.observe(this, {
            binding?.tvCountWarn?.text = "$it%"
            binding?.guZhangBar?.progress = it
        })
        mViewModel.countRepairNum.observe(this, {
            binding?.tvCountRepair?.text = "$it%"
            binding?.guWeiYangr?.progress = it
        })
        mViewModel.countInspectionNum.observe(this, {
            binding?.tvCountInspection?.text = "$it%"
            binding?.guXunJian?.progress = it
        })
        mViewModel.countCountSumData.observe(this, {
            binding?.waterDataRecyclerView?.adapter = WaterDataAdapter(it)
        })
        mViewModel.countWorkInfoListBean.observe(this, {
            if (it.records.size > 99) {
                binding?.workNum?.text = "99+"
            } else {
                binding?.workNum?.text = it.records.size.toString()
            }
        })
        mViewModel.wuShuiQueryTownBean.observe(this,{
            if(pageNo==1){
                //请求数据
            binding?.mySmartRefreshLayout?.finishRefresh() //刷新完成
            }else{
                if(pageNo==it.total){


                }else {
                    binding?.mySmartRefreshLayout?.finishLoadMore() //加载完成
                }
            }

        })
    }
}