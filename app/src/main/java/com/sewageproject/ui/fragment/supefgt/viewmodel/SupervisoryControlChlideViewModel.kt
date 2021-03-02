package com.sewageproject.ui.fragment.supefgt.viewmodel
import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import com.sewageproject.ui.fragment.bean.WuShuiQueryWithOnlineAndWarnByUserBean
class SupervisoryControlChlideViewModel : BaseViewModel() {
    private val SupervisoryControlChlide by lazy { RetrofitClient.getApiService() }
     val wuShuiQueryWithOnlineAndWarnByUserState = MutableLiveData<WuShuiQueryWithOnlineAndWarnByUserBean>()
    /**
     * 监控 带在线状态,报警数跟告警数)(权限)（监控-》镇级和村级）
     * plantAreaAllTypeId 站点类型id
     * online 是否在线
     * troubleIs 是否报障中
     * warnIs 是否告警中
     */
    fun wuShuiQueryWithOnlineAndWarnByUser(pageNo: Int,plantAreaType:String, plantAreaAllTypeId: String, online: Boolean, troubleIs: Boolean, warnIs: Boolean) {
        launch(
                block = {
                    wuShuiQueryWithOnlineAndWarnByUserState.value= SupervisoryControlChlide.wuShuiQueryWithOnlineAndWarnByUser("10",
                            pageNo.toString(),plantAreaType, plantAreaAllTypeId, online, troubleIs, warnIs).result()
                })
    }
    fun wuShuiQueryWithOnlineAndWarnByUser(pageNo: Int, plantAreaType: String) {
        launch(
                block = {
                    wuShuiQueryWithOnlineAndWarnByUserState.value= SupervisoryControlChlide.wuShuiQueryWithOnlineAndWarnByUser("10",
                            pageNo.toString(), plantAreaType).result()
                })
    }
}