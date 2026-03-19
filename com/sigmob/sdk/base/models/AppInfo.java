package com.sigmob.sdk.base.models;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppInfo {
    public final String appVersion;
    public final String os;
    public final String sdkVersion;

    public AppInfo(String sdkVersion, String appVersion, String os) {
        this.sdkVersion = sdkVersion;
        this.appVersion = appVersion;
        this.os = os;
    }

    public String toString() {
        return "appInfo={sdkVersion='" + this.sdkVersion + "', appVersion='" + this.appVersion + "', os='" + this.os + "'}";
    }
}
