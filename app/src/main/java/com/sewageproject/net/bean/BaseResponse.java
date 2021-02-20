package com.sewageproject.net.bean;

import android.text.TextUtils;
import com.sewageproject.utils.StringUtils;
import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private final static int STATUS_SUCCEED = 0;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private int code;

    private int status;

    private T result;

    private String message;

    public BaseResponse() {
    }

    public boolean isSucceed() {
        return status == STATUS_SUCCEED;
    }

    public boolean tokenExpire() {
        return status == 401 || status == 301002 || status == 301003 || status == 301004 || status == 301005;
//        return code == 301004;//token无效
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRealMsg() {
        if (!TextUtils.isEmpty(message))
            return StringUtils.strNoNull(message);
        else
            return "";

    }
}
