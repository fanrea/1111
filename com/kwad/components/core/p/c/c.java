package com.kwad.components.core.p.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static void a(d dVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_offline_component_update", "load_status").w(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
    }

    public static void d(String str, long j, String str2) {
        try {
            a(new d().aB(str).aD(str2).I(j).H(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, int i, String str2, String str3) {
        try {
            a(new d().aB(str).I(j).setErrorCode(i).aD(str2).aC(str3).H(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, long j2, String str2) {
        try {
            a(new d().aB(str).I(j).J(j2).aD(str2).H(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
