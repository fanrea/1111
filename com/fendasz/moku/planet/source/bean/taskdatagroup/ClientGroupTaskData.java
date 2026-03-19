package com.fendasz.moku.planet.source.bean.taskdatagroup;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientGroupTaskData implements Serializable {
    private String cybermoneyName;
    private String openDateTime;
    private Double rewardMoney;
    private BigDecimal showMoney;
    private String showName;
    private ClientGroupTaskDataStatusEnum status;
    private TaskDataGroupConfig taskDataGroupConfig;
    private Integer taskDataGroupId;
    private Integer taskDataId;
    private boolean isSelected = false;
    private boolean isOpen = false;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public Integer getTaskDataGroupId() {
        return this.taskDataGroupId;
    }

    public void setTaskDataGroupId(Integer num) {
        this.taskDataGroupId = num;
    }

    public String getShowName() {
        return this.showName;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public Double getRewardMoney() {
        return this.rewardMoney;
    }

    public void setRewardMoney(Double d) {
        this.rewardMoney = d;
    }

    public BigDecimal getShowMoney() {
        return this.showMoney;
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

    public ClientGroupTaskDataStatusEnum getStatus() {
        return this.status;
    }

    public void setStatus(ClientGroupTaskDataStatusEnum clientGroupTaskDataStatusEnum) {
        this.status = clientGroupTaskDataStatusEnum;
    }

    public TaskDataGroupConfig getTaskDataGroupConfig() {
        return this.taskDataGroupConfig;
    }

    public void setTaskDataGroupConfig(TaskDataGroupConfig taskDataGroupConfig) {
        this.taskDataGroupConfig = taskDataGroupConfig;
    }

    public String getOpenDateTime() {
        return this.openDateTime;
    }

    public void setOpenDateTime(String str) {
        this.openDateTime = str;
    }
}
