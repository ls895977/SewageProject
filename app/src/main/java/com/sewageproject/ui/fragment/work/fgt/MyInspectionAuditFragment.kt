package com.sewageproject.ui.fragment.work.fgt
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sewageproject.base.BaseVmFragment
import com.sewageproject.databinding.MyinspectionauditfragmentBinding
import com.sewageproject.ui.fragment.work.adapter.MyInspectionAuditAdapter
import com.sewageproject.ui.fragment.work.bean.Data
import com.sewageproject.ui.fragment.work.bean.ScheObj
import com.sewageproject.ui.fragment.work.model.MyInspectionAuditModelView
/**
 * 我的巡检=>未审核和审核通过
 */
class MyInspectionAuditFragment:BaseVmFragment<MyinspectionauditfragmentBinding, MyInspectionAuditModelView>() {
    companion object {
        fun newInstance(plantAreaType: String?): Fragment? {
            val args = Bundle()
            args.putString("Title", plantAreaType)
            val fragment = MyInspectionAuditFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun viewModelClass(): Class<MyInspectionAuditModelView> =MyInspectionAuditModelView::class.java
    override fun getViewBinding(): MyinspectionauditfragmentBinding {
        return MyinspectionauditfragmentBinding.inflate(layoutInflater)
    }
    var myAdapter: MyInspectionAuditAdapter?=null
    var mystatus=true
    override fun initView() {
            if(arguments?.getString("Title").equals("111")){
                binding?.clBut?.visibility= View.VISIBLE
                mystatus=true
            }else{
                mystatus=false
                binding?.clBut?.visibility= View.GONE
            }
            val dataList:MutableList<Data> = ArrayList()
        dataList.add(Data("","","","", emptyList()))
        dataList.add(Data("","","","", emptyList()))
            myAdapter=MyInspectionAuditAdapter(mystatus,dataList)
            binding?.myInspectionReyclerView?.adapter=myAdapter
    }

    override fun setListener() {
        binding?.clAllBox?.setOnClickListener {
            binding?.checkAll?.isSelected = binding?.checkAll?.isSelected != true
        }
    }
}