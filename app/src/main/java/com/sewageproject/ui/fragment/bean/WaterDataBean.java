package com.sewageproject.ui.fragment.bean;

public class WaterDataBean {
    private String numType;

    public WaterDataBean(String numType, String numTitle) {
        this.numType = numType;
        this.numTitle = numTitle;
    }

    public String getNumType() {
        return numType;
    }

    public void setNumType(String numType) {
        this.numType = numType;
    }

    public String getNumTitle() {
        return numTitle;
    }

    public void setNumTitle(String numTitle) {
        this.numTitle = numTitle;
    }

    private String numTitle;
}
