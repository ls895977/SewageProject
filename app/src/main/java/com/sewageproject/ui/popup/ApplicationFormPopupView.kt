package com.sewageproject.ui.popup

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import com.lxj.xpopup.core.DrawerPopupView
import com.sewageproject.R
import com.sewageproject.ui.fragment.bean.Record2
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 * 报障单列表pup
 */
class ApplicationFormPopupView(
    context: Context,
    var records: MutableList<Record2>,
    var choseZDHahsMap: Set<Int>,
    var cholseZXHahsMap: Set<Int>,
    var onselectesetMap: onSelecteSetMap
) : DrawerPopupView(context) {
    override fun getImplLayoutId(): Int {
        return R.layout.applicationformpopupview
    }
    private var myZDflowlayout: TagFlowLayout? = null
    private var myZXflowlayout: TagFlowLayout? = null
    val baoZhangData: MutableList<String> = ArrayList()
    val zaixianData: MutableList<String> = ArrayList()
    private var zdHahsMap: Set<Int> = HashSet()
    private var zxHahsMap: Set<Int> = HashSet()
    override fun onCreate() {
        super.onCreate()
        zdHahsMap = choseZDHahsMap
        zxHahsMap = cholseZXHahsMap
        myZDflowlayout = findViewById(R.id.myZDflowlayout)
        myZXflowlayout = findViewById(R.id.myZXflowlayout)
        myZDflowlayout?.adapter = zdAdapter
        zdAdapter.setSelectedList(zdHahsMap)
        zaixianData.add("待审核")
        zaixianData.add("待维修")
        zaixianData.add("待接单")
        zaixianData.add("维修中")
        zaixianData.add("完成")
        zaixianData.add("委外处理")
        myZXflowlayout?.adapter = zxAdapter
        zxAdapter.setSelectedList(zxHahsMap)
        baoZhangData.add("坐落名称")
        baoZhangData.add("坐落名称")
        myZDflowlayout?.setOnSelectListener {
            zdHahsMap = it
        }
        myZXflowlayout?.setOnSelectListener {
            zxHahsMap = it
        }
        findViewById<View>(R.id.tvChongZhi).setOnClickListener { //重置
            zdHahsMap = HashSet()
            zdAdapter.setSelectedList(zdHahsMap)
            zxHahsMap = HashSet()
            zxAdapter.setSelectedList(zxHahsMap)
        }
        findViewById<View>(R.id.tvCenTer).setOnClickListener { //确定
            dismiss()
            onselectesetMap.onSelectedSet(zdHahsMap, zxHahsMap)
        }
    }

    var zdAdapter = object : TagAdapter<Record2?>(records as List<Record2?>?) {
        override fun getView(parent: FlowLayout?, position: Int, s: Record2?): View {
            val tv = inflate(context, R.layout.item_zhandian, null)
            val textView: TextView = tv.findViewById(R.id.tvTitle);
            textView.text = s?.name
            return tv
        }

        override fun unSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = false
        }

        override fun onSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = true
        }
    }
    var zxAdapter = object : TagAdapter<String?>(zaixianData as List<String?>?) {
        override fun getView(parent: FlowLayout?, position: Int, s: String?): View {
            val tv = inflate(context, R.layout.item_zhandian, null)
            val textView: TextView = tv.findViewById(R.id.tvTitle);
            textView.text = s
            return tv
        }

        override fun unSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = false
        }

        override fun onSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = true
        }
    }

    var bzAdapter = object : TagAdapter<String?>(baoZhangData as List<String?>?) {
        override fun getView(parent: FlowLayout?, position: Int, s: String?): View {
            val tv = inflate(context, R.layout.item_zhandian, null)
            val textView: TextView = tv.findViewById(R.id.tvTitle);
            textView.text = s
            return tv
        }

        override fun unSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = false
        }

        override fun onSelected(position: Int, view: View?) {
            val textView: TextView? = view?.findViewById(R.id.tvTitle)
            textView?.isSelected = true
        }
    }

    interface onSelecteSetMap {
        fun onSelectedSet(menu1: Set<Int>, menu2: Set<Int>)
    }
}