package com.fendasz.moku.planet.entity;

import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class H5SubmitTaskData implements Serializable {
    private static final long serialVersionUID = 4191769489522550113L;
    private List<ClientTaskDataSubmitFormModel> fromlist;
    private String reason;
    private Integer submitRecordId;

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public List<ClientTaskDataSubmitFormModel> getFromlist() {
        return this.fromlist;
    }

    public void setFromlist(List<ClientTaskDataSubmitFormModel> list) {
        this.fromlist = list;
    }

    public Integer getSubmitRecordId() {
        return this.submitRecordId;
    }

    public void setSubmitRecordId(Integer num) {
        this.submitRecordId = num;
    }
}
