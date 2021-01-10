package com.sewageproject.ui.fragment.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.SewageRightBean;
import java.util.List;

public class SewageRightAdapter   extends BaseQuickAdapter<SewageRightBean, BaseViewHolder> {
    public SewageRightAdapter(List<SewageRightBean> dataList1) {
        super(R.layout.item_sewageright,dataList1);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, SewageRightBean item) {
    }
}