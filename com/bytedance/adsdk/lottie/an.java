package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private List<com.bytedance.adsdk.lottie.model.an> an;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.gb>> b;
    private Map<String, tt> c;
    private c cb;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gb> gb;
    private SparseArray<com.bytedance.adsdk.lottie.model.c> h;
    private d jh;
    private boolean k;
    private float mk;
    private float mq;
    private b rf;
    private Rect tc;
    private List<com.bytedance.adsdk.lottie.model.layer.gb> tt;
    private Map<String, com.bytedance.adsdk.lottie.model.b> u;
    private float uo;
    private hc yo;
    private final yo d = new yo();
    private final HashSet<String> hc = new HashSet<>();
    private int e = 0;
    private String w = "";

    public static class b {
        public JSONArray b;
        public String d;
        public int[][] hc;
    }

    public static class c {
        public String an;
        public String b;
        public String c;
        public int d;
        public JSONArray h;
        public String hc;
        public int[] u;
    }

    public static class hc {
        public String an;
        public Map<String, Object> b;
        public int c;
        public int d;
        public JSONArray h;
        public Map<String, Object> hc;
        public int u;
    }

    public void d(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.model.layer.gb> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gb> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.gb>> map, Map<String, tt> map2, SparseArray<com.bytedance.adsdk.lottie.model.c> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.b> map3, List<com.bytedance.adsdk.lottie.model.an> list2, c cVar, String str, hc hcVar, b bVar, d dVar) {
        this.tc = rect;
        this.mk = f;
        this.mq = f2;
        this.uo = f3;
        this.tt = list;
        this.gb = longSparseArray;
        this.b = map;
        this.c = map2;
        this.h = sparseArray;
        this.u = map3;
        this.an = list2;
        this.cb = cVar;
        this.w = str;
        this.yo = hcVar;
        this.rf = bVar;
        this.jh = dVar;
    }

    public void d(String str) {
        com.bytedance.adsdk.lottie.u.u.hc(str);
        this.hc.add(str);
    }

    public void d(boolean z) {
        this.k = z;
    }

    public void d(int i) {
        this.e += i;
    }

    public boolean d() {
        return this.k;
    }

    public int hc() {
        return this.e;
    }

    public void hc(boolean z) {
        this.d.d(z);
    }

    public yo b() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.layer.gb d(long j) {
        return this.gb.get(j);
    }

    public Rect c() {
        return this.tc;
    }

    public float u() {
        return (long) ((yo() / this.uo) * 1000.0f);
    }

    public float an() {
        return this.mk;
    }

    public float h() {
        return this.mq;
    }

    public float d(float f) {
        return com.bytedance.adsdk.lottie.u.gb.d(this.mk, this.mq, f);
    }

    public c gb() {
        return this.cb;
    }

    public String tt() {
        return this.w;
    }

    public d tc() {
        return this.jh;
    }

    public b mk() {
        return this.rf;
    }

    public hc mq() {
        return this.yo;
    }

    public float uo() {
        return this.uo;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.gb> k() {
        return this.tt;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.gb> hc(String str) {
        return this.b.get(str);
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.c> e() {
        return this.h;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.b> cb() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.an b(String str) {
        int size = this.an.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.model.an anVar = this.an.get(i);
            if (anVar.d(str)) {
                return anVar;
            }
        }
        return null;
    }

    public Map<String, tt> w() {
        return this.c;
    }

    public float yo() {
        return this.mq - this.mk;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.gb> it = this.tt.iterator();
        while (it.hasNext()) {
            sb.append(it.next().d("\t"));
        }
        return sb.toString();
    }

    public static class d {
        public String b;
        public String c;
        public String d;
        public String hc;
        public float u = -1.0f;
        public float an = -1.0f;
        public float h = -1.0f;
        public float gb = -1.0f;

        public String toString() {
            return "area[" + this.d + "," + this.hc + "," + this.b + "," + this.c + "]->[" + this.u + "," + this.an + "," + this.h + "," + this.gb + "]";
        }
    }
}
