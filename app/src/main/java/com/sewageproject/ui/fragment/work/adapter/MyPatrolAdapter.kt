package com.sewageproject.ui.fragment.work.adapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sewageproject.R
import com.sewageproject.ui.fragment.work.bean.ScheObj

class MyPatrolAdapter(var dataList:MutableList<ScheObj>): BaseQuickAdapter<ScheObj, BaseViewHolder>(R.layout.item_mypatrol,dataList) {

    override fun convert(holder: BaseViewHolder, item: ScheObj) {

        if(item.validStartTime.isNotBlank())
        if(item.oncePerDay){//每天

            }else if(item.twicePerDay){//每天下午

            }else{//其他

            }
    }
}