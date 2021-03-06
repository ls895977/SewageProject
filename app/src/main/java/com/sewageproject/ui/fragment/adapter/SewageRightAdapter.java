package com.sewageproject.ui.fragment.adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sewageproject.R;
import com.sewageproject.net.http.Api;
import com.sewageproject.ui.fragment.bean.SewageRightBean;
import com.sewageproject.ui.fragment.bean.Video;
import com.sewageproject.utils.GlideUtils;

import java.util.List;

public class SewageRightAdapter   extends BaseQuickAdapter<Video, BaseViewHolder> {
    public SewageRightAdapter(List<Video> dataList1) {
        super(R.layout.item_sewageright,dataList1);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Video item) {
        viewHolder.setText(R.id.tvName,item.getName());
        GlideUtils.INSTANCE.fangImgPortrait(getContext(),viewHolder.getView(R.id.ivVideo), Api.BASE_VidEOURL+item.getUrl());
    }
}