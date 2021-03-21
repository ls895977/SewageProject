package com.sewageproject.ui.fragment.work.activity

import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivityTroublelistBinding
import com.sewageproject.ui.fragment.work.adapter.TroubleListAdapter
import com.sewageproject.ui.fragment.work.model.TroubleListModelView

/**
 * 报障单
 */
class TroubleListActivity:BaseVmActivity<ActivityTroublelistBinding, TroubleListModelView>(){
    override fun viewModelClass(): Class<TroubleListModelView> =TroubleListModelView::class.java

    override fun getViewBinding(): ActivityTroublelistBinding {
        return ActivityTroublelistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.leftBack.setOnClickListener { finish() }
    }
    private var myAdapter: TroubleListAdapter?=null
    override fun initData() {
        myAdapter=TroubleListAdapter()
        mBinding.myPatrolRecyclerView.adapter=myAdapter
    }
    override fun setListener() {


    }

    override fun observe() {



    }
}