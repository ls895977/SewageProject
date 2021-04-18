package com.sewageproject.ui.fragment.work.activity

import com.lxj.xpopup.XPopup
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivityTroublelistdetailsBinding
import com.sewageproject.ui.fragment.work.adapter.TroubleListDetailsAdapter
import com.sewageproject.ui.fragment.work.bean.TroubleListDetailsBean
import com.sewageproject.ui.fragment.work.model.TroubleListDetailsViewModel
import com.sewageproject.ui.popup.ChoseUserBottomPopup
import com.sewageproject.utils.ActStartUtils

/**
 * 报障单详情
 */
class TroubleListDetailsActivity :
    BaseVmActivity<ActivityTroublelistdetailsBinding, TroubleListDetailsViewModel>() {
    override fun viewModelClass(): Class<TroubleListDetailsViewModel> =
        TroubleListDetailsViewModel::class.java

    override fun getViewBinding(): ActivityTroublelistdetailsBinding {
        return ActivityTroublelistdetailsBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.myTitleBar.tvTitle.text = "报障详情"
    }

    private var myAdapter: TroubleListDetailsAdapter? = null
    private var myData: MutableList<TroubleListDetailsBean> = ArrayList()
    override fun initData() {
        for (i in 0..3) {
            myData.add(TroubleListDetailsBean())
        }
        myAdapter = TroubleListDetailsAdapter(myData)
        mBinding.myRecyclerView.adapter = myAdapter
    }

    override fun setListener() {
        mBinding.myTitleBar.leftBack.setOnClickListener { finish() }
        mBinding.tvDelete.setOnClickListener { //删除

        }
        mBinding.tvEdit.setOnClickListener { //编辑
            ActStartUtils.startAct(this, EditTroubleListActivity::class.java)
        }
        mBinding.newWeiYangDan.setOnClickListener { //生成维养单
            XPopup.Builder(this)
                .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                .enableDrag(true)
                .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                .asCustom(ChoseUserBottomPopup(this) /*.enableDrag(false)*/)
                .show()
        }
        mBinding.SHTGBut.setOnClickListener { //审核

        }
    }
}