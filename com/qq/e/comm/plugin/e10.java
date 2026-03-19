package com.qq.e.comm.plugin;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e10 {
    public final int a;
    public final String b;
    public final String c;
    public final Map<String, ob> d;
    public final String e;
    public final JSONObject f;
    public final JSONObject g;

    /* compiled from: A */
    public static class b {
        public int a;
        public String b = "";
        public String c = null;
        public Map<String, ob> d;
        public String e;
        public JSONObject f;
        public JSONObject g;

        public e10 a() {
            return new e10(this);
        }
    }

    private e10(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        Map<String, ob> map = bVar.d;
        this.d = (map == null || map.size() <= 0) ? null : map;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
    }
}
