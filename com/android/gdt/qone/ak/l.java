package com.android.gdt.qone.ak;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class l {
    public final /* synthetic */ o a;

    public l(o oVar) {
        this.a = oVar;
    }

    public final void a(int i) throws JSONException {
        com.android.gdt.qone.af.c.b("SDK_INIT", "OD initialization finished (appKey: %s)，result:%s", this.a.d, Integer.valueOf(i));
        o oVar = this.a;
        String str = oVar.d;
        if (com.android.gdt.qone.w.a.g()) {
            q.b(oVar.d).b();
        }
        oVar.m();
    }
}
