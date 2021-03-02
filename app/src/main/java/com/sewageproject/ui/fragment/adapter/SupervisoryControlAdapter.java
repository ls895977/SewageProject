package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.Record;

import java.util.List;

public class SupervisoryControlAdapter  extends BaseQuickAdapter<Record, BaseViewHolder> {
    private List<Record> dataList;
    public SupervisoryControlAdapter(List<Record> dataList1) {
        super(R.layout.item_supervisorycontrol,dataList1);
        dataList=dataList1;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Record item) {

    }
}