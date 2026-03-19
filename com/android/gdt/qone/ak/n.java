package com.android.gdt.qone.ak;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class n implements Runnable {
    public final h a;
    public final String b;

    public n(h hVar, String str) {
        this.a = hVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        String str = this.b;
        int i = com.android.gdt.qone.ap.f.a;
        boolean zA = com.android.gdt.qone.ae.d.a(com.android.gdt.qone.ad.h.a(str).b("q_s_t"), 24L);
        if (zA) {
            com.android.gdt.qone.af.c.b("SDK_INIT ｜ QM", "more than 24 hours since last QM request", new Object[0]);
        }
        if (zA) {
            com.android.gdt.qone.v.a.a().a(this.a);
        }
        com.android.gdt.qone.ap.f.a(this);
    }
}
