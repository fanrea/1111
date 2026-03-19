package com.fendasz.moku.planet.source.bean;

import android.text.TextUtils;
import com.fendasz.moku.planet.utils.DateUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientSampleTaskData implements Serializable {
    public static final String TASK_TYPE_COMMENT = "comment";
    public static final String TASK_TYPE_CPA = "cpa";
    public static final String TASK_TYPE_HP = "hp";
    public static final String TASK_TYPE_KEYWORD = "keyword";
    private String apkApplicationId;
    private String apkApplicationId1;
    private Integer browseTime;
    private String ch;
    private String classify;
    private Integer collectionDataId;
    private String collectionDataName;
    private Boolean cpaKeep;
    private Boolean cpl;
    private String cybermoneyName;
    private String desc;
    private Integer detectUsage;
    private Double earnedMoney;
    private Boolean easy;
    private Integer easyTaskType;
    private Date endTime;
    private String ext;
    private Integer filterFlag;
    private Integer finishNum;
    private String gateType;
    private Integer highPrice;
    private String icon;
    private Integer locationStatus;
    private Integer monitorMethod;
    private Long nextTime;
    private String openDateTime;
    private Integer recordId;
    private Integer refreshStatus;
    private Integer rtaFlag;
    private BigDecimal showEarnedMoney;
    private BigDecimal showMoney;
    private String showName;
    private String show_url;
    private Integer simple;
    private Integer surplusNum;
    private Integer suspendedSwitch;
    private List<TaskDataTag> tagNameStr;
    private String taskActivityPlatform;
    private String taskDataApplicationId;
    private TaskDataApplyRecord taskDataApplyRecord;
    private Integer taskDataGroupId;
    private Boolean taskDataGroupIsNew;
    private Integer taskDataId;
    private String taskDataKey;
    private Integer taskGrade;
    private int taskId;
    private Integer taskStatus;
    private Integer taskType;
    private String timeLeft;
    private List<TaskDataTag> toCTagNameStr;
    private Integer topIndex;
    private Long topNum;
    private Integer topPosition;
    private Integer totalNum;
    private Integer urgentLogo;
    private String url;
    public static final Integer STATUS_OF_APPLYING = 0;
    public static final Integer STATUS_OF_COMPLETED = 1;
    public static final Integer STATUS_OF_CANCELLED = -1;
    public static final Integer STATUS_OF_OVERTIME = -2;
    private boolean duringTop = false;
    private boolean recommend = false;

    public String getGateType() {
        return this.gateType;
    }

    public void setGateType(String str) {
        this.gateType = str;
    }

    public boolean isHpOrCpaOrCplTask() {
        if (!TextUtils.isEmpty(this.classify)) {
            if ((this.classify.equals("hp") || this.classify.equals("cpa")) || this.cpl.booleanValue()) {
                return true;
            }
        } else if (this.cpl.booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isApplyRecordNullOrCanceled() {
        TaskDataApplyRecord taskDataApplyRecord = this.taskDataApplyRecord;
        return taskDataApplyRecord == null || taskDataApplyRecord.getStatus().equals(STATUS_OF_CANCELLED);
    }

    public String getPackageName() {
        if (TextUtils.isEmpty(this.apkApplicationId1)) {
            return this.apkApplicationId;
        }
        return this.apkApplicationId1;
    }

    public boolean isCheckUsage() {
        Integer num = this.detectUsage;
        return num != null && num.intValue() == 1;
    }

    public boolean isApplying() {
        TaskDataApplyRecord taskDataApplyRecord = this.taskDataApplyRecord;
        return taskDataApplyRecord != null && taskDataApplyRecord.getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING);
    }

    public boolean isOverTime() {
        TaskDataApplyRecord taskDataApplyRecord = this.taskDataApplyRecord;
        return taskDataApplyRecord != null && taskDataApplyRecord.getStatus().equals(TaskDataApplyRecord.STATUS_OF_OVERTIME);
    }

    public boolean isTaskGroup() {
        return this.taskDataGroupId != null;
    }

    public boolean isNewTaskGroup() {
        Boolean bool = this.taskDataGroupIsNew;
        return bool == null || bool.booleanValue();
    }

    public boolean isSimple() {
        Integer num = this.simple;
        return num != null && num.intValue() == 1;
    }

    public boolean isHighPrice() {
        Integer num = this.highPrice;
        return num != null && num.intValue() == 1;
    }

    public boolean isTopPosition() {
        Integer num = this.topPosition;
        return num != null && num.intValue() == 2;
    }

    public boolean isCpaKeep() {
        Boolean bool;
        return isTaskGroup() && !isNewTaskGroup() && (bool = this.cpaKeep) != null && bool.booleanValue();
    }

    public Integer getDetectUsage() {
        return this.detectUsage;
    }

    public void setDetectUsage(Integer num) {
        this.detectUsage = num;
    }

    public Boolean getCpaKeep() {
        return this.cpaKeep;
    }

    public void setCpaKeep(Boolean bool) {
        this.cpaKeep = bool;
    }

    public Integer getTopPosition() {
        return this.topPosition;
    }

    public void setTopPosition(Integer num) {
        this.topPosition = num;
    }

    public List<TaskDataTag> getTagNameStr() {
        return this.tagNameStr;
    }

    public void setTagNameStr(List<TaskDataTag> list) {
        this.tagNameStr = list;
    }

    public List<TaskDataTag> getToCTagNameStr() {
        return this.toCTagNameStr;
    }

    public void setToCTagNameStr(List<TaskDataTag> list) {
        this.toCTagNameStr = list;
    }

    public Integer getSimple() {
        return this.simple;
    }

    public void setSimple(Integer num) {
        this.simple = num;
    }

    public Integer getHighPrice() {
        return this.highPrice;
    }

    public void setHighPrice(Integer num) {
        this.highPrice = num;
    }

    public Integer getTaskDataGroupId() {
        return this.taskDataGroupId;
    }

    public void setTaskDataGroupId(Integer num) {
        this.taskDataGroupId = num;
    }

    public Boolean getTaskDataGroupIsNew() {
        return this.taskDataGroupIsNew;
    }

    public void setTaskDataGroupIsNew(Boolean bool) {
        this.taskDataGroupIsNew = bool;
    }

    public Double getEarnedMoney() {
        return this.earnedMoney;
    }

    public void setEarnedMoney(Double d) {
        this.earnedMoney = d;
    }

    public BigDecimal getShowEarnedMoney() {
        BigDecimal bigDecimal = this.showEarnedMoney;
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }

    public void setShowEarnedMoney(BigDecimal bigDecimal) {
        this.showEarnedMoney = bigDecimal;
    }

    public String getOpenDateTime() {
        return this.openDateTime;
    }

    public void setOpenDateTime(String str) {
        this.openDateTime = str;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public String getClassify() {
        return this.classify;
    }

    public void setClassify(String str) {
        this.classify = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getApkApplicationId() {
        return this.apkApplicationId;
    }

    public void setApkApplicationId(String str) {
        this.apkApplicationId = str;
    }

    public String getShowName() {
        return this.showName;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public BigDecimal getShowMoney() {
        BigDecimal bigDecimal = this.showMoney;
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }

    public void setShowMoney(BigDecimal bigDecimal) {
        this.showMoney = bigDecimal;
    }

    public String getCybermoneyName() {
        return this.cybermoneyName;
    }

    public void setCybermoneyName(String str) {
        this.cybermoneyName = str;
    }

    public Integer getSurplusNum() {
        return this.surplusNum;
    }

    public void setSurplusNum(Integer num) {
        this.surplusNum = num;
    }

    public TaskDataApplyRecord getTaskDataApplyRecord() {
        return this.taskDataApplyRecord;
    }

    public void setTaskDataApplyRecord(TaskDataApplyRecord taskDataApplyRecord) {
        this.taskDataApplyRecord = taskDataApplyRecord;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public String getApkApplicationId1() {
        return this.apkApplicationId1;
    }

    public void setApkApplicationId1(String str) {
        this.apkApplicationId1 = str;
    }

    public Integer getFinishNum() {
        return this.finishNum;
    }

    public void setFinishNum(Integer num) {
        this.finishNum = num;
    }

    public Integer getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(Integer num) {
        this.totalNum = num;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getCh() {
        return this.ch;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public Integer getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Integer num) {
        this.recordId = num;
    }

    public Boolean getEasy() {
        Boolean bool = this.easy;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public void setEasy(Boolean bool) {
        this.easy = bool;
    }

    public String easyTaskName() {
        if (getEasy().booleanValue() && getEasyTaskType().intValue() == 1) {
            StringBuilder sb = new StringBuilder(128);
            Long l = this.nextTime;
            if (l == null || l.longValue() <= 0) {
                sb.append(this.showName);
                sb.append("(").append(this.finishNum).append("/").append(this.totalNum).append(")");
                return sb.toString();
            }
            if (new Date().getTime() >= this.nextTime.longValue()) {
                sb.append(this.showName);
                sb.append("(").append(this.finishNum).append("/").append(this.totalNum).append(")");
                return sb.toString();
            }
            sb.append("别走开！");
            sb.append(DateUtils.getFormatDate(this.nextTime.longValue(), "HH:mm"));
            sb.append("开启下一组");
            return sb.toString();
        }
        return this.showName;
    }

    public Integer getEasyTaskType() {
        Integer num = this.easyTaskType;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setEasyTaskType(Integer num) {
        this.easyTaskType = num;
    }

    public Long getNextTime() {
        return this.nextTime;
    }

    public void setNextTime(Long l) {
        this.nextTime = l;
    }

    public Integer getTaskType() {
        return this.taskType;
    }

    public void setTaskType(Integer num) {
        this.taskType = num;
    }

    public Integer getTaskGrade() {
        return this.taskGrade;
    }

    public void setTaskGrade(Integer num) {
        this.taskGrade = num;
    }

    public Boolean getCpl() {
        return this.cpl;
    }

    public void setCpl(Boolean bool) {
        this.cpl = bool;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public Integer getUrgentLogo() {
        return this.urgentLogo;
    }

    public void setUrgentLogo(Integer num) {
        this.urgentLogo = num;
    }

    public String getTimeLeft() {
        return this.timeLeft;
    }

    public void setTimeLeft(String str) {
        this.timeLeft = str;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(Integer num) {
        this.taskStatus = num;
    }

    public boolean isDuringTop() {
        return this.duringTop;
    }

    public void setDuringTop(boolean z) {
        this.duringTop = z;
    }

    public boolean isRecommend() {
        return this.recommend;
    }

    public void setRecommend(boolean z) {
        this.recommend = z;
    }

    public String getTaskActivityPlatform() {
        return this.taskActivityPlatform;
    }

    public void setTaskActivityPlatform(String str) {
        this.taskActivityPlatform = str;
    }

    public Long getTopNum() {
        return this.topNum;
    }

    public void setTopNum(Long l) {
        this.topNum = l;
    }

    public Integer getSuspendedSwitch() {
        return this.suspendedSwitch;
    }

    public void setSuspendedSwitch(Integer num) {
        this.suspendedSwitch = num;
    }

    public String getShow_url() {
        return this.show_url;
    }

    public void setShow_url(String str) {
        this.show_url = str;
    }

    public Integer getRefreshStatus() {
        return this.refreshStatus;
    }

    public void setRefreshStatus(Integer num) {
        this.refreshStatus = num;
    }

    public Integer getLocationStatus() {
        Integer num = this.locationStatus;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setLocationStatus(Integer num) {
        this.locationStatus = num;
    }

    public Integer getBrowseTime() {
        return this.browseTime;
    }

    public void setBrowseTime(Integer num) {
        this.browseTime = num;
    }

    public Integer getCollectionDataId() {
        return this.collectionDataId;
    }

    public void setCollectionDataId(Integer num) {
        this.collectionDataId = num;
    }

    public Integer getTopIndex() {
        Integer num = this.topIndex;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public void setTopIndex(Integer num) {
        this.topIndex = num;
    }

    public Integer getRtaFlag() {
        return this.rtaFlag;
    }

    public void setRtaFlag(Integer num) {
        this.rtaFlag = num;
    }

    public Integer getFilterFlag() {
        return this.filterFlag;
    }

    public void setFilterFlag(Integer num) {
        this.filterFlag = num;
    }

    public Integer getMonitorMethod() {
        return this.monitorMethod;
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

    public String getTaskDataKey() {
        return this.taskDataKey;
    }

    public void setTaskDataKey(String str) {
        this.taskDataKey = str;
    }

    public String getCollectionDataName() {
        return this.collectionDataName;
    }

    public void setCollectionDataName(String str) {
        this.collectionDataName = str;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        Double d;
        BigDecimal bigDecimal;
        Boolean bool;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClientSampleTaskData clientSampleTaskData = (ClientSampleTaskData) obj;
        Integer num2 = this.taskDataId;
        int iIntValue = num2 == null ? 0 : num2.intValue();
        Integer num3 = clientSampleTaskData.taskDataId;
        boolean z = iIntValue == (num3 == null ? 0 : num3.intValue());
        Integer num4 = this.topPosition;
        int iIntValue2 = num4 == null ? 0 : num4.intValue();
        Integer num5 = clientSampleTaskData.topPosition;
        boolean z2 = iIntValue2 == (num5 == null ? 0 : num5.intValue());
        Integer num6 = this.detectUsage;
        int iIntValue3 = num6 == null ? 0 : num6.intValue();
        Integer num7 = clientSampleTaskData.detectUsage;
        return this.taskId == clientSampleTaskData.taskId && z && (str = this.classify) != null && str.equals(clientSampleTaskData.classify) && (str2 = this.apkApplicationId) != null && str2.equals(clientSampleTaskData.apkApplicationId) && (str3 = this.apkApplicationId1) != null && str3.equals(clientSampleTaskData.apkApplicationId1) && (str4 = this.showName) != null && str4.equals(clientSampleTaskData.showName) && (num = this.surplusNum) != null && num.equals(clientSampleTaskData.surplusNum) && (d = this.earnedMoney) != null && d.equals(clientSampleTaskData.earnedMoney) && (bigDecimal = this.showEarnedMoney) != null && bigDecimal.equals(clientSampleTaskData.showEarnedMoney) && z2 && (bool = this.cpaKeep) != null && bool.equals(clientSampleTaskData.cpaKeep) && (iIntValue3 == (num7 == null ? 0 : num7.intValue()));
    }

    public int hashCode() {
        return Objects.hash(this.taskDataId, Integer.valueOf(this.taskId), this.classify, this.apkApplicationId, this.apkApplicationId1, this.showName, this.surplusNum, this.earnedMoney, this.showEarnedMoney, this.topPosition, this.cpaKeep, this.detectUsage);
    }
}
