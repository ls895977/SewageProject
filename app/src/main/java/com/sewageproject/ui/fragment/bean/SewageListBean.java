package com.sewageproject.ui.fragment.bean;

public class SewageListBean {
    private String tvName;
    private String Chushuiliang;
    private String COD;
    private String PH;
    private String zonglin;
    private String zongan;

    public SewageListBean(String tvName, String chushuiliang, String COD, String PH, String zonglin, String zongan) {
        this.tvName = tvName;
        Chushuiliang = chushuiliang;
        this.COD = COD;
        this.PH = PH;
        this.zonglin = zonglin;
        this.zongan = zongan;
    }
    public SewageListBean(){}
    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getChushuiliang() {
        return Chushuiliang;
    }

    public void setChushuiliang(String chushuiliang) {
        Chushuiliang = chushuiliang;
    }

    public String getCOD() {
        return COD;
    }

    public void setCOD(String COD) {
        this.COD = COD;
    }

    public String getPH() {
        return PH;
    }

    public void setPH(String PH) {
        this.PH = PH;
    }

    public String getZonglin() {
        return zonglin;
    }

    public void setZonglin(String zonglin) {
        this.zonglin = zonglin;
    }

    public String getZongan() {
        return zongan;
    }

    public void setZongan(String zongan) {
        this.zongan = zongan;
    }
}
