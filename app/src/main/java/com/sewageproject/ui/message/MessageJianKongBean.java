package com.sewageproject.ui.message;

public class MessageJianKongBean {
    private String plantAreaAllTypeId;
    private boolean online;
    private boolean troubleIs;
    private boolean warnIs;

    public MessageJianKongBean(String plantAreaAllTypeId, boolean online, boolean troubleIs, boolean warnIs) {
        this.plantAreaAllTypeId = plantAreaAllTypeId;
        this.online = online;
        this.troubleIs = troubleIs;
        this.warnIs = warnIs;
    }

    public String getPlantAreaAllTypeId() {
        return plantAreaAllTypeId;
    }

    public void setPlantAreaAllTypeId(String plantAreaAllTypeId) {
        this.plantAreaAllTypeId = plantAreaAllTypeId;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isTroubleIs() {
        return troubleIs;
    }

    public void setTroubleIs(boolean troubleIs) {
        this.troubleIs = troubleIs;
    }

    public boolean isWarnIs() {
        return warnIs;
    }

    public void setWarnIs(boolean warnIs) {
        this.warnIs = warnIs;
    }
}
