package com.kwad.components.ad.reward.c;

import android.content.Context;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a vU;
    private b vV;
    private volatile boolean vW = false;
    private volatile boolean vX = false;
    private List<WeakReference<j>> vY = new CopyOnWriteArrayList();
    private g vb;

    public static a hZ() {
        if (vU == null) {
            synchronized (a.class) {
                if (vU == null) {
                    vU = new a();
                }
            }
        }
        return vU;
    }

    private a() {
    }

    public final synchronized void reset() {
        this.vV = null;
        this.vX = false;
        this.vW = false;
        this.vb = null;
    }

    public final void setCallerContext(g gVar) {
        this.vb = gVar;
    }

    public final synchronized void c(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        g gVar = this.vb;
        if (gVar != null && gVar.ha() && i == b.STATUS_NONE) {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b bVarIa = hZ().ia();
        bVarIa.aa(i);
        hZ().a(adTemplate, bVarIa);
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.vV = bVar;
        if (bVar.wc == b.vZ && !this.vW) {
            this.vW = true;
            c.a(this.vV, com.kwad.components.ad.reward.e.f.P(adTemplate.getUniqueId()));
            com.kwad.sdk.core.adlog.c.j(adTemplate, isNeoScan());
        }
        for (WeakReference<j> weakReference : this.vY) {
            if (weakReference.get() == null) {
                this.vY.remove(weakReference);
            } else {
                b bVarIa = ia();
                com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + bVarIa.toJson().toString());
                weakReference.get().a(bVarIa);
            }
        }
    }

    private boolean isNeoScan() {
        return this.vb.mAdResultData.adGlobalConfigInfo != null && this.vb.mAdResultData.adGlobalConfigInfo.neoPageType == 1;
    }

    public final synchronized b ia() {
        if (this.vV == null) {
            b bVarId = c.id();
            this.vV = bVarId;
            bVarId.wc = 0;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.vV.wc);
        return this.vV;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean ib() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.kwad.components.ad.reward.c.b r0 = r2.vV     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            int r0 = r0.wc     // Catch: java.lang.Throwable -> L10
            int r1 = com.kwad.components.ad.reward.c.b.vZ     // Catch: java.lang.Throwable -> L10
            if (r0 != r1) goto Le
            r0 = 1
        Lc:
            monitor-exit(r2)
            return r0
        Le:
            r0 = 0
            goto Lc
        L10:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.c.a.ib():boolean");
    }

    public final void a(j jVar) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + jVar);
        if (jVar != null) {
            this.vY.add(new WeakReference<>(jVar));
        }
    }

    public final void R(Context context) {
        boolean zIb = ib();
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + zIb + ", hadToast: " + this.vX);
        if (this.vX || !zIb) {
            return;
        }
        this.vX = true;
        ac.ae(context, "恭喜获得第2份奖励");
    }
}
