package com.sewageproject.ui.fragment.work.activity
import android.graphics.Color
import android.view.Gravity
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.view.TimePickerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.enums.PopupPosition
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.sewageproject.R
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.MypatrolactivityBinding
import com.sewageproject.ui.fragment.work.adapter.MyPatrolAdapter
import com.sewageproject.ui.fragment.work.model.MyPatrolViewModel
import com.sewageproject.ui.popup.MyPatrolPopupView
import com.sewageproject.utils.ActStartUtils
import com.sewageproject.utils.MyTimeUtils
import com.yechaoa.yutilskt.YUtils
import java.util.*

/**
 * 我的巡检
 */
class MyPatrolActivity : BaseVmActivity<MypatrolactivityBinding, MyPatrolViewModel>() {
    override fun viewModelClass(): Class<MyPatrolViewModel> = MyPatrolViewModel::class.java
    override fun getViewBinding(): MypatrolactivityBinding {
        return MypatrolactivityBinding.inflate(layoutInflater)
    }
    var pvTime: TimePickerView? = null
    private var myReyclerView: RecyclerView?=null
    override fun initView() {
        initTime()
        myReyclerView=findViewById(R.id.myPatrolRecyclerView)
    }
    private var myPatrolAdapter: MyPatrolAdapter?=null
    override fun initData() {
        mBinding.mySmartRefreshLayout.autoRefresh()
        myPatrolAdapter=MyPatrolAdapter(null)
        mBinding.myPatrolRecyclerView.adapter=myPatrolAdapter
        mBinding.tvTime.text=MyTimeUtils.getYerMoth1()

    }
    private var pageNo=0
    override fun setListener() {
        mBinding.leftBack.setOnClickListener { finish() }
        mBinding.mySmartRefreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                pageNo=0
                mViewModel.getMyScheduleForApp(MyTimeUtils.getYerMoth(),"",pageNo)
            }
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                pageNo++
                mViewModel.getMyScheduleForApp(MyTimeUtils.getYerMoth(),"",pageNo)
            }
        })
        mBinding.clTime.setOnClickListener { //时间选择
            //点击组件的点击事件
            if (pvTime!=null){
                pvTime?.show()
            }
        }
        mBinding.ivRight.setOnClickListener {//筛选
            XPopup.Builder(this)
                .popupPosition(PopupPosition.Right) //右边
                .asCustom(MyPatrolPopupView(this))
                .show()
        }
        myPatrolAdapter?.setOnItemClickListener { adapter, view, position ->
            ActStartUtils.startAct(this, MyInspectionAuditActivity::class.java)
        }
    }
    override fun observe() {
       mViewModel.myPatrolState.observe(this,{
             if(!it){
                 mBinding.mySmartRefreshLayout.finishRefresh()
                 mBinding.mySmartRefreshLayout.finishLoadMore()
             }
           YUtils.hideLoading()
       })
        mViewModel.myPatrolData.observe(this,{
            if(pageNo==it.pageNo){
                mBinding.mySmartRefreshLayout.finishRefresh()
                myPatrolAdapter?.setNewData(it.data)
            }else{
                 if(it.data.size<10){
                     mBinding.mySmartRefreshLayout.finishRefreshWithNoMoreData()
                 }else{
                     mBinding.mySmartRefreshLayout.finishLoadMore()
                 }
                myPatrolAdapter?.addData(it.data)
            }

        })

    }

    /**
     * 初始化时间控件
     */
   private fun initTime(){
        val selectedDate = Calendar.getInstance()
        val startDate = Calendar.getInstance()
        startDate.set(2013, 0, 23);
        val endDate = Calendar.getInstance()
        pvTime = TimePickerBuilder(
            this
        ) { date, v ->
            //选中事件回调
            YUtils.showLoading(this, "筛选中...")
            mBinding.tvTime.text=MyTimeUtils.getTimesYe(date)
            pageNo=0
            mViewModel.getMyScheduleForApp(MyTimeUtils.getTimes(date).toString(),"",pageNo)
        }
            .setType(booleanArrayOf(true, true, true, false, false, false)) // 默认全部显示
            .isCenterLabel(true)
            .setGravity( Gravity.CENTER)
            .setDividerColor(Color.DKGRAY)
            .setContentTextSize(16)//字号
            .setDate(selectedDate)
            .setRangDate(startDate, endDate)
            .setDecorView(null)
            .isCenterLabel(true)
            .build()
    }

}