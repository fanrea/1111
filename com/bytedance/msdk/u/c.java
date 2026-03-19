package com.bytedance.msdk.u;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public String an;
    public String b;
    public String c;
    public String cb;
    public String d;
    public String e;
    public String gb;
    public String h;
    public String hc;
    public int k;
    public String mk;
    public String mq;
    public String sy;
    public String tc;
    public long tt;
    public String u;
    public String uo;
    public int w;
    public long yo;
    public int rf = -1;
    public int jh = -1;
    public Map<String, Object> de = new ConcurrentHashMap();
    private long v = -1;

    protected c() {
    }

    public c d(int i) {
        this.uo = String.valueOf(i);
        return this;
    }

    public c d(long j) {
        this.yo = j;
        return this;
    }

    public c d(String str) {
        this.d = str;
        return this;
    }

    public c hc(String str) {
        this.gb = str;
        return this;
    }

    public c hc(long j) {
        this.tt = j;
        return this;
    }

    public c b(String str) {
        this.tc = str;
        return this;
    }

    public c c(String str) {
        this.hc = str;
        return this;
    }

    public c u(String str) {
        this.b = str;
        return this;
    }

    public c an(String str) {
        this.c = str;
        return this;
    }

    public c h(String str) {
        this.u = str;
        return this;
    }

    public c gb(String str) {
        this.an = str;
        return this;
    }

    public c tt(String str) {
        this.h = str;
        return this;
    }

    public c tc(String str) {
        this.mk = str;
        return this;
    }

    public c hc(int i) {
        this.k = i;
        return this;
    }

    public c b(int i) {
        this.e = String.valueOf(i);
        return this;
    }

    public c c(int i) {
        this.cb = String.valueOf(i);
        return this;
    }

    public c u(int i) {
        this.w = i;
        return this;
    }

    public c setResult(int i) {
        this.rf = i;
        return this;
    }

    public c an(int i) {
        this.jh = i;
        return this;
    }

    public c mk(String str) {
        this.sy = str;
        return this;
    }

    public c d(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.de.put(str, obj);
        }
        return this;
    }

    public c d(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.de.putAll(map);
        }
        return this;
    }

    public c b(long j) {
        this.v = j;
        return this;
    }

    public long d() {
        return this.v;
    }

    public static c hc() {
        return new c();
    }

    public static c b() {
        c cVar = new c();
        cVar.b(System.currentTimeMillis());
        return cVar;
    }
}
