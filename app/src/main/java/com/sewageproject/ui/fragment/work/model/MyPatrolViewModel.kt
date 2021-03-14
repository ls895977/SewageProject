package com.sewageproject.ui.fragment.work.model
import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import com.sewageproject.ui.fragment.work.bean.MyPatrolBean
import java.util.HashMap
class MyPatrolViewModel:BaseViewModel(){
    private val loginRepository by lazy { RetrofitClient.getApiService() }
     val myPatrolState = MutableLiveData<Boolean>()
    val myPatrolData = MutableLiveData<MyPatrolBean>()
    /**
     * orderYearAndMonth 排班年月
     * staffIds 巡检人员Ids
     */
    fun getMyScheduleForApp(orderYearAndMonth: String, staffIds: String,pageNo:Int) {
      launch(
            block = {
                val getMyScheduleForApp = loginRepository.getMyScheduleForApp(orderYearAndMonth,staffIds,pageNo.toString(),"10")
                myPatrolState.value = getMyScheduleForApp.code() == 200
                myPatrolData.value=getMyScheduleForApp.result()
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