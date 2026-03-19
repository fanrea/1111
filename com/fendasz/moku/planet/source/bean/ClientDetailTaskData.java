package com.fendasz.moku.planet.source.bean;

import android.text.TextUtils;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientDetailTaskData extends ClientSampleTaskData implements Serializable {
    private String appGalleryName;
    private String appName;
    private Integer browseTime;
    private String classify;
    private List<ClientGroupTaskData> clientGroupTaskDataList;
    private String collectionDataName;
    private String commentKeyword;
    private Integer commentStar;
    private Integer commentType;
    private String cybermoneyName;
    private List<String> formList;
    private String icon;
    private String iconUrl;
    private Map<Integer, List<TaskDataStep>> integerListMap;
    private Integer isCustomDesc;
    private String keyPoint;
    private String keyword;
    private Integer listenerTime;
    private ListeningTimeConfig listeningTimeConfig;
    private List<Integer> questionTypeList;
    private Integer rank;
    private Integer rtaFlag;
    private BigDecimal showMoney;
    private String showName;
    private Integer surplusNum;
    private Integer suspendedSwitch;
    private Task task;
    private TaskData taskData;
    private TaskDataApplyRecord taskDataApplyRecord;
    private Integer taskDataId;

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public boolean isNewTaskGroup() {
        return getTaskDataGroupIsNew() == null || getTaskDataGroupIsNew().booleanValue();
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public boolean isApplyRecordNullOrCanceled() {
        TaskDataApplyRecord taskDataApplyRecord = this.taskDataApplyRecord;
        return taskDataApplyRecord == null || taskDataApplyRecord.getStatus().equals(STATUS_OF_CANCELLED);
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getPackageName() {
        return ("hp".equals(getClassify()) || "cpa".equals(getClassify())) ? getHpTaskPackageName() : getApkApplicationId();
    }

    private String getHpTaskPackageName() {
        return !TextUtils.isEmpty(getTaskData().getTaskDataApkApplicationId()) ? getTaskData().getTaskDataApkApplicationId() : getTask().getApkApplicationId();
    }

    public boolean isRatingTemplate() {
        return this.taskData.getTaskDataDetail().getRatingTemplate() != null && this.taskData.getTaskDataDetail().getRatingTemplate().intValue() == 1;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public boolean isTaskGroup() {
        if (getTaskDataGroupId() != null) {
            return true;
        }
        List<ClientGroupTaskData> list = this.clientGroupTaskDataList;
        return list != null && list.size() > 0;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getCybermoneyName() {
        return this.cybermoneyName;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setCybermoneyName(String str) {
        this.cybermoneyName = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public Integer getSurplusNum() {
        return this.surplusNum;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setSurplusNum(Integer num) {
        this.surplusNum = num;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public TaskDataApplyRecord getTaskDataApplyRecord() {
        return this.taskDataApplyRecord;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setTaskDataApplyRecord(TaskDataApplyRecord taskDataApplyRecord) {
        this.taskDataApplyRecord = taskDataApplyRecord;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskData getTaskData() {
        return this.taskData;
    }

    public void setTaskData(TaskData taskData) {
        this.taskData = taskData;
    }

    public ListeningTimeConfig getListeningTimeConfig() {
        return this.listeningTimeConfig;
    }

    public void setListeningTimeConfig(ListeningTimeConfig listeningTimeConfig) {
        this.listeningTimeConfig = listeningTimeConfig;
    }

    public Integer getIsCustomDesc() {
        return this.isCustomDesc;
    }

    public void setIsCustomDesc(Integer num) {
        this.isCustomDesc = num;
    }

    public Integer getListenerTime() {
        return this.listenerTime;
    }

    public void setListenerTime(Integer num) {
        this.listenerTime = num;
    }

    public List<String> getFormList() {
        return this.formList;
    }

    public void setFormList(List<String> list) {
        this.formList = list;
    }

    public Map<Integer, List<TaskDataStep>> getIntegerListMap() {
        return this.integerListMap;
    }

    public void setIntegerListMap(Map<Integer, List<TaskDataStep>> map) {
        this.integerListMap = map;
    }

    public String getCommentKeyword() {
        return this.commentKeyword;
    }

    public void setCommentKeyword(String str) {
        this.commentKeyword = str;
    }

    public Integer getCommentType() {
        return this.commentType;
    }

    public void setCommentType(Integer num) {
        this.commentType = num;
    }

    public Integer getCommentStar() {
        return this.commentStar;
    }

    public void setCommentStar(Integer num) {
        this.commentStar = num;
    }

    public Integer getRank() {
        return this.rank;
    }

    public void setRank(Integer num) {
        this.rank = num;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public String getAppGalleryName() {
        return this.appGalleryName;
    }

    public void setAppGalleryName(String str) {
        this.appGalleryName = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getClassify() {
        return this.classify;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setClassify(String str) {
        this.classify = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getIcon() {
        return this.icon;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setIcon(String str) {
        this.icon = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getShowName() {
        return this.showName;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setShowName(String str) {
        this.showName = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public BigDecimal getShowMoney() {
        return this.showMoney;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setShowMoney(BigDecimal bigDecimal) {
        this.showMoney = bigDecimal;
    }

    public String getKeyPoint() {
        return this.keyPoint;
    }

    public void setKeyPoint(String str) {
        this.keyPoint = str;
    }

    public List<ClientGroupTaskData> getClientGroupTaskDataList() {
        return this.clientGroupTaskDataList;
    }

    public void setClientGroupTaskDataList(List<ClientGroupTaskData> list) {
        this.clientGroupTaskDataList = list;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public Integer getSuspendedSwitch() {
        return this.suspendedSwitch;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setSuspendedSwitch(Integer num) {
        this.suspendedSwitch = num;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setBrowseTime(Integer num) {
        this.browseTime = num;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public Integer getBrowseTime() {
        return this.browseTime;
    }

    public List<Integer> getQuestionTypeList() {
        return this.questionTypeList;
    }

    public void setQuestionTypeList(List<Integer> list) {
        this.questionTypeList = list;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public Integer getRtaFlag() {
        return this.rtaFlag;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setRtaFlag(Integer num) {
        this.rtaFlag = num;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public String getCollectionDataName() {
        return this.collectionDataName;
    }

    @Override // com.fendasz.moku.planet.source.bean.ClientSampleTaskData
    public void setCollectionDataName(String str) {
        this.collectionDataName = str;
    }

    public boolean isRtaTask() {
        Integer num = this.rtaFlag;
        return num != null && 1 == num.intValue();
    }
}
