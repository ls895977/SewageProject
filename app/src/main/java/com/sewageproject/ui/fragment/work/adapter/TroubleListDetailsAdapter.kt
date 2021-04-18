package com.sewageproject.ui.fragment.work.adapter
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sewageproject.R
import com.sewageproject.ui.fragment.work.bean.TroubleListDetailsBean

class TroubleListDetailsAdapter(var myData: MutableList<TroubleListDetailsBean>) :
    BaseQuickAdapter<TroubleListDetailsBean, BaseViewHolder>
        (R.layout.item_troublelistdetails,myData) {
    override fun convert(holder: BaseViewHolder, item: TroubleListDetailsBean) {
        if (holder.adapterPosition == 0) {//第一个
            holder.getView<ConstraintLayout>(R.id.itemTopCLStyle1).visibility= View.VISIBLE
            holder.getView<ConstraintLayout>(R.id.itemCenterStyle2).visibility= View.GONE
            holder.getView<ConstraintLayout>(R.id.itemButStyle3).visibility= View.GONE
            holder.getView<ImageView>(R.id.ivItemTopStyle1).isSelected = true//是否选中
            holder.getView<ImageView>(R.id.ivItemTopStyle2).isSelected = false
            holder.getView<ImageView>(R.id.ivItemTopStyle3).isSelected = false
//            ivItemTopStyleText3
        } else if (holder.adapterPosition == (myData.size - 1)) {//最后一个
            holder.getView<ConstraintLayout>(R.id.itemTopCLStyle1).visibility= View.GONE
            holder.getView<ConstraintLayout>(R.id.itemCenterStyle2).visibility= View.GONE
            holder.getView<ConstraintLayout>(R.id.itemButStyle3).visibility= View.VISIBLE
            holder.getView<ImageView>(R.id.ivItemTopStyle1).isSelected = false
            holder.getView<ImageView>(R.id.ivItemTopStyle2).isSelected = false
            holder.getView<ImageView>(R.id.ivItemTopStyle3).isSelected = true //是否选中
        } else {//中间
            holder.getView<ConstraintLayout>(R.id.itemTopCLStyle1).visibility= View.GONE
            holder.getView<ConstraintLayout>(R.id.itemCenterStyle2).visibility= View.VISIBLE
            holder.getView<ConstraintLayout>(R.id.itemButStyle3).visibility= View.GONE
            holder.getView<ImageView>(R.id.ivItemTopStyle1).isSelected = false
            holder.getView<ImageView>(R.id.ivItemTopStyle2).isSelected = true//是否选中
            holder.getView<ImageView>(R.id.ivItemTopStyle3).isSelected = false
        }

    }
}