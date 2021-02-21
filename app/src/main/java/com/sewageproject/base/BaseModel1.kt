package com.sewageproject.base
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import kotlin.collections.HashMap

abstract class BaseModel1  : ViewModel(){
    var map: Map<String, String> = HashMap()
    var gson: Gson? = null
    fun parsJson(map: HashMap<String, String>): RequestBody {
        gson = if (gson == null) Gson() else gson
        val json = gson!!.toJson(map)
        Log.e("aa", "------------json==$json")
        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json)
    }

    fun parsObjJson(map: Map<String?, Any?>?): RequestBody {
        gson = if (gson == null) Gson() else gson
        val json = gson!!.toJson(map)
        Log.e("aa", "------------json==$json")
        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json)
    }

    fun parsObjJson(map: Any): RequestBody {
        gson = if (gson == null) Gson() else gson
        val json = gson!!.toJson(map)
        Log.e("aa", "------------json==$json")
        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json)
    }

}