package com.sewageproject.ui.popup

import android.content.Context
import android.view.View
import android.widget.TextView
import com.lxj.xpopup.core.DrawerPopupView
import com.sewageproject.R
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 * 我的巡检筛选
 */
class MyPatrolPopupView(context: Context) : DrawerPopupView(context)  {
    override fun getImplLayoutId(): Int {
        return R.layout.mypatrolpopupview
    }
    private var myXJYFlowLayout: TagFlowLayout?=null
    private var myWZFlowLayout: TagFlowLayout?=null
    private var xunJianData:MutableList<String> = ArrayList()
    private var myWZData:MutableList<String> = ArrayList()
    override fun initPopupContent() {
        super.initPopupContent()
        myXJYFlowLayout=findViewById(R.id.myXJYFlowLayout)
        myWZFlowLayout=findViewById(R.id.myWZFlowLayout)
        xunJianData.add("用户名")
        xunJianData.add("用户名")
        xunJianData.add("用户名")
        xunJianData.add("用户名")
        xunJianData.add("用户名")
        myXJYFlowLayout?.adapter=xunJianAdapter
        myWZData.add("未完成")
        myWZData.add("已完成")
        myWZFlowLayout?.adapter=myWZAdapter
    }
    var xunJianAdapter= object : TagAdapter<String?>(xunJianData as List<String?>?) {
        override fun getView(parent: FlowLayout?, position: Int, s: String?): View {
            val tv =inflate(context,R.layout.item_zhandian,null)
            val textView: TextView =tv.findViewById(R.id.tvTitle);
            textView.text =s
            return tv
        }
        override fun unSelected(position: Int, view: View?) {
            val textView: TextView? =view?.findViewById(R.id.tvTitle)
            textView?.isSelected=false
        }

        override fun onSelected(position: Int, view: View?) {
            val textView: TextView? =view?.findViewById(R.id.tvTitle)
            textView?.isSelected=true
        }
    }

    var myWZAdapter= object : TagAdapter<String?>(myWZData as List<String?>?) {
        override fun getView(parent: FlowLayout?, position: Int, s: String?): View {
            val tv =inflate(context,R.layout.item_zhandian,null)
            val textView: TextView =tv.findViewById(R.id.tvTitle);
            textView.text =s
            return tv
        }
        override fun unSelected(position: Int, view: View?) {
            val textView: TextView? =view?.findViewById(R.id.tvTitle)
            textView?.isSelected=false
        }

        override fun onSelected(position: Int, view: View?) {
            val textView: TextView? =view?.findViewById(R.id.tvTitle)
            textView?.isSelected=true
        }
    }
}