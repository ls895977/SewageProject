package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.SewageListBean;

import java.util.List;

public class SewageListAdapter  extends BaseQuickAdapter<SewageListBean, BaseViewHolder> {
    private List<SewageListBean> dataList;
    public SewageListAdapter(List<SewageListBean> dataList1) {
        super(R.layout.item_sewagelist,dataList1);
        dataList=dataList1;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SewageListBean item) {
        if(viewHolder.getAdapterPosition()==dataList.size()-1){
            viewHolder.getView(R.id.tvName).setSelected(true);
            viewHolder.getView(R.id.tvZongan).setSelected(true);
        }else {
            viewHolder.getView(R.id.tvName).setSelected(false);
            viewHolder.getView(R.id.tvZongan).setSelected(false);
        }
//        viewHolder.setText(R.id.tvName,item.getTvName());
//        viewHolder.setText(R.id.tvChushuiliang,item.getChushuiliang());
//        viewHolder.setText(R.id.tvCOD,item.getCOD());
//        viewHolder.setText(R.id.tvPH,item.getPH());
//        viewHolder.setText(R.id.tvZonglin,item.getZonglin());
//        viewHolder.setText(R.id.tvZongan,item.getZongan());
    }
}