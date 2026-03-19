package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private static void a(final SceneImpl sceneImpl, final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.sdk.commercial.d.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.001d).b(com.kwad.sdk.commercial.d.ef(sceneImpl.getAdStyle())).V("ad_convert_method_call", "method_name").w(aVar));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public static void q(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.WC().ea("loadRequest").en(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.WC().ea("requestStart").en(sceneImpl.getAdNum()).eb(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.WC().ea("requestFinish").en(sceneImpl.getAdNum()).eb(str).ec(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(SceneImpl sceneImpl, int i) {
        try {
            a(sceneImpl, b.WC().ea("dataReady").en(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).b(com.kwad.sdk.commercial.d.ef(i)).V("ad_convert_method_call", "method_name").w(b.WC().ea("requestError").eb(str2).setErrorCode(com.kwad.sdk.commercial.d.eg(i2)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
