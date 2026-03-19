package com.kwad.sdk.core.adlog.a;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private final c bvJ;
    private final List<com.kwad.sdk.core.adlog.a.a> bvK;

    /* synthetic */ b(byte b) {
        this();
    }

    static final class a {
        private static final b bvM = new b(0);
    }

    private b() {
        this.bvK = new CopyOnWriteArrayList();
        this.bvJ = (c) aa.b(((h) ServiceProvider.get(h.class)).UC(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b Le() {
                return Xo();
            }

            private static c Xo() {
                return new c();
            }
        });
    }

    public static b Xi() {
        return a.bvM;
    }

    public final void a(com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (Xm()) {
                return;
            }
            if (!Xn() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        a.C0576a c0576a = aVar2.Xt() == null ? new a.C0576a() : aVar2.Xt();
                        c0576a.bvi = 1;
                        aVar2.a(c0576a);
                        aa.putValue(jSONObject, "clientExtData", aVar2.QY.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.Xh().eB(str).m(jSONObject).c(aVar2).aR(System.currentTimeMillis());
                }
                aVar.ew(i).eC(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.bvJ, this.bvK.size());
                if (aVar.retryCount >= this.bvJ.bvO) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, this.bvJ, this.bvK.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.bvK.size() >= this.bvJ.bvQ) {
                    com.kwad.sdk.core.adlog.a.a aVarXk = Xk();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.bvK.size() + ", remove log：" + aVarXk);
                    com.kwad.sdk.core.adlog.b.a.e(aVarXk, this.bvJ, this.bvK.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.bvK.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.bvJ, this.bvK.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void Xj() {
        try {
            if (Xm() || ap.aF(this.bvK)) {
                return;
            }
            bx.runOnUiThread(new bh() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Xf();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.bvK.add(aVar);
    }

    private synchronized com.kwad.sdk.core.adlog.a.a Xk() {
        if (ap.aF(this.bvK)) {
            return null;
        }
        return this.bvK.remove(0);
    }

    public final com.kwad.sdk.core.adlog.a.a Xl() {
        com.kwad.sdk.core.adlog.a.a aVarXk = Xk();
        if (aVarXk == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(aVarXk, this.bvJ, this.bvK.size());
        long jCurrentTimeMillis = System.currentTimeMillis() - aVarXk.bvG;
        if (jCurrentTimeMillis > this.bvJ.bvP * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(aVarXk, this.bvJ, this.bvK.size(), jCurrentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + jCurrentTimeMillis + ", adLogCache：" + aVarXk);
            return null;
        }
        aVarXk.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(aVarXk, this.bvJ, this.bvK.size(), jCurrentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + aVarXk);
        return aVarXk;
    }

    private boolean Xm() {
        c cVar = this.bvJ;
        return cVar == null || !cVar.bvN;
    }

    private boolean Xn() {
        c cVar = this.bvJ;
        return cVar != null && cVar.bvR;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        return aVar.buM == 1 || aVar.buM == 2;
    }
}
