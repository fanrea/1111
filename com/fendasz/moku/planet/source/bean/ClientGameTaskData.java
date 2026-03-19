package com.fendasz.moku.planet.source.bean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientGameTaskData extends ClientDetailTaskData {
    private Integer cplTaskStatus;
    private Integer taskDataTag;

    public Integer getCplTaskStatus() {
        return this.cplTaskStatus;
    }

    public void setCplTaskStatus(Integer num) {
        this.cplTaskStatus = num;
    }

    public Integer getTaskDataTag() {
        return this.taskDataTag;
    }

    public void setTaskDataTag(Integer num) {
        this.taskDataTag = num;
    }

    public String getTagText() {
        Integer num = this.taskDataTag;
        return (num == null || num.intValue() == 1023) ? "游戏" : "应用";
    }
}
