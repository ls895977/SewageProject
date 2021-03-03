package com.sewageproject.ui.popup

import android.content.Context
import com.lxj.xpopup.core.DrawerPopupView
import com.sewageproject.R

 class SupervisoryControlPopupView(context: Context) : DrawerPopupView(context) {
    override fun getImplLayoutId(): Int {
        return R.layout.supervisorycontrolpopupview
    }


}