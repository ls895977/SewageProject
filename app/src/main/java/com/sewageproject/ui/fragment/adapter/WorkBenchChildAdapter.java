package com.sewageproject.ui.fragment.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.WorkbenchBean;
import com.sewageproject.ui.fragment.bean.WorkbenchBean.WorkbenchChlideBean;

import java.util.List;

public class WorkBenchChildAdapter
        extends BaseQuickAdapter<WorkbenchBean.WorkbenchChlideBean, BaseViewHolder> {
    public WorkBenchChildAdapter(List<WorkbenchBean.WorkbenchChlideBean> dataList1) {
        super(R.layout.item_workbenchchild,dataList1);
    }
    @Override
    protected void convert(BaseViewHolder viewHolder, WorkbenchBean.WorkbenchChlideBean item) {
        viewHolder.setText(R.id.icName,item.getName())
 .setBackgroundResource(R.id.icName,item.getIcon());
    }
}
