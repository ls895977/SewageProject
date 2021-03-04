package com.sewageproject.ui.popup

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lxj.xpopup.core.DrawerPopupView
import com.sewageproject.R
import com.sewageproject.ui.adapter.ZhanDianAdapter
import com.sewageproject.ui.fragment.bean.Record2

class SupervisoryControlPopupView(context: Context,var records: MutableList<Record2>) : DrawerPopupView(context) {
    override fun getImplLayoutId(): Int {
        return R.layout.supervisorycontrolpopupview
    }
    private var myZDRecyclerView: RecyclerView?=null
    private var zhanDianAdapter:ZhanDianAdapter?=null
    override fun onCreate() {
        super.onCreate()
        myZDRecyclerView=findViewById(R.id.myZDRecyclerView)
        val grideManager=GridLayoutManager(context,3)
        myZDRecyclerView?.layoutManager=grideManager
        zhanDianAdapter= ZhanDianAdapter(records)
        myZDRecyclerView?.adapter= zhanDianAdapter
            Log.e("aa","------------records==="+records.size)
        zhanDianAdapter?.setOnItemClickListener { _, _, position ->
            records.forEach {
                it.status=false
            }
            records[position].status=true
            zhanDianAdapter?.notifyDataSetChanged()
        }
    }

}