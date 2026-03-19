package com.bykv.vk.openvk.component.video.api.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private String an;
    private long b;
    private double c;
    private int d;
    private String gb;
    private String h;
    private int hc;
    private double mk;
    private int mq;
    private String tc;
    private String tt;
    private String u;
    private int uo;
    private float k = -1.0f;
    private int e = 0;
    private int cb = 0;
    private int w = 0;
    private int yo = 0;
    private int rf = 307200;
    private int jh = 1;

    public int d() {
        return this.mq;
    }

    public void d(int i) {
        this.mq = i;
    }

    public int hc() {
        return this.d;
    }

    public void hc(int i) {
        this.d = i;
    }

    public int b() {
        return this.hc;
    }

    public void b(int i) {
        this.hc = i;
    }

    public int c() {
        return this.uo;
    }

    public long u() {
        return this.b;
    }

    public void d(long j) {
        this.b = j;
    }

    public double an() {
        return this.c;
    }

    public void d(double d) {
        this.c = d;
    }

    public double h() {
        return this.mk;
    }

    public void hc(double d) {
        this.mk = d;
    }

    public float gb() {
        return this.k;
    }

    public void d(float f) {
        this.k = f;
    }

    public String tt() {
        return this.u;
    }

    public void d(String str) {
        this.u = str;
    }

    public int[] tc() {
        try {
            int iIndexOf = this.u.indexOf("x");
            return new int[]{Integer.parseInt(this.u.substring(0, iIndexOf).trim()), Integer.parseInt(this.u.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String mk() {
        return this.an;
    }

    public void hc(String str) {
        this.an = str;
    }

    public String mq() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public String uo() {
        return this.gb;
    }

    public void c(String str) {
        this.gb = str;
    }

    public String k() {
        return this.tt;
    }

    public String e() {
        if (TextUtils.isEmpty(this.tc)) {
            this.tc = com.bykv.vk.openvk.component.video.api.an.hc.d(this.h);
        }
        return this.tc;
    }

    public void u(String str) {
        this.tc = str;
    }

    public int cb() {
        if (this.rf < 0) {
            this.rf = 307200;
        }
        long j = this.rf;
        long j2 = this.b;
        if (j > j2) {
            this.rf = (int) j2;
        }
        return this.rf;
    }

    public void c(int i) {
        this.rf = i;
    }

    public int w() {
        return this.w;
    }

    public void u(int i) {
        this.w = i;
    }

    public int yo() {
        return this.yo;
    }

    public void an(int i) {
        this.yo = i;
    }

    public JSONObject rf() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", hc());
            jSONObject.put("cover_url", mk());
            jSONObject.put("cover_width", b());
            jSONObject.put("endcard", uo());
            jSONObject.put("file_hash", e());
            jSONObject.put("resolution", tt());
            jSONObject.put("size", u());
            jSONObject.put("video_duration", an());
            jSONObject.put("video_url", mq());
            jSONObject.put("playable_download_url", k());
            jSONObject.put("if_playable_loading_show", jh());
            jSONObject.put("remove_loading_page_type", sy());
            jSONObject.put("fallback_endcard_judge", d());
            jSONObject.put("video_preload_size", cb());
            jSONObject.put("reward_video_cached_type", w());
            jSONObject.put("execute_cached_type", yo());
            jSONObject.put("endcard_render", c());
            jSONObject.put("replay_time", np());
            jSONObject.put("play_speed_ratio", gb());
            if (h() > 0.0d) {
                jSONObject.put("start", h());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int jh() {
        return this.e;
    }

    public int sy() {
        return this.cb;
    }

    public boolean de() {
        return this.yo == 1;
    }

    public boolean v() {
        return this.w == 0;
    }

    public int np() {
        return this.jh;
    }
}
