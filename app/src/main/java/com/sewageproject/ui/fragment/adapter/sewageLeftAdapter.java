package com.sewageproject.ui.fragment.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.ui.fragment.bean.Record3;
import java.util.List;
public class sewageLeftAdapter  extends BaseQuickAdapter<Record3, BaseViewHolder> {
    public sewageLeftAdapter(List<Record3> dataList1) {
        super(R.layout.item_sewageleft,dataList1);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Record3 item) {
        viewHolder.setText(R.id.tvLeftTitle,item.getName());
        viewHolder.getView(R.id.tvLeftTitle).setSelected(item.getStatus());
    }
}