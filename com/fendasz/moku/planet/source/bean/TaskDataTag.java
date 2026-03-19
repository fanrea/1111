package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDataTag implements Serializable {
    private String tagName;
    private Integer type;
    public static final Integer TAG = 0;
    public static final Integer APPLICATION_MARKET = 1;
    public static final Integer MISSION_INTRODUCE = 2;
    public static final Integer SECOND_REVIEW = 3;
    public static final Integer ACTIVITY_PLATFORM = 4;
    public static final Integer SUBMIT_NUMBER = 5;

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
