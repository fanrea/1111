package com.android.gdt.qone.ak;

import android.text.TextUtils;
import com.android.gdt.qone.report.beat.BeatType;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class k implements Runnable {
    public final /* synthetic */ o a;

    public k(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.android.gdt.qone.ae.f.a().a(this.a.d);
        com.android.gdt.qone.aa.b.a().a(this.a.e);
        com.android.gdt.qone.aa.b bVarA = com.android.gdt.qone.aa.b.a();
        o oVar = this.a;
        String str = oVar.d;
        synchronized (bVarA) {
            bVarA.a.put(oVar, str);
        }
        com.android.gdt.qone.at.a.a(this.a.d).b();
        c.a(this.a.d).a();
        com.android.gdt.qone.aj.c.a(this.a.d, BeatType.INIT, "0");
        String str2 = this.a.d;
        if (TextUtils.isEmpty(com.android.gdt.qone.ad.h.a(str2).c("is_first"))) {
            com.android.gdt.qone.v.a.a().a(r1 * 1000, new com.android.gdt.qone.am.b(com.android.gdt.qone.ap.g.a.nextInt(3) + 1, str2));
        }
        q qVarB = q.b(this.a.d);
        if (qVarB.e.equals("1")) {
            String str3 = qVarB.a;
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", "1010");
            cVarA.a.put("7", "1");
            fVarA.a(cVarA, com.alipay.sdk.m.x.c.d, str3);
        }
        o oVar2 = this.a;
        oVar2.getClass();
        oVar2.b(new m(oVar2));
    }
}
