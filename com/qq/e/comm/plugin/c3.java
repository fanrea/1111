package com.qq.e.comm.plugin;

import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class c3 implements GDTApk {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final ApkDownloadTask f;

    public String toString() {
        return "Apk{packageName='" + this.a + "', title='" + this.b + "', desc='" + this.c + "', appName='" + this.d + "', logoUrl='" + this.e + "'}";
    }

    public ApkDownloadTask a() {
        return this.f;
    }

    public c3(String str, String str2, String str3, String str4, String str5, ApkDownloadTask apkDownloadTask) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = apkDownloadTask;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getPackageName() {
        return this.a;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getTitle() {
        return this.b;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getDesc() {
        return this.c;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getAppName() {
        return this.d;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getLogoUrl() {
        return this.e;
    }
}
