package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i3 {
    String a;
    String b;
    long c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;

    public String toString() {
        return "AppChannelInfo{appName='" + this.a + "', authorName='" + this.b + "', packageSizeBytes=" + this.c + ", permissionsUrl='" + this.d + "', privacyAgreement='" + this.e + "', versionName='" + this.f + "', descriptionUrl='" + this.g + "', icpNumber='" + this.h + "', suitableAge='" + this.i + "', icpInfoUrl='" + this.j + "'}";
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public long f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public void a(String str) {
        this.a = str;
    }

    public String h() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public void f(String str) {
        this.d = str;
    }

    public String d() {
        return this.j;
    }

    public void a(long j) {
        this.c = j;
    }

    public void g(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-";
        }
        this.i = str;
    }

    public void i(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public void d(String str) {
        this.j = str;
    }
}
