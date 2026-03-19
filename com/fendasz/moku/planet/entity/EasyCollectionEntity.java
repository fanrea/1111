package com.fendasz.moku.planet.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EasyCollectionEntity {
    public static final int MONITORMETHOD_APP = 1;
    public static final int MONITORMETHOD_H5 = 0;
    private Integer browseTime;
    private Integer clickNumber;
    private Integer id;
    private Integer monitorMethod;
    private String showUrl;
    private String taskDataApplicationId;
    private String taskDataKey;
    private Integer taskId;

    public Integer getBrowseTime() {
        return this.browseTime;
    }

    public void setBrowseTime(Integer num) {
        this.browseTime = num;
    }

    public String getTaskDataKey() {
        return this.taskDataKey;
    }

    public void setTaskDataKey(String str) {
        this.taskDataKey = str;
    }

    public Integer getClickNumber() {
        return this.clickNumber;
    }

    public void setClickNumber(Integer num) {
        this.clickNumber = num;
    }

    public Integer getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Integer num) {
        this.taskId = num;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public void setShowUrl(String str) {
        this.showUrl = str;
    }

    public Integer getMonitorMethod() {
        Integer num = this.monitorMethod;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setMonitorMethod(Integer num) {
        this.monitorMethod = num;
    }

    public String getTaskDataApplicationId() {
        return this.taskDataApplicationId;
    }

    public void setTaskDataApplicationId(String str) {
        this.taskDataApplicationId = str;
    }
}
