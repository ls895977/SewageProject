package com.sewageproject.ui.fragment.bean

import java.util.*

class WorkbenchBean(
    var title: String,
    var workList: MutableList<WorkbenchChlideBean>
) {

    class WorkbenchChlideBean(var name: String, var icon: Int)

}