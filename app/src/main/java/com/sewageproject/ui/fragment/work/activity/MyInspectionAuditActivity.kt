package com.sewageproject.ui.fragment.work.activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.sewageproject.R
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.MyinspectionauditactivityBinding
import com.sewageproject.ui.fragment.adapter.ExamplePagerAdapter
import com.sewageproject.ui.fragment.work.fgt.MyInspectionAuditFragment
import com.sewageproject.ui.fragment.work.model.MyInspectionAuditViewModel
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
import java.util.ArrayList
/**
 * 我的巡检=>审核
 */
class MyInspectionAuditActivity:
    BaseVmActivity<MyinspectionauditactivityBinding, MyInspectionAuditViewModel>() {
    override fun viewModelClass(): Class<MyInspectionAuditViewModel>
    =MyInspectionAuditViewModel::class.java
    override fun getViewBinding(): MyinspectionauditactivityBinding {
    return MyinspectionauditactivityBinding.inflate(layoutInflater)
    }
    private val mDataList: MutableList<String> =
        ArrayList()
    private val mDataFragment: MutableList<Fragment> =
        ArrayList()
    override fun initView() {mBinding.myTitleBar.tvTitle.text="站点或路线名称" }

    override fun initData() {
        mDataList.add("未审核")
        mDataList.add("审核通过")
        MyInspectionAuditFragment.newInstance("111")?.let { mDataFragment.add(it) }
        MyInspectionAuditFragment.newInstance("222")?.let { mDataFragment.add(it) }
        val myPagerAdapter = ExamplePagerAdapter(
            supportFragmentManager,
            mDataFragment
        )
        mBinding.viewPager.adapter = myPagerAdapter
        initMagicIndicator()
    }

    override fun setListener() {
        mBinding.myTitleBar.leftBack.setOnClickListener {
            finish()
        }
    }
    private fun initMagicIndicator() {
        val commonNavigator = CommonNavigator(this)
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
                    mBinding.viewPager.currentItem = index
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
        mBinding.magicIndicator.navigator = commonNavigator
        val titleContainer = commonNavigator.titleContainer
        titleContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        titleContainer.dividerDrawable = object : ColorDrawable() {
            override fun getIntrinsicWidth(): Int {
                return UIUtil.dip2px(this@MyInspectionAuditActivity, 90.0)
            }
        }
        ViewPagerHelper.bind(mBinding.magicIndicator, mBinding.viewPager)
    }
}