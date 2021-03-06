package com.sewageproject.ui.fragment.supefgt
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.SupervisorycontrolchlidefragmentBinding
import com.sewageproject.ui.fragment.adapter.SupervisoryControlAdapter
import com.sewageproject.ui.fragment.bean.Record1
import com.sewageproject.ui.fragment.bean.WuShuiQueryWithOnlineAndWarnByUserBean
import com.sewageproject.ui.fragment.supefgt.viewmodel.SupervisoryControlChlideViewModel
import com.sewageproject.ui.message.MessageJianKongBean
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SupervisoryControlChlideMvpFragment :
    BaseVmFragment<SupervisorycontrolchlidefragmentBinding, SupervisoryControlChlideViewModel>() {
    companion object {
        fun newInstance(plantAreaType: String?): Fragment? {
            val args = Bundle()
            args.putString("plantAreaType", plantAreaType)
            val fragment = SupervisoryControlChlideMvpFragment()
            fragment.arguments = args
            return fragment
        }
    }
    private var plantAreaType=""
    private var plantAreaAllTypeId=""
    private var pageNo=0
    private var online=false
    private var troubleIs=false
    private var warnIs=false
    var myAdapter:SupervisoryControlAdapter?=null
    override fun initData() {
        EventBus.getDefault().register(this)
        plantAreaType= arguments?.getString("plantAreaType").toString()
        myAdapter=SupervisoryControlAdapter(null);
        binding?.superRecyclerView?.adapter= myAdapter
        binding?.mySmartRefreshLayout?.autoRefresh()
    }
//    MessageJianKongBean
@Subscribe(threadMode = ThreadMode.MAIN)
fun onGetMessage(message: MessageJianKongBean) {
     if(plantAreaType=="Village"){
         pageNo=1
         plantAreaAllTypeId=message.plantAreaAllTypeId
         online=message.isOnline
         troubleIs=message.isTroubleIs
         warnIs=message.isWarnIs
         mViewModel.wuShuiQueryWithOnlineAndWarnByUser(
             pageNo,
             plantAreaType,
             plantAreaAllTypeId,
             online,
             troubleIs,
             warnIs
         )
     }
}
    override fun setListener() {
        binding?.mySmartRefreshLayout?.setOnRefreshListener {
             pageNo=1
            if(plantAreaType == "Town"){//镇级
                mViewModel.wuShuiQueryWithOnlineAndWarnByUser(pageNo, plantAreaType)
            }else{//村级
                mViewModel.wuShuiQueryWithOnlineAndWarnByUser(
                    pageNo,
                    plantAreaType,
                    plantAreaAllTypeId,
                    online,
                    troubleIs,
                    warnIs
                )
            }
        }
        binding?.mySmartRefreshLayout?.setOnLoadMoreListener {
            pageNo++
            if(plantAreaType == "Town"){//镇级
                mViewModel.wuShuiQueryWithOnlineAndWarnByUser(pageNo, plantAreaType)
            }else{//村级
                mViewModel.wuShuiQueryWithOnlineAndWarnByUser(
                    pageNo,
                    plantAreaType,
                    plantAreaAllTypeId,
                    online,
                    troubleIs,
                    warnIs
                )
            }

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

    override fun observe() {
        mViewModel.wuShuiQueryWithOnlineAndWarnByUserState.observe(
            this,
            Observer<WuShuiQueryWithOnlineAndWarnByUserBean> {
                if (it.current == 1) {
                    myAdapter?.setNewData(it?.records as MutableList<Record1>?)
                    binding?.mySmartRefreshLayout?.finishRefresh()
                } else {
                    it?.records?.let { it1 -> myAdapter?.addData(it1) }
                }
                if (pageNo == it.pages) {
                    binding?.mySmartRefreshLayout?.finishLoadMoreWithNoMoreData()
                } else {
                    binding?.mySmartRefreshLayout?.finishLoadMore()
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }
}