package com.bytedance.msdk.b.c;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.core.u.hc.c;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends hc implements com.bytedance.msdk.core.u.hc.hc {
    public b(Context context) {
        super(context);
    }

    @Override // com.bytedance.msdk.core.u.hc.hc
    public void d(Context context, com.bytedance.msdk.api.d.hc hcVar, c.b bVar) {
        d(hcVar);
        this.b.hc(true);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.b.d(jCurrentThreadTimeMillis);
        this.b.d(bVar);
        com.bytedance.msdk.core.u.hc.c.d().d(this.u, jCurrentThreadTimeMillis);
        tt();
    }

    @Override // com.bytedance.msdk.core.u.hc.hc
    public int e_() {
        if (this.b != null) {
            return this.b.he();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.core.u.hc.hc
    public ConcurrentHashMap<String, com.bytedance.msdk.api.hc> b() {
        if (this.b != null) {
            return this.b.np();
        }
        return null;
    }

    @Override // com.bytedance.msdk.core.u.hc.hc
    public com.bytedance.msdk.b.an.d.hc c() {
        return this.b;
    }
}
