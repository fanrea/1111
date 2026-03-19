package com.kwad.components.core.c;

import android.util.SparseArray;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d Pp = null;
    private static boolean Pq = true;
    private final SparseArray<c> Po;

    static /* synthetic */ boolean a(d dVar) {
        return om();
    }

    public static d ol() {
        if (Pp == null) {
            synchronized (d.class) {
                if (Pp == null) {
                    Pp = new d();
                }
            }
        }
        return Pp;
    }

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.Po = sparseArray;
        sparseArray.append(0, new n());
        sparseArray.append(1, new m());
        sparseArray.append(2, new l());
    }

    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.aci().submit(new bh() { // from class: com.kwad.components.core.c.d.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                final e eVarX = e.x(aVar.getPosId());
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.c.d.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.b(eVarX);
                    }
                });
                c cVar = (d.a(d.this) || !(eVarX.isDefault() || eVarX.isEnable())) ? (c) d.this.Po.get(0) : (c) d.this.Po.get(eVarX.op());
                if (cVar == null) {
                    cVar = (c) d.this.Po.get(1);
                }
                com.kwad.components.core.request.j jVarSI = aVar.sI();
                if (jVarSI != null) {
                    cVar.getName();
                    jVarSI.al();
                }
                d dVar = d.this;
                d.a(aVar, cVar);
                com.kwad.sdk.commercial.d.d.e(aVar.Tk.adScene, aVar.sJ());
                cVar.d(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.aJ("network_first");
        } else if (name.equals("StrategyLocalCacheFirst")) {
            aVar.aJ("cache_first");
        } else {
            aVar.aJ("network_only");
        }
    }

    private static boolean om() throws ClassNotFoundException {
        if (!Pq) {
            return false;
        }
        try {
        } catch (ClassNotFoundException unused) {
            Pq = false;
        }
        if (com.kwad.sdk.components.g.ev("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
            return false;
        }
        Class.forName("com.kwad.devTools.PosConfigFetcher");
        Pq = true;
        return Pq;
    }
}
