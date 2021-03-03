package com.sewageproject.ui.fragment.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.net.http.Api;
import com.sewageproject.ui.fragment.bean.Record;
import com.sewageproject.ui.fragment.bean.Record1;
import com.sewageproject.utils.GlideUtils;

import java.util.List;

public class SupervisoryControlAdapter  extends BaseQuickAdapter<Record1, BaseViewHolder> {
    private List<Record1> dataList;
    public SupervisoryControlAdapter(List<Record1> dataList1) {
        super(R.layout.item_supervisorycontrol,dataList1);
        dataList=dataList1;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Record1 item) {
        viewHolder.getView(R.id.tvOnline).setSelected(item.getOnline());
        if(item.getOnline()){
            viewHolder.setText(R.id.tvOnline,"在线");
        }else {
            viewHolder.setText(R.id.tvOnline,"离线");
        }
        viewHolder.setText(R.id.tvZDName,item.getName());
        viewHolder.setGone(R.id.tvWarnIs,item.getWarnIs());
        String imgUrl="";
        if(!TextUtils.isEmpty(item.getImgUris())){
            String[] mdd=item.getImgUris().split(",");
            imgUrl=mdd[0];
        }
        GlideUtils.INSTANCE.fangImgPortrait(getContext(),viewHolder.getView(R.id.ivHeader), Api.BASE_IMGURL+ imgUrl);
    }
}