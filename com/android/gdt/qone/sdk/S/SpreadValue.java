package com.android.gdt.qone.sdk.S;

import android.text.TextUtils;
import com.android.gdt.qone.ae.b;
import java.io.Serializable;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class SpreadValue implements Serializable {
    private String aid;
    private String appKey;
    private long firstTime;
    private String fromKey;
    private String fromSource;
    private String oaid;
    private String q16;
    private String q36;
    private String source;
    private long updateTime;

    public final SpreadValue a(String str) {
        this.aid = str;
        return this;
    }

    public final SpreadValue b(String str) {
        this.appKey = str;
        return this;
    }

    public final SpreadValue c(String str) {
        this.fromKey = str;
        return this;
    }

    public final SpreadValue d(String str) {
        this.fromSource = str;
        return this;
    }

    public final SpreadValue e(String str) {
        this.oaid = str;
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SpreadValue)) {
            return false;
        }
        SpreadValue spreadValue = (SpreadValue) obj;
        String str = this.oaid;
        String str2 = spreadValue.oaid;
        int i = b.a;
        if (!TextUtils.isEmpty(str2) && !str.equals(str2)) {
            return false;
        }
        String str3 = this.aid;
        String str4 = spreadValue.aid;
        if (!TextUtils.isEmpty(str4) && !str3.equals(str4)) {
            return false;
        }
        String str5 = this.q16;
        String str6 = spreadValue.q16;
        if (!TextUtils.isEmpty(str6) && !str5.equals(str6)) {
            return false;
        }
        String str7 = this.q36;
        String str8 = spreadValue.q36;
        return TextUtils.isEmpty(str8) || str7.equals(str8);
    }

    public final SpreadValue f(String str) {
        this.q16 = str;
        return this;
    }

    public final SpreadValue g(String str) {
        this.q36 = str;
        return this;
    }

    public final SpreadValue h(String str) {
        this.source = str;
        return this;
    }

    public final String i() {
        return this.source;
    }

    public final long j() {
        return this.updateTime;
    }

    public final SpreadValue a(long j) {
        this.firstTime = j;
        return this;
    }

    public final SpreadValue b(long j) {
        this.updateTime = j;
        return this;
    }

    public final long c() {
        return this.firstTime;
    }

    public final String d() {
        return this.fromKey;
    }

    public final String e() {
        return this.fromSource;
    }

    public final String f() {
        return this.oaid;
    }

    public final String g() {
        return this.q16;
    }

    public final String h() {
        return this.q36;
    }

    public final String a() {
        return this.aid;
    }

    public final String b() {
        return this.appKey;
    }
}
