package com.bytedance.d.hc.c;

import android.content.Context;
import com.bytedance.d.hc.gb.c;
import com.bytedance.d.hc.u.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements hc {
    private Context d;

    @Override // com.bytedance.d.hc.c.hc
    public boolean d(Throwable th) {
        return true;
    }

    @Override // com.bytedance.d.hc.c.hc
    public void d(long j, Thread thread, Throwable th) throws Throwable {
        com.bytedance.d.hc.b.d dVarD = com.bytedance.d.hc.b.d.d(j, this.d, thread, th);
        c.d(this.d, com.bytedance.d.hc.b.JAVA.d(), Thread.currentThread().getName());
        com.bytedance.d.hc.h.d.d().d(u.d().d(com.bytedance.d.hc.b.JAVA, dVarD).d());
    }

    public b(Context context) {
        this.d = context;
    }
}
