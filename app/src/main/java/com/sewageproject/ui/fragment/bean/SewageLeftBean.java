package com.sewageproject.ui.fragment.bean;

public class SewageLeftBean {
    private String SewageLeftName;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSewageLeftName() {
        return SewageLeftName;
    }

    public SewageLeftBean(String sewageLeftName) {
        SewageLeftName = sewageLeftName;
    }

    public void setSewageLeftName(String sewageLeftName) {
        SewageLeftName = sewageLeftName;
    }
}
