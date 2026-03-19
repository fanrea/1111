package com.android.gdt.qone.ag;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.gdt.oaid2.VendorManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f implements Runnable {
    public final /* synthetic */ com.android.gdt.qone.ak.l a;
    public final /* synthetic */ o b;

    public f(o oVar, com.android.gdt.qone.ak.l lVar) {
        this.b = oVar;
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        com.android.gdt.qone.w.c cVar;
        String strC = com.android.gdt.qone.ad.h.a(this.b.a).c("is_first");
        com.android.gdt.qone.av.a aVar = com.android.gdt.qone.at.a.a(this.b.a).a;
        if (!aVar.a || !aVar.e || !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.g, aVar.l).booleanValue() || TextUtils.isEmpty(strC)) {
            this.a.a(2);
            return;
        }
        if (!com.android.gdt.qone.w.a.g()) {
            com.android.gdt.qone.at.a.a(this.b.a);
            this.a.a(5);
            return;
        }
        o oVar = this.b;
        com.android.gdt.qone.ak.l lVar = this.a;
        oVar.c = false;
        com.android.gdt.qone.v.a.a().a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, new g(oVar, lVar));
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        h hVar = new h(oVar, lVar);
        if (cVar.h != null) {
            return;
        }
        cVar.b = SystemClock.elapsedRealtime();
        new VendorManager().getVendorInfo(cVar.a, new com.android.gdt.qone.w.b(cVar, hVar));
    }
}
