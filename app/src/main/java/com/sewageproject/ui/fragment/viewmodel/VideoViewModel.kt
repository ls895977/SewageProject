package com.sewageproject.ui.fragment.viewmodel
import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import com.sewageproject.ui.fragment.bean.FreshStatusBean
import com.sewageproject.ui.fragment.bean.WuShuiVideoViewListBean

class VideoViewModel : BaseViewModel() {
    private val videoSitory by lazy { RetrofitClient.getApiService() }
    val warnBean = MutableLiveData<WuShuiVideoViewListBean>()
    fun wuShuiVideoViewList(pageNo: String?) {
        val freshStatusBean=FreshStatusBean()
        freshStatusBean.page= pageNo?.toInt()!!
        launch(
            block = {
                val videoData =videoSitory.wuShuiVideoViewList("10000",
                        "0","Town")
                warnBean.value = videoData.result()
            },
            error = {
                freshStatusBean.status=false
            },
            cancel = {

            },
            showErrorToast = false
        )

    }

}