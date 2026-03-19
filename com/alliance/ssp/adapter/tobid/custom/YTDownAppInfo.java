package com.alliance.ssp.adapter.tobid.custom;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YTDownAppInfo {
    private String appFunctionUrl;
    private String appIcon;
    private String appName;
    private String appPermissionUrl;
    private String appScore;
    private String appVersionName;
    private String authorName;
    private String downloadCount;
    private String privacyUrl;

    public String getAppName() {
        return this.appName;
    }

    public String getAppIcon() {
        return this.appIcon;
    }

    public String getDownloadCount() {
        return this.downloadCount;
    }

    public String getAppScore() {
        return this.appScore;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public String getAppPermissionUrl() {
        return this.appPermissionUrl;
    }

    public String getAppFunctionUrl() {
        return this.appFunctionUrl;
    }

    public YTDownAppInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.appName = str;
        this.appIcon = str2;
        this.downloadCount = str3;
        this.appScore = str4;
        this.authorName = str5;
        this.privacyUrl = str6;
        this.appVersionName = str7;
        this.appPermissionUrl = str8;
        this.appFunctionUrl = str9;
    }

    public String toString() {
        return "{appName='" + this.appName + "', authorName='" + this.authorName + "', privacyUrl='" + this.privacyUrl + "', appVersionName='" + this.appVersionName + "', appPermissionUrl='" + this.appPermissionUrl + "', appFunctionUrl='" + this.appFunctionUrl + "'}";
    }
}
