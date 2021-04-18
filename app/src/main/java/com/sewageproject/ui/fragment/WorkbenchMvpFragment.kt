package com.sewageproject.ui.fragment
import android.view.View
import com.sewageproject.R
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.WorkbenchfragmentBinding
import com.sewageproject.ui.fragment.adapter.WorkbenchAdapter
import com.sewageproject.ui.fragment.bean.WorkbenchBean
import com.sewageproject.ui.fragment.viewmodel.WorkbenchViewModel
import com.sewageproject.ui.fragment.work.activity.MyPatrolActivity
import com.sewageproject.ui.fragment.work.activity.TroubleListActivity
import com.sewageproject.utils.ActStartUtils

/**
 * 工作台
 */
class WorkbenchMvpFragment :
    BaseVmFragment<WorkbenchfragmentBinding, WorkbenchViewModel>() {
    private var workList: MutableList<WorkbenchBean> = ArrayList()
    override fun initView() {
        binding?.workTitle?.leftBack?.visibility = View.GONE
        binding?.workTitle?.tvTitle?.text = "工作台"
        binding?.workTitle?.ivRight?.visibility = View.GONE
    }
    private var myWorkbenchAdapter:WorkbenchAdapter?=null
    override fun initData() {
        val childList: MutableList<WorkbenchBean.WorkbenchChlideBean> = ArrayList()
        childList.add(WorkbenchBean.WorkbenchChlideBean("我的巡检", R.mipmap.btn_wdxj))
        childList.add(WorkbenchBean.WorkbenchChlideBean("巡检点", R.mipmap.btn_xjd))
        childList.add(WorkbenchBean.WorkbenchChlideBean("报障单", R.mipmap.btn_bzd))
        childList.add(WorkbenchBean.WorkbenchChlideBean("新增报障", R.mipmap.btn_xzbz))
        childList.add(WorkbenchBean.WorkbenchChlideBean("维养单", R.mipmap.btn_wyd))
        childList.add(WorkbenchBean.WorkbenchChlideBean("新增维养单", R.mipmap.btn_xzwyd))
        childList.add(WorkbenchBean.WorkbenchChlideBean("设备台账", R.mipmap.btn_sbtz))
        childList.add(WorkbenchBean.WorkbenchChlideBean("知识库", R.mipmap.btn_zsk))
        workList.add(WorkbenchBean("检测报障", childList))
        val childList1: MutableList<WorkbenchBean.WorkbenchChlideBean> = ArrayList()
        childList1.add(WorkbenchBean.WorkbenchChlideBean("取样单", R.mipmap.btn_qyd))
        childList1.add(WorkbenchBean.WorkbenchChlideBean("化验单", R.mipmap.btn_hyd))
        childList1.add(WorkbenchBean.WorkbenchChlideBean("化验日报", R.mipmap.btn_hyrb))
        childList1.add(WorkbenchBean.WorkbenchChlideBean("化验月报", R.mipmap.btn_hyyb))
        childList1.add(WorkbenchBean.WorkbenchChlideBean("化验瓶", R.mipmap.btn_hyp))
        workList.add(WorkbenchBean("取样化验", childList1))
        val childList2: MutableList<WorkbenchBean.WorkbenchChlideBean> = ArrayList()
        childList2.add(WorkbenchBean.WorkbenchChlideBean("出库入库", R.mipmap.btn_ckrk))
        childList2.add(WorkbenchBean.WorkbenchChlideBean("库存盘点", R.mipmap.btn_kcpd))
        childList2.add(WorkbenchBean.WorkbenchChlideBean("即时库存", R.mipmap.btn_jskc))
        childList2.add(WorkbenchBean.WorkbenchChlideBean("购药", R.mipmap.btn_gy))
        childList2.add(WorkbenchBean.WorkbenchChlideBean("用药", R.mipmap.btn_yr))
        childList2.add(WorkbenchBean.WorkbenchChlideBean("药品盘点", R.mipmap.btn_yppd))
        workList.add(WorkbenchBean("物料用药", childList2))
        myWorkbenchAdapter=WorkbenchAdapter(workList)
        binding?.workRecyclerView?.adapter = myWorkbenchAdapter
        myWorkbenchAdapter?.setOnItemClickLinstener { position, childPosition ->
            if(position==0){
                when(childPosition){
                    0->{//我的巡检
                        ActStartUtils.startAct(context, MyPatrolActivity::class.java)
                    }

                    2->{//报障单
                        ActStartUtils.startAct(context, TroubleListActivity::class.java)
                    }

                }
            }

        }
    }

    override fun setListener() {
    }

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<WorkbenchViewModel> = WorkbenchViewModel::class.java

    override fun getViewBinding(): WorkbenchfragmentBinding {
        return WorkbenchfragmentBinding.inflate(layoutInflater)
    }
}