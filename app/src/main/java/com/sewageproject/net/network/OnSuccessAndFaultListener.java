package com.sewageproject.net.network;

/**
 * Created by wjw on 2018/3/27.
 */
public interface OnSuccessAndFaultListener {
    void onSuccess(String result);

    void onFault(String errorMsg);
}
