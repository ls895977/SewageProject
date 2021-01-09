package com.sewageproject.ui.fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import com.sewageproject.R;
import com.sewageproject.base.BaseFragment;
import com.sewageproject.databinding.SupervisorycontrolfragmentBinding;
import com.sewageproject.ui.fragment.adapter.ExamplePagerAdapter;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;
import java.util.ArrayList;
import java.util.List;
/**
 * 监控
 */
public class SupervisoryControlFragment extends BaseFragment<SupervisorycontrolfragmentBinding> {
    private List<String> mDataList = new ArrayList<>();
    @Override
    protected boolean statusBarDark() {
        return false;
    }
    @Override
    protected int getResourceId() {
        return R.layout.supervisorycontrolfragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mDataList.add("镇级(11)");
        mDataList.add("村级(30)");
         ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList);
        getBinding().viewPager.setAdapter(mExamplePagerAdapter);
        initMagicIndicator();
    }

    @Override
    protected void initListener() {

    }

    private void initMagicIndicator() {
//        CommonNavigator commonNavigator = new CommonNavigator(getContext());
//        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
//
//            @Override
//            public int getCount() {
//                return mDataList.size();
//            }
//
//            @Override
//            public IPagerTitleView getTitleView(Context context, final int index) {
//                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);
//                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
//                simplePagerTitleView.setNormalColor(Color.GRAY);
//                simplePagerTitleView.setSelectedColor(Color.WHITE);
//                simplePagerTitleView.setText(mDataList.get(index));
//                simplePagerTitleView.setOnClickListener(v -> getBinding().viewPager.setCurrentItem(index));
//                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
//                return badgePagerTitleView;
//            }
//
//            @Override
//            public IPagerIndicator getIndicator(Context context) {
//                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
//                linePagerIndicator.setColors(Color.WHITE);
//                return linePagerIndicator;
//            }
//        });
//        getBinding().magicIndicator.setNavigator(commonNavigator);
//        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
//        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        titleContainer.setDividerDrawable(new ColorDrawable() {
//            @Override
//            public int getIntrinsicWidth() {
//                return UIUtil.dip2px(getContext(), 15);
//            }
//        });
        ViewPagerHelper.bind(getBinding().magicIndicator, getBinding().viewPager);
    }
}
