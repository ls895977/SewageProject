package com.sewageproject.ui.constant;

import com.sewageproject.base.BaseView;

public interface MainContract {
    interface View extends BaseView {
        void teenSuccess(String status);
        void onError(String msg);
    }
}
