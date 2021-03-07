package com.sewageproject.ui.fragment.work.adapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sewageproject.R
import com.sewageproject.ui.fragment.work.bean.Data
class MyInspectionAuditAdapter (var status:Boolean,var dataList:MutableList<Data>): BaseQuickAdapter<Data, BaseViewHolder>(
    R.layout.myinspectionaudit,dataList) {

    override fun convert(holder: BaseViewHolder, item: Data) {
            holder.setGone(R.id.checkAll,!status)
    }
}