package com.sewageproject.ui.fragment.adapter;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.WaterDataBean;

import java.util.List;

public class WaterDataAdapter extends BaseQuickAdapter<WaterDataBean, BaseViewHolder> {
    public WaterDataAdapter(List<WaterDataBean> dataList) {
        super(R.layout.item_waterdata,dataList);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, WaterDataBean item) {
        TextView tvNumType= viewHolder.getView(R.id.tvNumType);
        tvNumType.setText(item.getNumType());
        viewHolder.setText(R.id.tvNumTitle,item.getNumTitle());
        switch (viewHolder.getAdapterPosition()){
            case 0:
                tvNumType.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_16D462));
                break;
            case 1:
            case 4:
                tvNumType.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_FF9415));
                break;
            case 2:
            case 5:
                tvNumType.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_FF4B4B));
                break;
            default:
                tvNumType.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_333333));
                break;
        }
    }
}