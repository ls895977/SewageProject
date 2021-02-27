package com.sewageproject.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sewageproject.base.BaseViewModel
import com.sewageproject.utils.SPUtils
import com.sewageproject.utils.SpConstant
import com.sewageproject.net.http.RetrofitClient
import java.util.*

class LoginModel : BaseViewModel() {
    private val loginRepository by lazy { RetrofitClient.getApiService() }
    private val myLoginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = myLoginState
    fun login(username: String?, password: String?) {
        val job = launch(
            block = {
                val map: MutableMap<String, String> =
                    HashMap()
                map["username"] = "admin"
                map["password"] = "sytech123"
                val loginData = loginRepository.login(toRequestBody(map))
                loginData.result().userInfo.pwd= password.toString()
                myLoginState.value = loginData.code() == 200
                //保存用户信息
                SPUtils.getInstance().put(SpConstant.USER_INFO, Gson().toJson(loginData.result()))
            },
            error = {
                myLoginState.value = false
            },
            cancel = {

            },
            showErrorToast = false
        )

    }
}