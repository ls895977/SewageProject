package com.sewageproject.ui.fragment

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.enums.PopupPosition
import com.sewageproject.R
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.SupervisorycontrolfragmentBinding
import com.sewageproject.ui.fragment.adapter.ExamplePagerAdapter
import com.sewageproject.ui.fragment.supefgt.SupervisoryControlChlideMvpFragment
import com.sewageproject.ui.fragment.viewmodel.SupervisoryControlViewModel
import com.sewageproject.ui.popup.SupervisoryControlPopupView
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView
import java.util.*

/**
 * 监控
 */
class SupervisoryControlMvpFragment :
        BaseVmFragment<SupervisorycontrolfragmentBinding, SupervisoryControlViewModel>() {
    private val mDataList: MutableList<String> =
            ArrayList()
    private val mDataFragment: MutableList<Fragment> =
            ArrayList()

    /**
     * 获取ViewModel的class
     */
    override fun viewModelClass(): Class<SupervisoryControlViewModel> = SupervisoryControlViewModel::class.java

    /**
     * 初始化view相关
     */
    override fun initView() {
    }

    override fun getViewBinding(): SupervisorycontrolfragmentBinding {
        return SupervisorycontrolfragmentBinding.inflate(layoutInflater)
    }

    override fun initData() {
        mDataList.add("镇级")
        mDataList.add("村级")
        SupervisoryControlChlideMvpFragment.newInstance("Town")?.let { mDataFragment.add(it) }
        SupervisoryControlChlideMvpFragment.newInstance("Village")?.let { mDataFragment.add(it) }
        val mExamplePagerAdapter = ExamplePagerAdapter(activity?.supportFragmentManager!!, mDataFragment)
        binding!!.viewPager.adapter = mExamplePagerAdapter
        binding?.viewPager?.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 1) {
                    binding?.ivRight?.visibility = View.VISIBLE
                } else {
                    binding?.ivRight?.visibility = View.GONE
                }
            }
        })
        initMagicIndicator()
    }

    override fun setListener() {
        binding?.ivRight?.setOnClickListener {
            XPopup.Builder(context)
                    .popupPosition(PopupPosition.Right) //右边
                    .hasStatusBarShadow(true) //启用状态栏阴影
                    .asCustom(context?.let { it1 -> SupervisoryControlPopupView(it1) })
                    .show()
        }
    }

    private fun initMagicIndicator() {
        val commonNavigator = CommonNavigator(context)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return mDataList.size
            }

            override fun getTitleView(
                    context: Context,
                    index: Int
            ): IPagerTitleView {
                val badgePagerTitleView = BadgePagerTitleView(context)
                val simplePagerTitleView: SimplePagerTitleView =
                        ColorTransitionPagerTitleView(context)
                simplePagerTitleView.normalColor = resources.getColor(R.color.text_color_999999)
                simplePagerTitleView.selectedColor = resources.getColor(R.color.color_1D7EFF)
                simplePagerTitleView.text = mDataList[index]
                simplePagerTitleView.setOnClickListener { v: View? ->
                    binding!!.viewPager.currentItem = index
                }
                badgePagerTitleView.innerPagerTitleView = simplePagerTitleView
                return badgePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.mode = LinePagerIndicator.MODE_EXACTLY
                linePagerIndicator.lineWidth = UIUtil.dip2px(context, 40.0).toFloat()
                linePagerIndicator.setColors(resources.getColor(R.color.color_1D7EFF))
                linePagerIndicator.lineHeight = UIUtil.dip2px(context, 1.0).toFloat()
                return linePagerIndicator
            }
        }
        binding!!.magicIndicator.navigator = commonNavigator
        val titleContainer = commonNavigator.titleContainer
        titleContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        titleContainer.dividerDrawable = object : ColorDrawable() {
            override fun getIntrinsicWidth(): Int {
                return UIUtil.dip2px(context, 90.0)
            }
        }
        ViewPagerHelper.bind(binding!!.magicIndicator, binding!!.viewPager)
    }
}