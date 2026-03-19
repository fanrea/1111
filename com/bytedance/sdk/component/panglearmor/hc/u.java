package com.bytedance.sdk.component.panglearmor.hc;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static u d;
    private boolean hc = false;
    private long b = 180000;
    private long c = 43200000;
    private long u = 3;
    private long an = 30;
    private long h = 15;

    private u() {
    }

    public static u d() {
        if (d == null) {
            synchronized (u.class) {
                if (d == null) {
                    d = new u();
                }
            }
        }
        return d;
    }

    public synchronized void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.hc = jSONObject.optBoolean("sensorenable", false);
                this.b = jSONObject.optLong(MetricsSQLiteCacheKt.METRICS_INTERVAL, 180000L);
                this.c = jSONObject.optLong("expireduation", 43200000L);
                this.u = jSONObject.optLong("showinterval", 3L);
                this.an = jSONObject.optLong("azimuth_unit", 30L);
                this.h = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }

    public boolean hc() {
        return this.hc;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.b;
    }

    public long u() {
        return this.u;
    }

    public long an() {
        return this.an;
    }

    public long h() {
        return this.h;
    }
}
