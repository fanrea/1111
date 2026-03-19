package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDataStep implements Serializable {
    public static final Integer TYPE_OF_EXAMPLE = 1;
    private String additionalContent;
    private Integer id;
    private Integer num;
    private Integer sonNum;
    private String taskDataCustomDesc;
    private String taskDataSampleScreenshotUrl;
    private Integer taskDataStepConfigType;
    private Integer taskDataStepOpeningMode;
    private Integer type;

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public String getTaskDataCustomDesc() {
        return this.taskDataCustomDesc;
    }

    public void setTaskDataCustomDesc(String str) {
        this.taskDataCustomDesc = str;
    }

    public String getTaskDataSampleScreenshotUrl() {
        return this.taskDataSampleScreenshotUrl;
    }

    public void setTaskDataSampleScreenshotUrl(String str) {
        this.taskDataSampleScreenshotUrl = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public boolean isExamplePicStep() {
        return getType() == null || TYPE_OF_EXAMPLE.equals(getType());
    }

    public Integer getTaskDataStepConfigType() {
        return this.taskDataStepConfigType;
    }

    public void setTaskDataStepConfigType(Integer num) {
        this.taskDataStepConfigType = num;
    }

    public Integer getTaskDataStepOpeningMode() {
        return this.taskDataStepOpeningMode;
    }

    public void setTaskDataStepOpeningMode(Integer num) {
        this.taskDataStepOpeningMode = num;
    }

    public String getAdditionalContent() {
        return this.additionalContent;
    }

    public void setAdditionalContent(String str) {
        this.additionalContent = str;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSonNum() {
        return this.sonNum;
    }

    public void setSonNum(Integer num) {
        this.sonNum = num;
    }
}
