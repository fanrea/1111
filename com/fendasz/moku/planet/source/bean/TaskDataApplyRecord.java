package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDataApplyRecord implements Serializable {
    private Integer checkTheState;
    private String expirationTime;
    private Integer id;
    private Integer locationStatus;
    private Integer status;
    private TaskDataCommentData taskDataCommentData;
    private Integer taskDataId;
    private String time;
    public static final Integer STATUS_OF_APPLYING = 0;
    public static final Integer STATUS_OF_COMPLETED = 1;
    public static final Integer STATUS_OF_CANCELLED = -1;
    public static final Integer STATUS_OF_OVERTIME = -2;
    public static final Integer VERIFY_PACKAGE = 1;
    public static final Integer DONT_CHECK = 0;

    public Integer getCheckTheState() {
        return this.checkTheState;
    }

    public void setCheckTheState(Integer num) {
        this.checkTheState = num;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(String str) {
        this.expirationTime = str;
    }

    public TaskDataCommentData getTaskDataCommentData() {
        return this.taskDataCommentData;
    }

    public void setTaskDataCommentData(TaskDataCommentData taskDataCommentData) {
        this.taskDataCommentData = taskDataCommentData;
    }

    public Integer getLocationStatus() {
        Integer num = this.locationStatus;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setLocationStatus(Integer num) {
        this.locationStatus = num;
    }
}
