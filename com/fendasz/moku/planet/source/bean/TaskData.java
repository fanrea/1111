package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskData implements Serializable {
    public static final String CLASSIFY_OF_COMMENT = "comment";
    public static final String CLASSIFY_OF_CPA = "cpa";
    public static final String CLASSIFY_OF_HP = "hp";
    public static final String CLASSIFY_OF_KEYWORD = "keyword";
    public static final String PUT_TYPE_OF_DAILY = "0";
    public static final String PUT_TYPE_OF_HOURLY = "1";
    public static final Integer STATUS_OF_HIDE = 0;
    public static final Integer STATUS_OF_SHOW = 1;
    private String auditKey;
    private String classify;
    private Integer cpaType;
    private String desc;
    private Integer id;
    private Integer index;
    private Boolean isCopy;
    private Integer isSeparateAudit;
    private String key;
    private String mobileBrandFilters;
    private String name;
    private Integer perhourPutNum;
    private Integer putNum;
    private String putType;
    private String remarks;
    private Double rewardMoney;
    private String sdkAppFilters;
    private Integer status;
    private Integer surplusNum;
    private Task task;
    private String taskDataApkAppVersion;
    private String taskDataApkApplicationId;
    private String taskDataApkDownloadType;
    private String taskDataApkDownloadUrl;
    private String taskDataApkMd5;
    private String taskDataApkSize;
    private Integer taskDataApkUsage;
    private List<TaskDataCommentData> taskDataCommentDataList;
    private TaskDataDetail taskDataDetail;
    private Integer taskDataMarket;
    private Integer taskDataMobilePhoneBrand;
    private Integer taskId;
    private String taskName;
    private Integer taskStatus;
    private Integer taskType = 0;
    private Integer timeout;
    private Integer totalSurplusNum;

    public Integer getCpaType() {
        Integer num = this.cpaType;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    public void setCpaType(Integer num) {
        this.cpaType = num;
    }

    public Integer getTaskDataApkUsage() {
        return this.taskDataApkUsage;
    }

    public void setTaskDataApkUsage(Integer num) {
        this.taskDataApkUsage = num;
    }

    public List<TaskDataCommentData> getTaskDataCommentDataList() {
        return this.taskDataCommentDataList;
    }

    public Boolean getCopy() {
        return this.isCopy;
    }

    public void setCopy(Boolean bool) {
        this.isCopy = bool;
    }

    public void setTaskDataCommentDataList(List<TaskDataCommentData> list) {
        this.taskDataCommentDataList = list;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String str) {
        this.taskName = str;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskDataDetail getTaskDataDetail() {
        return this.taskDataDetail;
    }

    public void setTaskDataDetail(TaskDataDetail taskDataDetail) {
        this.taskDataDetail = taskDataDetail;
    }

    public String getAuditKey() {
        return this.auditKey;
    }

    public void setAuditKey(String str) {
        this.auditKey = str;
    }

    public String getClassify() {
        return this.classify;
    }

    public void setClassify(String str) {
        this.classify = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer num) {
        this.index = num;
    }

    public Integer getIsSeparateAudit() {
        return this.isSeparateAudit;
    }

    public void setIsSeparateAudit(Integer num) {
        this.isSeparateAudit = num;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getMobileBrandFilters() {
        return this.mobileBrandFilters;
    }

    public void setMobileBrandFilters(String str) {
        this.mobileBrandFilters = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getPerhourPutNum() {
        return this.perhourPutNum;
    }

    public void setPerhourPutNum(Integer num) {
        this.perhourPutNum = num;
    }

    public Integer getPutNum() {
        return this.putNum;
    }

    public void setPutNum(Integer num) {
        this.putNum = num;
    }

    public String getPutType() {
        return this.putType;
    }

    public void setPutType(String str) {
        this.putType = str;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public Double getRewardMoney() {
        return this.rewardMoney;
    }

    public void setRewardMoney(Double d) {
        this.rewardMoney = d;
    }

    public String getSdkAppFilters() {
        return this.sdkAppFilters;
    }

    public void setSdkAppFilters(String str) {
        this.sdkAppFilters = str;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public Integer getSurplusNum() {
        return this.surplusNum;
    }

    public void setSurplusNum(Integer num) {
        this.surplusNum = num;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public void setTimeout(Integer num) {
        this.timeout = num;
    }

    public Integer getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Integer num) {
        this.taskId = num;
    }

    public Integer getTotalSurplusNum() {
        return this.totalSurplusNum;
    }

    public void setTotalSurplusNum(Integer num) {
        this.totalSurplusNum = num;
    }

    public String getTaskDataApkDownloadType() {
        return this.taskDataApkDownloadType;
    }

    public void setTaskDataApkDownloadType(String str) {
        this.taskDataApkDownloadType = str;
    }

    public String getTaskDataApkDownloadUrl() {
        return this.taskDataApkDownloadUrl;
    }

    public void setTaskDataApkDownloadUrl(String str) {
        this.taskDataApkDownloadUrl = str;
    }

    public String getTaskDataApkSize() {
        return this.taskDataApkSize;
    }

    public void setTaskDataApkSize(String str) {
        this.taskDataApkSize = str;
    }

    public String getTaskDataApkAppVersion() {
        return this.taskDataApkAppVersion;
    }

    public void setTaskDataApkAppVersion(String str) {
        this.taskDataApkAppVersion = str;
    }

    public String getTaskDataApkApplicationId() {
        return this.taskDataApkApplicationId;
    }

    public void setTaskDataApkApplicationId(String str) {
        this.taskDataApkApplicationId = str;
    }

    public String getTaskDataApkMd5() {
        return this.taskDataApkMd5;
    }

    public void setTaskDataApkMd5(String str) {
        this.taskDataApkMd5 = str;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(Integer num) {
        this.taskStatus = num;
    }

    public Integer getTaskDataMarket() {
        return this.taskDataMarket;
    }

    public void setTaskDataMarket(Integer num) {
        this.taskDataMarket = num;
    }

    public Integer getTaskDataMobilePhoneBrand() {
        return this.taskDataMobilePhoneBrand;
    }

    public void setTaskDataMobilePhoneBrand(Integer num) {
        this.taskDataMobilePhoneBrand = num;
    }

    public Integer getTaskType() {
        return this.taskType;
    }

    public void setTaskType(Integer num) {
        this.taskType = num;
    }
}
