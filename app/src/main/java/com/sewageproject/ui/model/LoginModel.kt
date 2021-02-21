package com.sewageproject.ui.model
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sewageproject.base.BaseModel1
import com.sewageproject.net.TranslateService
import com.sewageproject.net.bean.BaseResult
import com.sewageproject.ui.constant.LoginContract
import kotlinx.coroutines.launch

class LoginModel : BaseModel1(), LoginContract.Model{
    private val dailyWordLiveData: MutableLiveData<Result<BaseResult<String>>> = MutableLiveData()
    /**
     * 账号密码登录
     * @param username 用户名
     * @param password 密码
     */
    override fun sysLogin(username: String, password: String) {
        viewModelScope.launch {
            val result = try {
                // 网络返回成功
                    val hashMap=HashMap<String,String>()
                hashMap["username"] = username
                hashMap["password"] = password
                Result.success(TranslateService.getApi().requestDailyWord(parsJson(hashMap)))
            } catch (e: Exception) {
                // 网络返回失败
                Result.failure(e)
            }
            // 发射数据，之后观察者就会收到数据
            // 注意这里是主线程，直接用setValue()即可
            dailyWordLiveData.value = result
        }
//        dailyWordLiveData.observe(this) { result ->
//            val dailyWordResult = result.getOrNull()
//            if (null == dailyWordResult) {
//                Log.e("aa","-------获取失败")
//                return@observe
//            }
//            Log.e("aa","-------获取成功==="+dailyWordResult.result)
//        }
    }

}