package com.sewageproject.ui.fragment.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.WorkbenchBean;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WorkbenchAdapter  extends BaseQuickAdapter<WorkbenchBean, BaseViewHolder> {
    public WorkbenchAdapter(List<WorkbenchBean> dataList1) {
        super(R.layout.item_workbench,dataList1);
    }
    @Override
    protected void convert(BaseViewHolder viewHolder, WorkbenchBean item) {
        viewHolder.setText(R.id.tvTitle,item.getTitle());
        RecyclerView myRecyclerView=viewHolder.getView(R.id.workChildRecyclerView);
        myRecyclerView.setAdapter(new WorkBenchChildAdapter(item.getWorkList()));
    }
}