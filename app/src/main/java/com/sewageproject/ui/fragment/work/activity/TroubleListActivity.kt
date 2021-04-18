package com.sewageproject.ui.fragment.work.activity

import com.lxj.xpopup.XPopup
import com.lxj.xpopup.enums.PopupPosition
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivityTroublelistBinding
import com.sewageproject.ui.fragment.bean.Record2
import com.sewageproject.ui.fragment.bean.TroubleListBean
import com.sewageproject.ui.fragment.work.adapter.TroubleListAdapter
import com.sewageproject.ui.fragment.work.model.TroubleListModelView
import com.sewageproject.ui.message.MessageJianKongBean
import com.sewageproject.ui.popup.ApplicationFormPopupView
import com.sewageproject.ui.popup.ChoseUserBottomPopup
import com.sewageproject.ui.popup.SupervisoryControlPopupView
import com.sewageproject.utils.ActStartUtils
import org.greenrobot.eventbus.EventBus

/**
 * 报障单
 */
class TroubleListActivity : BaseVmActivity<ActivityTroublelistBinding, TroubleListModelView>() {
    override fun viewModelClass(): Class<TroubleListModelView> = TroubleListModelView::class.java

    override fun getViewBinding(): ActivityTroublelistBinding {
        return ActivityTroublelistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.leftBack.setOnClickListener { finish() }
    }

    private var myAdapter: TroubleListAdapter? = null
    var records: MutableList<Record2> = ArrayList()
    private  var choseZDHahsMap: Set<Int> =HashSet()
    private  var choseZXHahsMap: Set<Int> =HashSet()
    override fun initData() {
        myAdapter = TroubleListAdapter()
        mBinding.myPatrolRecyclerView.adapter = myAdapter
        val myData: MutableList<TroubleListBean> = ArrayList()
        for (i in 0..10) {
            myData.add(TroubleListBean())
        }
        myAdapter?.setNewData(myData)


    }

    override fun setListener() {
        mBinding.newWeiYangDan.setOnClickListener { //生成维养单
            XPopup.Builder(this)
                .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                .enableDrag(true)
                .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                .asCustom(ChoseUserBottomPopup(this) /*.enableDrag(false)*/)
                .show()
        }
        mBinding.SHTGBut.setOnClickListener { //新增报障单

        }
        myAdapter?.setOnItemClickListener { adapter, view, position ->
            ActStartUtils.startAct(this, TroubleListDetailsActivity::class.java)
        }
        mBinding.ivRight.setOnClickListener { //筛选
            XPopup.Builder(this)
                .popupPosition(PopupPosition.Right) //右边
                .asCustom(this.let { it1 ->
                    ApplicationFormPopupView(it1,
                        records,
                        choseZDHahsMap,
                        choseZXHahsMap,
                        object : ApplicationFormPopupView.onSelecteSetMap {
                            override fun onSelectedSet(
                                menu1: Set<Int>,
                                menu2: Set<Int> ) {
                                choseZDHahsMap = menu1
                                choseZXHahsMap = menu2
                            }
                        })
                })
                .show()
        }
    }

    override fun observe() {


    }
}