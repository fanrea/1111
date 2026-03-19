package com.bykv.vk.openvk.component.video.api.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private String d;
    private int gb;
    private String hc;
    private long b = -2147483648L;
    private int c = Integer.MIN_VALUE;
    private long u = -2147483648L;
    private double an = -2.147483648E9d;
    private double h = -2.147483648E9d;

    public JSONObject d() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.hc)) {
                jSONObject.putOpt("audio_url", this.hc);
            }
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.putOpt("file_hash", this.d);
            }
            long j = this.b;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.c;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.u;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.an;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.h;
            if (d2 > 0.0d) {
                jSONObject.put("start", d2);
            }
            int i2 = this.gb;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public String hc() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public long b() {
        return this.b;
    }

    public void d(long j) {
        this.b = j;
    }

    public void d(int i) {
        this.c = i;
    }

    public double c() {
        return this.h;
    }

    public void d(double d) {
        this.h = d;
    }

    public void hc(long j) {
        this.u = j;
    }

    public String u() {
        return this.hc;
    }

    public void hc(String str) {
        this.hc = str;
    }

    public double an() {
        return this.an;
    }

    public void hc(double d) {
        this.an = d;
    }

    public void hc(int i) {
        if (i < 0) {
            i = 0;
        }
        this.gb = i;
    }

    public int h() {
        return this.gb;
    }
}
