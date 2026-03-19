package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientSampleTaskDataRecord extends ClientSampleTaskData implements Serializable {
    private String appealDeadline;
    private Integer arbitrationRecordsId;
    private Integer arbitrationStatus;
    private Integer buttonState;
    private Boolean canAppeal;
    private Boolean canArbitration;
    private Integer recordStatus;
    private String recordTime;
    private String showExpectedAuditingTime;
    private Integer submitRecordId;
    private String taskDataReviewFailureReason;

    public Integer getRecordStatus() {
        return this.recordStatus;
    }

    public void setRecordStatus(Integer num) {
        this.recordStatus = num;
    }

    public String getTaskDataReviewFailureReason() {
        return this.taskDataReviewFailureReason;
    }

    public void setTaskDataReviewFailureReason(String str) {
        this.taskDataReviewFailureReason = str;
    }

    public String getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    public String getShowExpectedAuditingTime() {
        return this.showExpectedAuditingTime;
    }

    public void setShowExpectedAuditingTime(String str) {
        this.showExpectedAuditingTime = str;
    }

    public void setSubmitRecordId(Integer num) {
        this.submitRecordId = num;
    }

    public Integer getSubmitRecordId() {
        return this.submitRecordId;
    }

    public Integer getButtonState() {
        return this.buttonState;
    }

    public void setButtonState(Integer num) {
        this.buttonState = num;
    }

    public Boolean getCanAppeal() {
        return this.canAppeal;
    }

    public void setCanAppeal(Boolean bool) {
        this.canAppeal = bool;
    }

    public Boolean getCanArbitration() {
        return this.canArbitration;
    }

    public void setCanArbitration(Boolean bool) {
        this.canArbitration = bool;
    }

    public String getAppealDeadline() {
        return this.appealDeadline;
    }

    public void setAppealDeadline(String str) {
        this.appealDeadline = str;
    }

    public Integer getArbitrationRecordsId() {
        return this.arbitrationRecordsId;
    }

    public void setArbitrationRecordsId(Integer num) {
        this.arbitrationRecordsId = num;
    }

    public Integer getArbitrationStatus() {
        return this.arbitrationStatus;
    }

    public void setArbitrationStatus(Integer num) {
        this.arbitrationStatus = num;
    }
}
