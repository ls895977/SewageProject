package com.sewageproject.ui.fragment.work.activity

import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivityEdittroublelistBinding
import com.sewageproject.ui.fragment.work.model.EditTroubleListViewModel

/**
 * 编辑报障单
 */
class EditTroubleListActivity :
    BaseVmActivity<ActivityEdittroublelistBinding, EditTroubleListViewModel>() {
    override fun viewModelClass(): Class<EditTroubleListViewModel> =
        EditTroubleListViewModel::class.java

    override fun getViewBinding(): ActivityEdittroublelistBinding {
        return ActivityEdittroublelistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        mBinding.myTitleBar.tvTitle.text = "编辑报障"
    }
}