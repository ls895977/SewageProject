package com.sewageproject.ui.popup

import android.content.Context
import android.view.View
import android.widget.TextView
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter
import com.contrarywind.view.WheelView
import com.lxj.xpopup.core.BottomPopupView
import com.sewageproject.R

/**
 * 选择
 */
class ChoseUserBottomPopup(context: Context) : BottomPopupView(context) {

    override fun getImplLayoutId(): Int {
        return R.layout.choseuserbottompopup
    }
    private var myWheelView: WheelView?=null
    private var menu:MutableList<String>?= ArrayList()
    override fun initPopupContent() {
        super.initPopupContent()
        myWheelView=findViewById(R.id.myWheelView)
        findViewById<TextView>(R.id.tvCancel).setOnClickListener { dismiss() }
        findViewById<TextView>(R.id.tvMyCenter).setOnClickListener {
            dismiss()
        }
        menu?.add("不指定")
        menu?.add("用户名称")
        menu?.add("用户名称")
        myWheelView?.setTextColorCenter(context.resources.getColor(R.color.text_color_333))
        myWheelView?.adapter = ArrayWheelAdapter(menu)
    }
}