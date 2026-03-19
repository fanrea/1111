package com.bytedance.sdk.component.gb.hc.hc.d;

import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.gb;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.gb.hc.hc.hc;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private StringBuffer d = new StringBuffer();
    private AtomicLong hc = new AtomicLong(0);
    private AtomicLong b = new AtomicLong(0);
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong u = new AtomicLong(0);
    private AtomicLong an = new AtomicLong(0);
    private AtomicLong h = new AtomicLong(0);
    private AtomicLong gb = new AtomicLong(0);
    private AtomicLong tt = new AtomicLong(0);
    private AtomicLong tc = new AtomicLong(0);
    private AtomicLong mk = new AtomicLong(0);
    private AtomicLong mq = new AtomicLong(0);
    private AtomicLong uo = new AtomicLong(0);
    private AtomicLong k = new AtomicLong(0);
    private AtomicLong e = new AtomicLong(0);
    private AtomicLong cb = new AtomicLong(0);
    private AtomicLong w = new AtomicLong(0);
    private AtomicLong yo = new AtomicLong(0);
    private AtomicLong rf = new AtomicLong(0);
    private AtomicLong jh = new AtomicLong(0);
    private AtomicLong sy = new AtomicLong(0);
    private AtomicLong de = new AtomicLong(0);
    private AtomicLong v = new AtomicLong(0);
    private AtomicLong np = new AtomicLong(0);

    public AtomicLong d() {
        return this.np;
    }

    public AtomicLong hc() {
        return this.v;
    }

    public AtomicLong b() {
        return this.de;
    }

    public AtomicLong c() {
        return this.sy;
    }

    public AtomicLong u() {
        return this.uo;
    }

    public synchronized void d(long j) {
        this.hc.getAndAdd(j);
        this.b.incrementAndGet();
    }

    public JSONObject d(long j, u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = tt().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (mq().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = gb().get();
            jSONObject.put("save_upload_cost_ts_avg", (uo().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.uo.get());
            jSONObject.put("all_delete_count", k().get());
            jSONObject.put("success_delete_count", e().get());
            jSONObject.put("invalid_delete_count", cb().get());
            jSONObject.put("will_save_count", w().get());
            jSONObject.put("did_send_count", tc().get());
            jSONObject.put("send_success_valid_count", yo().get());
            long j5 = h().get();
            jSONObject.put("send_success_invalid_count", rf().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", mk().get());
            jSONObject.put("success_tm", c().get());
            jSONObject.put("queue_timeout_tm", b().get());
            jSONObject.put("after_upload_tm", hc().get());
            jSONObject.put("quit_tm", d().get());
            long j6 = sy().get();
            long j7 = de().get();
            jSONObject.put("success_request_cost_ts_avg", (v().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = np().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", jh().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", uVar.mk());
            jSONObject.put("app_start_time", hc.b);
            jSONObject.put("app_first_time", hc.c);
            jSONObject.put("fail_code_list", this.d.toString());
            c cVarC = uVar.c();
            if (cVarC != null) {
                jSONObject.put("is_debug", cVarC.d());
                gb gbVarMq = cVarC.mq();
                if (gbVarMq != null) {
                    jSONObject.put("is_plugin", gbVarMq.gb());
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return jSONObject;
    }

    public synchronized void an() {
        uo().set(0L);
        sy().set(0L);
        de().set(0L);
        jh().set(0L);
        np().set(0L);
        v().set(0L);
        rf().set(0L);
        yo().set(0L);
        cb().set(0L);
        mq().set(0L);
        k().set(0L);
        w().set(0L);
        e().set(0L);
        tc().set(0L);
        gb().set(0L);
        tt().set(0L);
        h().set(0L);
        mk().set(0L);
        c().set(0L);
        b().set(0L);
        hc().set(0L);
        d().set(0L);
        try {
            if (this.d.length() != 0) {
                this.d.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong h() {
        return this.tt;
    }

    public AtomicLong gb() {
        return this.u;
    }

    public AtomicLong tt() {
        return this.b;
    }

    public AtomicLong tc() {
        return this.mk;
    }

    public AtomicLong mk() {
        return this.jh;
    }

    public AtomicLong mq() {
        return this.hc;
    }

    public AtomicLong uo() {
        return this.c;
    }

    public AtomicLong k() {
        return this.an;
    }

    public AtomicLong e() {
        return this.h;
    }

    public AtomicLong cb() {
        return this.gb;
    }

    public AtomicLong w() {
        return this.tc;
    }

    public AtomicLong yo() {
        return this.mq;
    }

    public AtomicLong rf() {
        return this.k;
    }

    public AtomicLong jh() {
        return this.e;
    }

    public AtomicLong sy() {
        return this.cb;
    }

    public AtomicLong de() {
        return this.w;
    }

    public AtomicLong v() {
        return this.yo;
    }

    public AtomicLong np() {
        return this.rf;
    }

    public StringBuffer yi() {
        return this.d;
    }
}
