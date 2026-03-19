package com.fendasz.moku.planet.source.bean.taskdatagroup;

import com.alibaba.fastjson.annotation.JSONType;
import java.io.Serializable;

@JSONType(serializeEnumAsJavaBean = true)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum ClientGroupTaskDataStatusEnum implements Serializable {
    STATUS_OF_OPENING(0, "待完成", "待完成"),
    STATUS_OF_WAITING_OPENED(1, "待开启", "待开启"),
    STATUS_OF_SUBSEQUENT_OPENING(2, "后续开启", "后续开启"),
    STATUS_OF_ALREADY_SUBMIT_AND_IN_REVIEW(3, "审核中", "已提交"),
    STATUS_OF_ALREADY_SUBMIT_AND_DONE(4, "已完成", "已提交"),
    STATUS_OF_ALREADY_SUBMIT_AND_FAILED(5, "未通过", "已提交"),
    STATUS_OF_NUM_EMPTY(6, "已抢完", "已抢完"),
    STATUS_OF_EXPIRED(7, "已过期", "已过期");

    private final String groupName;
    private final Integer status;
    private final String statusExplain;

    ClientGroupTaskDataStatusEnum(Integer num, String str, String str2) {
        this.status = num;
        this.statusExplain = str;
        this.groupName = str2;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getStatusExplain() {
        return this.statusExplain;
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ClientGroupTaskDataStatusEnum{status=" + this.status + ", statusExplain='" + this.statusExplain + "', groupName='" + this.groupName + "'}";
    }
}
