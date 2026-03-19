package com.ss.android.socialbase.downloader.mk;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k {
    private final JSONObject d;
    private int hc;

    private k(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void d(int i) {
        this.hc = hc(i);
    }

    public int d() {
        return this.hc;
    }

    private int cb() {
        return this.d.optInt("url_balance", 2);
    }

    public boolean hc() {
        return cb() > 0;
    }

    public boolean b() {
        return cb() == 1;
    }

    public int c() {
        return this.d.optInt("buffer_count", 512);
    }

    public int u() {
        return this.d.optInt("buffer_size", 8192);
    }

    public boolean an() {
        return this.d.optInt("segment_mode", 1) == 0;
    }

    public long h() {
        long jOptInt = this.d.optInt("segment_min_kb", 512) * 1024;
        if (jOptInt < 65536) {
            return 65536L;
        }
        return jOptInt;
    }

    public long gb() {
        long jOptInt = this.d.optInt("segment_min_init_mb", 10) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long tt() {
        long jOptInt = this.d.optInt("segment_max_kb", 0) * 1048576;
        if (jOptInt < h()) {
            return -1L;
        }
        return jOptInt;
    }

    public long tc() {
        long jOptInt = this.d.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long mk() {
        long jOptInt = this.d.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int mq() {
        return this.d.optInt("ip_strategy", 0);
    }

    private int hc(int i) {
        int iOptInt = this.d.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return cb() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (cb() > 0) {
            return i;
        }
        return 1;
    }

    public float uo() {
        return (float) this.d.optDouble("main_ratio", 0.0d);
    }

    public int k() {
        return this.d.optInt("ratio_segment", 0);
    }

    public float e() {
        return Math.min(Math.max(0.0f, (float) this.d.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static k d(JSONObject jSONObject) {
        return new k(jSONObject);
    }
}
