package com.kwad.sdk.api.model.liveModel;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsCouponInfo implements Serializable {
    private static final long serialVersionUID = 2072285066847893997L;
    private String displayBase;
    private String displayType;
    private String displayValue;
    private String endFetchTime;
    private String startFetchTime;

    public void setDisplayType(String str) {
        this.displayType = str;
    }

    public void setDisplayBase(String str) {
        this.displayBase = str;
    }

    public void setDisplayValue(String str) {
        this.displayValue = str;
    }

    public void setStartFetchTime(String str) {
        this.startFetchTime = str;
    }

    public void setEndFetchTime(String str) {
        this.endFetchTime = str;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public String getStartFetchTime() {
        return this.startFetchTime;
    }

    public String getEndFetchTime() {
        return this.endFetchTime;
    }

    public String toString() {
        return "KsCouponInfo{displayType='" + this.displayType + "', displayBase='" + this.displayBase + "', displayValue='" + this.displayValue + "', startFetchTime='" + this.startFetchTime + "', endFetchTime='" + this.endFetchTime + "'}";
    }
}
