package com.sigmob.sdk.base.mta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PointEntityApp extends PointEntitySigmobSuper {
    private String a;
    private String b;
    private String c;
    private String d;

    public String getApp_name() {
        return this.a;
    }

    public String getApp_version() {
        return this.d;
    }

    public String getPackage_name() {
        return this.b;
    }

    public String getUpdate() {
        return this.c;
    }

    public void setApp_name(String app_name) {
        this.a = app_name;
    }

    public void setApp_version(String app_version) {
        this.d = app_version;
    }

    public void setPackage_name(String package_name) {
        this.b = package_name;
    }

    public void setUpdate(String update) {
        this.c = update;
    }
}
