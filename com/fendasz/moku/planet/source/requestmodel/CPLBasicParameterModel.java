package com.fendasz.moku.planet.source.requestmodel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CPLBasicParameterModel extends BasicParameterModel {
    private Boolean fromAndroid;
    private String imei2;
    private String sdkType = "2";

    public String getSdkType() {
        return this.sdkType;
    }

    public void setSdkType(String str) {
        this.sdkType = str;
    }

    public Boolean getFromAndroid() {
        return this.fromAndroid;
    }

    public void setFromAndroid(Boolean bool) {
        this.fromAndroid = bool;
    }

    public String getImei2() {
        return this.imei2;
    }

    public void setImei2(String str) {
        this.imei2 = str;
    }
}
