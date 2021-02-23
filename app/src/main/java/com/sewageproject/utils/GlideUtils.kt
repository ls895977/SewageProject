package com.sewageproject.utils
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sewageproject.R
 object  GlideUtils {

    var headerOption= RequestOptions()
        .error(R.mipmap.ic_heard)
    fun headPortrait(context: Context, imView:ImageView, url:String){
        Glide.with(context)
            .applyDefaultRequestOptions(headerOption)
            .load(url)
            .into(imView)
    }

}