package com.bytedance.sdk.component.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.d.mk;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    boolean an;
    gb c;
    mk.hc cb;
    com.bytedance.sdk.component.uo.b d;
    boolean e;
    boolean gb;
    boolean h;
    d hc;
    boolean k;
    k tc;
    uo tt;
    Context u;
    String b = "IESJSBridge";
    String mk = "host";
    final Set<String> mq = new LinkedHashSet();
    final Set<String> uo = new LinkedHashSet();

    tc(com.bytedance.sdk.component.uo.b bVar) {
        this.d = bVar;
    }

    tc() {
    }

    public tc d(d dVar) {
        this.hc = dVar;
        return this;
    }

    public tc d(String str) {
        this.b = str;
        return this;
    }

    public tc d(mq mqVar) {
        this.c = gb.d(mqVar);
        return this;
    }

    public tc d(boolean z) {
        this.an = z;
        return this;
    }

    public tc hc(boolean z) {
        this.h = z;
        return this;
    }

    public tc d() {
        this.e = true;
        return this;
    }

    public w hc() {
        b();
        return new w(this);
    }

    public Context getContext() {
        return this.u;
    }

    private void b() {
        if ((this.d == null && !this.k && this.hc == null) || ((TextUtils.isEmpty(this.b) && this.d != null) || this.c == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
