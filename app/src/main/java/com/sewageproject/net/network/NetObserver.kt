package com.tortoise.merchant.network
import com.sewageproject.net.bean.BaseResponse
import io.reactivex.observers.DisposableObserver

/**
 *Created by wanghai
 *Date : 2020/10/23
 *Describe :
 */
abstract class NetObserver<T> : DisposableObserver<BaseResponse<T>>() {

    override fun onNext(t: BaseResponse<T>) {
        if (t.isSuccess) {
            onSuccess(t.data)
        } else {
            onFail(t.code, t.message)
        }
    }

    override fun onError(e: Throwable) {
        onFail(400, e.message ?: "")
    }

    abstract fun onSuccess(t: T?)
    abstract fun onFail(code: Int, msg: String)

    override fun onComplete() {
    }
}