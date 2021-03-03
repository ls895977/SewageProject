package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.Record;
import com.sewageproject.ui.fragment.bean.SewageListBean;

import java.util.List;

public class SewageListAdapter  extends BaseQuickAdapter<Record, BaseViewHolder> {
    public SewageListAdapter(List<Record> dataList1) {
        super(R.layout.item_sewagelist,dataList1);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Record item) {
        if(viewHolder.getAdapterPosition()==getData().size()-1){
            viewHolder.getView(R.id.tvName).setSelected(true);
            viewHolder.getView(R.id.tvZongan).setSelected(true);
        }else {
            viewHolder.getView(R.id.tvName).setSelected(false);
            viewHolder.getView(R.id.tvZongan).setSelected(false);
        }
        viewHolder.setText(R.id.tvName,item.getName());
        viewHolder.setText(R.id.tvChushuiliang,item.getVars().getWaterOut().getOutTodayWater());
        viewHolder.setText(R.id.tvCOD, item.getVars().getWaterOut().getOutCod());
        viewHolder.setText(R.id.tvPH, item.getVars().getWaterOut().getOutPh());
        viewHolder.setText(R.id.tvZonglin, item.getVars().getWaterOut().getOutAllWater());
        viewHolder.setText(R.id.tvZongan, item.getVars().getWaterOut().getOutAp());
    }
}