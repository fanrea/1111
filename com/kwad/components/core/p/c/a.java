package com.kwad.components.core.p.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    private static void a(b bVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_offline_component_monitor", "load_status").w(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
    }

    public static void c(String str, long j) {
        try {
            a(new b().ay(str).G(j).F(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, int i, String str2, String str3) {
        try {
            a(new b().ay(str).G(j).setErrorCode(i).aA(str3).az(str2).F(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, int i) {
        try {
            a(new b().ay(str).G(j).aR(i).F(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, String str2) {
        try {
            a(new b().ay(str).aA(str2).G(j).F(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, String str2) {
        try {
            a(new b().ay(str).G(j).aA(str2).F(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, String str2) {
        try {
            a(new b().ay(str).G(j).aA(str2).F(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j) {
        try {
            a(new b().ay(str).G(j).F(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, int i) {
        try {
            a(new b().ay(str).F(8L).aR(i).G(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
