package com.bytedance.bdtracker;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i0 extends c0 {
    public static final long[] h = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT};
    public final c3 g;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ Set a;
        public final /* synthetic */ boolean b;

        public a(Set set, boolean z) {
            this.a = set;
            this.b = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$$APP_ID", i0.this.f.m);
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.b ? "success" : com.alipay.sdk.m.u.h.i);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public i0(e0 e0Var) {
        super(e0Var);
        this.g = new c3("sender_", e0Var.e);
    }

    public final void a(Set<String> set, boolean z) {
        if (set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(set, z));
    }

    public boolean a(c4 c4Var) {
        q3 q3Var = this.f.j;
        e0 e0Var = this.e;
        String[] strArrA = q3Var.a(e0Var, e0Var.i.e(), c4Var.l);
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(new String(c4Var.z));
            jSONObject.put("local_time", System.currentTimeMillis() / 1000);
            int iA = this.f.k.a(strArrA, jSONObject, this.e.e);
            if (iA != 200) {
                if (iA >= 500 && iA < 600) {
                    this.g.b();
                }
                l2.a(this.e.q, 13L, this.e.d(), iA);
                this.e.d.D.error(4, "Send pack failed:{}", Integer.valueOf(iA));
                c4Var.A++;
                a(c4Var.l(), false);
                return false;
            }
            this.g.c();
            c4Var.A = 0;
            try {
                a(c4Var.l(), true);
                this.e.c().a(jSONObject);
                return true;
            } catch (Throwable th) {
                th = th;
                this.e.d.D.error(4, "Send pack failed", th, new Object[0]);
                a(c4Var.l(), false);
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.bdtracker.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.i0.c():boolean");
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "sender";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long g() {
        q1 q1Var = this.e.e;
        return q1Var.a(q1Var.q) ? q1Var.q : q1Var.f.getLong("batch_event_interval", 60000L);
    }
}
