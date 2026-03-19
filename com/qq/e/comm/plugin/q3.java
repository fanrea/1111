package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q3 {
    String a;
    String b;
    String c;
    String d;
    String e;

    public String c() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String a() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String d() {
        return this.a;
    }

    q3() {
        this.a = "立即下载";
        this.b = "下载中";
        this.c = "继续下载";
        this.d = "立即安装";
        this.e = "立即打开";
    }

    public void a(String str) {
        this.a = str;
    }

    q3(JSONObject jSONObject) {
        r3.a(this, jSONObject);
        this.a = "立即下载";
        if (TextUtils.isEmpty(this.b)) {
            this.b = "下载中";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = "继续下载";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "立即安装";
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = "立即打开";
        }
    }
}
