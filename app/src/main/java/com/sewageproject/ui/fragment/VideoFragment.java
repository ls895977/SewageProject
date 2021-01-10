package com.sewageproject.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.sewageproject.R;
import com.sewageproject.base.BaseFragment;
import com.sewageproject.databinding.VideofragmentBinding;
import com.sewageproject.ui.fragment.adapter.SewageRightAdapter;
import com.sewageproject.ui.fragment.adapter.sewageLeftAdapter;
import com.sewageproject.ui.fragment.bean.SewageLeftBean;
import com.sewageproject.ui.fragment.bean.SewageRightBean;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频
 */
public class VideoFragment extends BaseFragment<VideofragmentBinding> {
    final String urlAD = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4";
    @Override
    protected boolean statusBarDark() {
        return false;
    }
    @Override
    protected int getResourceId() {
        return R.layout.videofragment;
    }

    @Override
    protected void initView() {

    }
    List<SewageLeftBean> dataList1;
    sewageLeftAdapter sewageLeftAdapter;
    @Override
    protected void initData() {
        getBinding().detailPlayer.setUpLazy(urlAD, true, null, null, "这是title");
//增加title
        getBinding().detailPlayer.getTitleTextView().setVisibility(View.GONE);
//设置返回键
        getBinding().detailPlayer.getBackButton().setVisibility(View.GONE);
//设置全屏按键功能
        getBinding().detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBinding().detailPlayer.startWindowFullscreen(getContext(), false, true);
            }
        });
//是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        getBinding().detailPlayer.setAutoFullWithSize(true);
//音频焦点冲突时是否释放
        getBinding().detailPlayer.setReleaseWhenLossAudio(false);
//全屏动画
        getBinding().detailPlayer.setShowFullAnimation(true);
//小屏时不触摸滑动
        getBinding().detailPlayer.setIsTouchWiget(false);
       dataList1 =new ArrayList<>();
        dataList1.add(new SewageLeftBean("全部"));
        dataList1.add(new SewageLeftBean("站点1"));
        dataList1.add(new SewageLeftBean("站点2"));
        dataList1.add(new SewageLeftBean("站点3"));
        dataList1.get(0).setStatus(true);
         sewageLeftAdapter=  new sewageLeftAdapter(dataList1);
        getBinding().sewageLeftRecyclerView.setAdapter(sewageLeftAdapter);
        sewageLeftAdapter.setOnItemClickListener((adapter, view, position) -> {
            dataList1.get(position).setStatus(true);
            dataList1.get(postion).setStatus(false);
            postion=position;
            sewageLeftAdapter.notifyDataSetChanged();
        });
        List<SewageRightBean> sewageRightData=new ArrayList<>();
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        sewageRightData.add(new SewageRightBean());
        getBinding().sewageRightRecyclerView.setAdapter(new SewageRightAdapter(sewageRightData));
    }
    int postion=0;
    @Override
    protected void initListener() {

    }

}
