package com.sewageproject.ui.adapter
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sewageproject.R
import com.sewageproject.ui.fragment.bean.Record2
/**
 * Created by hackware on 2016/9/10.
 */
class ZhanDianAdapter( data: MutableList<Record2>) : BaseQuickAdapter<Record2, BaseViewHolder>(R.layout.item_zhandian,data) {

    override fun convert(holder: BaseViewHolder, item: Record2) {
        holder.setText(R.id.tvTitle,item.name)
        holder.getView<View>(R.id.tvTitle).isSelected=item.status
    }

}