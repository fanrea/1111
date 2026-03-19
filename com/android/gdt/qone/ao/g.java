package com.android.gdt.qone.ao;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.sigmob.sdk.base.n;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = j.f;
        j jVar = i.a;
        h hVar = this.a;
        String str2 = hVar.a;
        String str3 = hVar.b;
        synchronized (jVar) {
            jVar.a = str2;
            jVar.b = str3;
            jVar.c = str2 + str3;
            com.android.gdt.qone.u.d dVar = jVar.d;
            if (dVar == null) {
                if (dVar == null) {
                    com.android.gdt.qone.u.d dVar2 = new com.android.gdt.qone.u.d(jVar, jVar.c);
                    jVar.d = dVar2;
                    dVar2.a();
                }
                Bundle bundle = new Bundle();
                bundle.putString("spread_data", c.a(jVar.e, j.f));
                bundle.putString("appKey", jVar.a);
                bundle.putString(n.l, jVar.b);
                com.android.gdt.qone.u.a.a("com.qone.qm.spread", "", bundle);
                com.android.gdt.qone.af.c.b("SpreadQM", "%s-%s | send implicit broadcast", jVar.a, jVar.b);
            }
        }
        com.android.gdt.qone.v.a.a().a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, new f(this));
    }
}
