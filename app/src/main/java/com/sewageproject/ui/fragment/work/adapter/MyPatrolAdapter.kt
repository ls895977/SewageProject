package com.sewageproject.ui.fragment.work.adapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sewageproject.R
import com.sewageproject.ui.fragment.work.bean.Data
import com.sewageproject.view.CircularProgressView

class MyPatrolAdapter(dataList: MutableList<Data>?): BaseQuickAdapter<Data, BaseViewHolder>(R.layout.item_mypatrol,dataList) {
    override fun convert(holder: BaseViewHolder, item: Data) {
        val myProgress=holder.getView<CircularProgressView>(R.id.guZhangBar)
         myProgress.progress=item.getCompleteRate()
          holder.setText(R.id.tvProgress,item.getCompleteRate().toString()+"%")
          holder.setText(R.id.tvZDName,item.pathName)
                  .setText(R.id.tvZhouQi,"周期："+item.periodMsg)
                  .setText(R.id.tvXunJianName,item.inspectionStaffName)
    }
}