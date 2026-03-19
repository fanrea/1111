package com.baidu.mobads.container.y;

import android.content.Context;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.y.k;
import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ com.baidu.mobads.container.adrequest.j b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ k e;

    m(k kVar, Context context, com.baidu.mobads.container.adrequest.j jVar, String str, String str2) {
        this.e = kVar;
        this.a = context;
        this.b = jVar;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ax axVarB;
        if (this.e.d.size() >= this.e.f) {
            axVarB = this.e.a((SoftReference<ax>) ((k.a) this.e.d.remove(0)).b);
            this.e.a(axVarB);
        } else {
            axVarB = null;
        }
        if (axVarB == null) {
            axVarB = this.e.b(this.a, true);
        }
        if (axVarB != null) {
            this.e.a(axVarB, this.a, true);
            String clickThroughUrl = this.b.getClickThroughUrl();
            axVarB.a(new c(this.c, this.d, this.b));
            axVarB.a(new b());
            axVarB.loadUrl(clickThroughUrl);
            this.e.d.add(new k.a(clickThroughUrl, axVarB));
        }
    }
}
