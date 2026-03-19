package com.qq.e.comm.plugin;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rc {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final Map<String, ob> e;
    public final String f;
    public final JSONObject g;
    public final JSONObject h;
    public final boolean i;
    public final String j;
    public final String k;
    public final int l;

    /* compiled from: A */
    public static class b {
        public int a;
        public String b = "";
        public String c = "";
        public String d = "";
        public Map<String, ob> e;
        public String f;
        public JSONObject g;
        public JSONObject h;
        public boolean i;
        public String j;
        public String k;
        public int l;

        public rc a() {
            return new rc(this);
        }
    }

    private rc(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        Map<String, ob> map = bVar.e;
        this.e = (map == null || map.size() <= 0) ? null : map;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
