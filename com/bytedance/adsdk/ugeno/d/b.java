package com.bytedance.adsdk.ugeno.d;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private d an;
    private int b;
    private String c;
    private Map<String, TreeMap<Float, String>> d;
    private String gb;
    private String h;
    private long hc;
    private JSONObject tc;
    private int tt = 1;
    private long u;

    public static class d {
        public String d;
        public String hc;
    }

    public JSONObject d() {
        return this.tc;
    }

    public void d(JSONObject jSONObject) {
        this.tc = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> hc() {
        return this.d;
    }

    public void d(Map<String, TreeMap<Float, String>> map) {
        this.d = map;
    }

    public long b() {
        return this.hc;
    }

    public void d(long j) {
        this.hc = j;
    }

    public int c() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public String u() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public long an() {
        return this.u;
    }

    public void hc(long j) {
        this.u = j;
    }

    public d h() {
        return this.an;
    }

    public void d(d dVar) {
        this.an = dVar;
    }

    public String gb() {
        return this.h;
    }

    public void hc(String str) {
        this.h = str;
    }

    public String tt() {
        return this.gb;
    }

    public void b(String str) {
        this.gb = str;
    }

    public int tc() {
        return this.tt;
    }

    public void hc(int i) {
        this.tt = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.d + ", mDuration=" + this.hc + ", mPlayCount=" + this.b + ", mPlayDirection=" + this.c + ", mDelay=" + this.u + ", mName=" + this.gb + ", mPlayState=" + this.tt + ", mTransformOrigin='" + this.an + "', mTimingFunction='" + this.h + "'}";
    }
}
