package com.fendasz.moku.planet.source.bean;

import com.fendasz.moku.planet.source.requestmodel.BasicParameterModel;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientTaskRecordListInfo extends BasicParameterModel implements Serializable {
    private List<Integer> recordStatusList;

    public List<Integer> getRecordStatusList() {
        return this.recordStatusList;
    }

    public void setRecordStatusList(List<Integer> list) {
        this.recordStatusList = list;
    }
}
