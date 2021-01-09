package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.SewageListBean;
import com.sewageproject.ui.fragment.bean.SupervisoryControlBean;

import java.util.List;

public class SupervisoryControlAdapter  extends BaseQuickAdapter<SupervisoryControlBean, BaseViewHolder> {
    private List<SupervisoryControlBean> dataList;
    public SupervisoryControlAdapter(List<SupervisoryControlBean> dataList1) {
        super(R.layout.item_supervisorycontrol,dataList1);
        dataList=dataList1;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SupervisoryControlBean item) {

    }
}