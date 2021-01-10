package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.SewageLeftBean;

import java.util.List;

public class sewageLeftAdapter  extends BaseQuickAdapter<SewageLeftBean, BaseViewHolder> {
    public sewageLeftAdapter(List<SewageLeftBean> dataList1) {
        super(R.layout.item_sewageleft,dataList1);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SewageLeftBean item) {
        viewHolder.setText(R.id.tvLeftTitle,item.getSewageLeftName());
        viewHolder.getView(R.id.tvLeftTitle).setSelected(item.isStatus());
    }
}