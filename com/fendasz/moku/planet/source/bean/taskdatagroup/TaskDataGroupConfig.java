package com.fendasz.moku.planet.source.bean.taskdatagroup;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDataGroupConfig implements Serializable {
    private String dateControlType;
    private String enableCondition;
    private List<String> enableConditionList;
    private Integer id;
    private Integer index;
    private Integer operateDays;
    private Integer status;
    private Integer taskDataGroupId;
    private Integer taskDataId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Integer getTaskDataGroupId() {
        return this.taskDataGroupId;
    }

    public void setTaskDataGroupId(Integer num) {
        this.taskDataGroupId = num;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public String getEnableCondition() {
        return this.enableCondition;
    }

    public void setEnableCondition(String str) {
        this.enableCondition = str;
    }

    public List<String> getEnableConditionList() {
        return this.enableConditionList;
    }

    public void setEnableConditionList(List<String> list) {
        setEnableCondition(JSONObject.toJSONString(list));
        this.enableConditionList = list;
    }

    public Integer getOperateDays() {
        return this.operateDays;
    }

    public void setOperateDays(Integer num) {
        this.operateDays = num;
    }

    public String getDateControlType() {
        return this.dateControlType;
    }

    public void setDateControlType(String str) {
        this.dateControlType = str;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer num) {
        this.index = num;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }
}
