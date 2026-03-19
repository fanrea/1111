package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    private final String an;
    private final String b;
    private final String c;
    private final int d;
    private final String gb;
    private final String h;
    private final int hc;
    private Bitmap k;
    private final int[][] mk;
    private final JSONArray mq;
    private final String tc;
    private final List<hc> tt;
    private final String u;
    private final d uo;

    public static class d {
        public C0170d d = null;
        public boolean hc;

        /* renamed from: com.bytedance.adsdk.lottie.tt$d$d, reason: collision with other inner class name */
        public static class C0170d {
            public float d = 5.0f;
        }
    }

    public static class hc {
        public int an;
        public String b;
        public String c;
        public int d;
        public int gb;
        public int h;
        public int hc;
        public String tt;
        public String u;
    }

    public tt(int i, int i2, String str, String str2, String str3, String str4, List<hc> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, d dVar) {
        this.d = i;
        this.hc = i2;
        this.b = str;
        this.c = str2;
        this.u = str3;
        this.an = str4;
        this.h = str6;
        this.gb = str7;
        this.tt = list;
        this.tc = str5;
        this.mk = iArr;
        this.mq = jSONArray;
        this.uo = dVar;
    }

    public int d() {
        return this.d;
    }

    public int hc() {
        return this.hc;
    }

    public List<hc> b() {
        return this.tt;
    }

    public String c() {
        return this.an;
    }

    public String u() {
        return this.h;
    }

    public String an() {
        return this.gb;
    }

    public String h() {
        return this.tc;
    }

    public int[][] gb() {
        return this.mk;
    }

    public JSONArray tt() {
        return this.mq;
    }

    public d tc() {
        return this.uo;
    }

    public String mk() {
        return this.b;
    }

    public String mq() {
        return this.c;
    }

    public String uo() {
        return this.u;
    }

    public Bitmap k() {
        return this.k;
    }

    public void d(Bitmap bitmap) {
        this.k = bitmap;
    }
}
