package com.bytedance.msdk.h.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.core.u.hc.c;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private int b = -1;
    private long c = -1;
    private int u = -1;
    private int an = -1;
    private int h = -1;
    private int gb = -1;
    private int tt = -1;
    private zw hc = com.bytedance.msdk.h.d.hc();

    private d() {
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private synchronized void hc(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("event_batch_size", 100);
        this.b = iOptInt;
        if (iOptInt <= 0 || iOptInt > 1000) {
            this.b = 100;
        }
        long jOptLong = jSONObject.optLong("event_routine_interval", 120000L);
        this.c = jOptLong;
        if (jOptLong < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || jOptLong > 300000) {
            this.c = 120000L;
        }
        int iOptInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.u = iOptInt2;
        if (iOptInt2 != 0 && iOptInt2 != 1) {
            this.u = 0;
        }
        this.h = jSONObject.optInt("rv_start_time", 5000);
        int iOptInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
        this.an = iOptInt3;
        if (iOptInt3 != 0 && iOptInt3 != 1) {
            this.an = 0;
        }
        c.d().d(jSONObject.optInt("pre_fetch_count", 20));
        this.gb = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
        this.tt = jSONObject.optInt("can_log", -1);
    }

    private synchronized JSONObject tc() {
        String strHc = this.hc.hc("app_common_config");
        if (TextUtils.isEmpty(strHc)) {
            return null;
        }
        if (!strHc.startsWith("[") && !strHc.startsWith("{")) {
            strHc = com.bytedance.msdk.gb.d.hc(strHc, com.bytedance.msdk.gb.hc.d());
        }
        if (!TextUtils.isEmpty(strHc)) {
            try {
                return new JSONObject(strHc);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return null;
    }

    public synchronized void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            hc(jSONObject);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                this.hc.d("app_common_config", string);
            }
        }
    }

    public synchronized int hc() {
        JSONObject jSONObjectTc;
        int i = this.b;
        if (i != -1) {
            return i;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return 100;
        }
        hc(jSONObjectTc);
        return this.b;
    }

    public synchronized long b() {
        JSONObject jSONObjectTc;
        long j = this.c;
        if (j != -1) {
            return j;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return 120000L;
        }
        hc(jSONObjectTc);
        return this.c;
    }

    public int c() {
        JSONObject jSONObjectTc;
        int i = this.u;
        if (i != -1) {
            return i;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return 0;
        }
        hc(jSONObjectTc);
        return this.u;
    }

    public int u() {
        JSONObject jSONObjectTc;
        int i = this.an;
        if (i != -1) {
            return i;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return 0;
        }
        hc(jSONObjectTc);
        return this.an;
    }

    public int an() {
        JSONObject jSONObjectTc;
        int i = this.h;
        if (i != -1) {
            return i;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return 5000;
        }
        hc(jSONObjectTc);
        return this.h;
    }

    public synchronized boolean h() {
        JSONObject jSONObjectTc;
        int i = this.gb;
        if (i != -1) {
            return i == 1;
        }
        if (this.hc == null || (jSONObjectTc = tc()) == null) {
            return false;
        }
        hc(jSONObjectTc);
        return this.gb == 1;
    }

    public int gb() {
        return this.gb;
    }

    public boolean tt() {
        JSONObject jSONObjectTc;
        int i = this.tt;
        if (i != -1) {
            return i == 1;
        }
        if (this.hc != null && (jSONObjectTc = tc()) != null) {
            hc(jSONObjectTc);
            if (this.tt == 1) {
                return true;
            }
        }
        return false;
    }
}
