package com.sewageproject.ui.fragment.work.activity
import com.sewageproject.base.BaseVmActivity
import com.sewageproject.databinding.ActivitySecuritylistBinding
import com.sewageproject.ui.fragment.work.model.SecurityListViewModel

/**
 * 新增报障单
 */
class SecurityListActivity : BaseVmActivity<ActivitySecuritylistBinding, SecurityListViewModel>() {
    override fun getViewBinding(): ActivitySecuritylistBinding {
        return ActivitySecuritylistBinding.inflate(layoutInflater)
    }

    override fun viewModelClass(): Class<SecurityListViewModel> = SecurityListViewModel::class.java

    override fun initView() {

    }

    override fun initData() {

    }


}