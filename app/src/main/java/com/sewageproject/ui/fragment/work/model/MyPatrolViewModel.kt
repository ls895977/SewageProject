package com.sewageproject.ui.fragment.work.model
import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import java.util.HashMap
class MyPatrolViewModel:BaseViewModel(){
    private val loginRepository by lazy { RetrofitClient.getApiService() }
    private val myPatrolState = MutableLiveData<Boolean>()

    /**
     * orderYearAndMonth 排班年月
     * staffIds 巡检人员Ids
     */
    fun getMyScheduleForApp(orderYearAndMonth: String, staffIds: String) {
      launch(
            block = {
                val map: MutableMap<String, String> =
                    HashMap()
                map["orderYearAndMonth"] = orderYearAndMonth
                map["staffIds"] = staffIds
                val getMyScheduleForApp = loginRepository.getMyScheduleForApp(toRequestBody(map))
                myPatrolState.value = getMyScheduleForApp.code() == 200
            },
            error = {
                myPatrolState.value = false
            },
            cancel = {

            },
            showErrorToast = false
        )

    }
}