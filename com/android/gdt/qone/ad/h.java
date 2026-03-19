package com.android.gdt.qone.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class h {
    public static final ConcurrentHashMap f = new ConcurrentHashMap();
    public SharedPreferences a;
    public final String b;
    public Context c;
    public String d;
    public String e;

    public h(String str) {
        this.b = str;
    }

    public static synchronized h a(String str) {
        h hVar;
        ConcurrentHashMap concurrentHashMap = f;
        hVar = (h) concurrentHashMap.get(str);
        if (hVar == null) {
            hVar = new h(str);
            concurrentHashMap.put(str, hVar);
        }
        return hVar;
    }

    public final long b(String str) {
        if (a() == null) {
            return 0L;
        }
        return this.a.getLong(str, 0L);
    }

    public final String c(String str) {
        String string;
        return (a() == null || (string = this.a.getString(str, "")) == null) ? "" : string;
    }

    public final SharedPreferences a() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null && this.c != null) {
                    if (TextUtils.isEmpty(this.e)) {
                        this.e = "";
                    }
                    String str = "QV1" + this.e + com.android.gdt.qone.ae.b.a(this.b);
                    this.d = str;
                    this.a = this.c.getSharedPreferences(str, 0);
                }
            }
        }
        return this.a;
    }

    public final void a(String str, String str2) {
        if (a() == null) {
            return;
        }
        com.android.gdt.qone.w.a.a(this.b, this.d, new d(this, str, str2));
    }

    public final void a(String str, long j) {
        if (a() == null) {
            return;
        }
        com.android.gdt.qone.w.a.a(this.b, this.d, new g(this, str, j));
    }
}
