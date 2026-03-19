package com.kwad.components.core.request;

import android.content.Context;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean YL = false;
    private static final List<a> YM = new CopyOnWriteArrayList();

    public interface a {
        void d(SdkConfigData sdkConfigData);

        void sF();
    }

    public interface b extends a {
        void sG();
    }

    static /* synthetic */ boolean access$102(boolean z) {
        YL = true;
        return true;
    }

    public static synchronized void a(a aVar) {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
        if (sHasInit.get()) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
        } else {
            YM.add(aVar);
            com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.core.request.h.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    Context contextAnu = ServiceProvider.anu();
                    ag.o(contextAnu, ag.dK(contextAnu) + 1);
                    com.kwad.sdk.core.config.e.bF(contextAnu);
                    h.sC();
                    h.sB();
                }
            });
        }
    }

    public static void b(a aVar) {
        try {
            YM.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.sF();
            }
            if (YL) {
                aVar.d(com.kwad.sdk.core.config.e.Yi());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void sB() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aI(str);
            }

            private static SdkConfigData aI(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ag.aB(ServiceProvider.anu(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: sE, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.abG();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }

            private static void c(SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.aa("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bD(ServiceProvider.anu());
                    com.kwad.sdk.core.config.e.g(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    af.aor();
                    af.aol();
                    ag.o(ServiceProvider.anu(), 0);
                    if (ag.aow() != com.kwad.sdk.core.config.e.YX()) {
                        ag.g(ServiceProvider.anu(), com.kwad.sdk.core.config.e.YX());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(g gVar, int i, String str) {
                super.onError(gVar, i, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                h.m(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sC() {
        Iterator<a> it = YM.iterator();
        while (it.hasNext()) {
            try {
                it.next().sF();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(SdkConfigData sdkConfigData) {
        Iterator<a> it = YM.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(int i, String str) {
        for (a aVar : YM) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).sG();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
