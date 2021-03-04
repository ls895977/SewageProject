package com.sewageproject.ui.fragment.viewmodel
import androidx.lifecycle.MutableLiveData
import com.sewageproject.base.BaseViewModel
import com.sewageproject.net.http.RetrofitClient
import com.sewageproject.ui.fragment.bean.PatPlantAreaAllTypeListBean
class SupervisoryControlViewModel :BaseViewModel() {
    private val supervisoryControlSerVice by lazy { RetrofitClient.getApiService() }
     val  supervisoryControlState = MutableLiveData<Boolean>()
     val supervisoryControlSerViceState = MutableLiveData<PatPlantAreaAllTypeListBean>()
    fun patPlantAreaAllTypeList(){
        launch(
                block = {
                val bean=    supervisoryControlSerVice.patPlantAreaAllTypeList("1000","1")
                    supervisoryControlSerViceState
                            .value= bean.result()
                    supervisoryControlState.value=bean.success()
                },
                error = {
                    supervisoryControlState.value=false
                },
                cancel = {
                    supervisoryControlState.value=false
                },
                showErrorToast = false
        )
    }
}