package com.bytedance.msdk.api.c.d.hc.an;

import android.content.Context;
import com.bytedance.msdk.api.c.d.hc.b.hc;
import com.bytedance.sdk.openadsdk.core.ba.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends c {
    private static final String b = "TTMediationSDK_d";
    private hc c;
    private final AtomicBoolean u = new AtomicBoolean(false);
    protected long d = 0;
    protected int hc = 0;

    public abstract String d();

    public String d(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void d(Context context, hc hcVar, Map<String, Object> map);

    public abstract String hc();

    public String hc(Context context, Map<String, Object> map) {
        return null;
    }

    public final void b() {
        this.u.set(true);
    }

    public final boolean c() {
        return this.u.get();
    }

    public final void hc(Context context, hc hcVar, Map<String, Object> map) {
        this.u.set(false);
        this.c = hcVar;
        d(context, hcVar, map);
    }

    public long u() {
        return this.d;
    }

    public int an() {
        return this.hc;
    }

    public void h() {
        this.hc = 0;
        this.d = 0L;
    }
}
