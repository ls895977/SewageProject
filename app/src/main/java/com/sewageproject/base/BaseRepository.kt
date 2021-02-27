package com.sewageproject.base

import com.sewageproject.net.http.Api
import com.sewageproject.net.http.RetrofitClient

/**
 * Created by yechaoa on 2020/2/4.
 * Describe :
 */
open class BaseRepository {

    protected fun apiService(): Api {
        return RetrofitClient.getApiService()
    }

}