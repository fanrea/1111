package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b0 {
    private final String a;
    private final Context b;
    private final String c;
    private final String d;
    private String e;
    private String f;
    private long g;

    public b0(String str, Context context, String str2) throws PackageManager.NameNotFoundException {
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = context.getPackageName();
        g();
    }

    private void g() throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.d, 0);
            this.e = packageInfo.versionName;
            this.g = packageInfo.firstInstallTime;
            this.f = packageInfo.applicationInfo.loadLabel(this.b.getPackageManager()).toString();
        } catch (Exception unused) {
        }
    }

    public String f() {
        return this.c;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public long e() {
        return this.g;
    }
}
